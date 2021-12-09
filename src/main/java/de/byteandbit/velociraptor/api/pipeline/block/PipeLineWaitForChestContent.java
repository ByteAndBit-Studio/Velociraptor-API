package de.byteandbit.velociraptor.api.pipeline.block;

import com.google.common.collect.ImmutableList;
import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.VelociraptorAPI;
import de.byteandbit.velociraptor.api.pipeline.PipelineExecutor;
import de.byteandbit.velociraptor.data.chest.ChestInventory;
import de.byteandbit.velociraptor.api.event.EventHandler;
import de.byteandbit.velociraptor.api.event.api.PacketReceiveEvent;
import de.byteandbit.velociraptor.helper.AreaHelper;
import de.byteandbit.velociraptor.helper.ChestHelper;
import de.byteandbit.velociraptor.helper.ThreadHelper;
import de.byteandbit.velociraptor.module.warehouse.WarehouseManager;
import de.byteandbit.velociraptor.module.warehouse.WarehouseModule;
import de.byteandbit.velociraptor.api.pipeline.PipelineBlock;
import lombok.AllArgsConstructor;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.util.math.BlockPos;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

public class PipeLineWaitForChestContent extends PipelineBlock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile OpenChestTimeoutThread openTimeout;
    private volatile TimeoutThread timeout;
    private Map<Integer, ChestInventory> dataMap;
    private Map<Integer, Long> lastModified;

    private int offset = 0;
    private int current = 0;

    private List<BlockPos> chests;
    private Consumer<Collection<ChestInventory>> chestConsumer;

    public PipeLineWaitForChestContent(PipelineExecutor executor, List<BlockPos> chests, Consumer<Collection<ChestInventory>> chestConsumer) {
        super(executor);
        this.chests = chests;
        this.chestConsumer = chestConsumer;
        this.lastModified = new HashMap<>();
    }

    private void nextChest() {
        lock.readLock().lock();
        if(current < chests.size()) {
            if(timeout != null) {
                timeout.interrupt();
                timeout.stop();
            }

            timeout = new TimeoutThread(this);
            timeout.start();

            new Thread(() -> {
                ThreadHelper.chestOpenDelayPipeline();

                if(!AreaHelper.isOnBotPos()) {
                    endScan(true, false);
                    return;
                }

                lock.readLock().lock();

                if(current < chests.size()) {
                    if(!ChestHelper.openChest(chests.get(current))) {
                        lock.readLock().unlock();
                        endScan(true, false);
                        return;
                    }

                    lock.readLock().unlock();

                    openTimeout = new OpenChestTimeoutThread(this);
                    openTimeout.start();
                }

            }).start();
        }

        lock.readLock().unlock();
    }

    @Override
    public void setActive() {
        WarehouseManager manager = ((WarehouseModule) Velociraptor.getInstance().getModuleManager().getModule(WarehouseModule.class)).getManager();
        manager.setScanCount(0);

        dataMap = new ConcurrentHashMap<>();
        VelociraptorAPI.EVENT_BUS.register(this);
        super.setActive();

        nextChest();
        Velociraptor.getLogger().debug("DEBUG: Der Pipeline-Block für WaitForChestContent wurde aktiviert");
    }

    @EventHandler
    public void onPacketReceive(PacketReceiveEvent event) {
        lock.writeLock().lock();

        if(!pipelineBlock) {
            lock.writeLock().unlock();
            return;
        }

        if(event.getPacket() instanceof SPacketOpenWindow) {
            WarehouseManager manager = ((WarehouseModule) Velociraptor.getInstance().getModuleManager().getModule(WarehouseModule.class)).getManager();
            manager.setScanCount(manager.getScanCount() + 1);

            handleOpenWindow(event);
            event.setIntercept(true);

            if(timeout != null) {
                timeout.interrupt();
                timeout.stop();
            }

            timeout = new TimeoutThread(this);
            timeout.start();
        }

        if(event.getPacket() instanceof SPacketSetSlot) {
            handleSetSlot(event);
            event.setIntercept(true);

            if(timeout != null) {
                timeout.interrupt();
                timeout.stop();
            }

            timeout = new TimeoutThread(this);
            timeout.start();
        }

        lock.writeLock().unlock();
    }

    private void handleSetSlot(PacketReceiveEvent event) {
        SPacketSetSlot packet = (SPacketSetSlot) event.getPacket();
        lastModified.put(packet.getWindowId()+offset, System.currentTimeMillis());

        if(dataMap.containsKey(packet.getWindowId()+offset)) {
            ChestInventory data = dataMap.get(packet.getWindowId()+offset);
            if(packet.getSlot() >= data.getSlots()) {
                return;
            }

            data.getStacks().add(packet.getStack());
        }
    }

    private void handleOpenWindow(PacketReceiveEvent event) {
        SPacketOpenWindow packet = (SPacketOpenWindow) event.getPacket();
        if(packet.getWindowTitle().getFormattedText().toLowerCase().contains("afk")) return;
        if(!packet.getGuiId().equals("minecraft:chest")) return;
        if(lastModified.containsKey(packet.getWindowId()+offset)) {
            offset += 100;
        }

        lastModified.put(packet.getWindowId()+offset, System.currentTimeMillis());

        try {
            dataMap.put(packet.getWindowId()+offset, new ChestInventory(packet.getSlotCount(), chests.get(current)));
        }
        catch(Exception ex) {
            Velociraptor.getLogger().error("Fehler in der Pipeline", ex);
            endScan(true, false);
            return;
        }

        current++;
    }

    private void endScan(boolean failed, boolean calledFromTimeout) {
        lock.writeLock().lock();

        try {
            if(timeout != null  && !calledFromTimeout) timeout.interrupt();
            if(timeout != null && !calledFromTimeout) timeout.stop();
            if(openTimeout != null) openTimeout.interrupt();
            if(openTimeout != null) openTimeout.stop();
        }
        catch(Exception ex) {
            Velociraptor.getLogger().debug("PipelineWaitForChestContent#endScan", ex);
        }

        pipelineBlock = false;
        VelociraptorAPI.EVENT_BUS.unregister(this);

        if(failed) Velociraptor.getLogger().info("Die Pipeline hat das Chest Scannen mit einem Fehler beendet");
        else Velociraptor.getLogger().info("Die Pipeline hat das Chest Scannen beendet");

        List<ChestInventory> data = ImmutableList.copyOf(dataMap.values());
        lock.writeLock().unlock();

        if(failed) chestConsumer.accept(null);
        else chestConsumer.accept(data);

    }

    @AllArgsConstructor
    private class OpenChestTimeoutThread extends Thread {
        private PipeLineWaitForChestContent instance;

        @Override
        public void run() {
            if(!instance.pipelineBlock) return;

            try {
                sleep(Velociraptor.getInstance().getConfigManager().getWarehouseSettings().getChestOpenPacketTimeoutNew());
            } catch (InterruptedException e) {
                return;
            }

            nextChest();
        }
    }

    @AllArgsConstructor
    private class TimeoutThread extends Thread {
        private PipeLineWaitForChestContent instance;

        @Override
        public void run() {
            try {
                sleep(Velociraptor.getInstance().getConfigManager().getWarehouseSettings().getChestPacketTimeout());
            } catch (InterruptedException e) {
                return;
            }

            boolean failed = current != chests.size();
            instance.endScan(failed, true);
        }
    }

}