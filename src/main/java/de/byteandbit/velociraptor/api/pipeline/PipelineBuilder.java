package de.byteandbit.velociraptor.api.pipeline;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.data.chest.ChestInventory;
import de.byteandbit.velociraptor.data.chest.ChestType;
import de.byteandbit.velociraptor.module.warehouse.WarehouseModule;
import de.byteandbit.velociraptor.api.pipeline.actions.*;
import de.byteandbit.velociraptor.api.pipeline.block.PipeLineWaitForChestContent;
import de.byteandbit.velociraptor.transaction.transactions.Transaction;
import net.minecraft.util.math.BlockPos;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PipelineBuilder {

    private Pipeline pipeline;

    public PipelineBuilder() {
        pipeline = new Pipeline();
    }

    public PipelineBuilder message(String player, String message) {
        message = message.replace("%besitzer%", Velociraptor.getInstance().getConfigManager().getNotificationSettings().getBotOwner());
        message = message.replace("%player%", player);
        pipeline.addElement(new PipelineSendCommandAction(String.format("msg %s %s", player, message), false, false));
        return this;
    }

    public PipelineBuilder commandDelayed(String command, Object... arguments) {
        pipeline.addElement(new PipelineSendCommandAction(String.format(command, arguments), true, false));
        return this;
    }

    public PipelineBuilder command(String command, Object... arguments) {
        pipeline.addElement(new PipelineSendCommandAction(String.format(command, arguments), false, false));
        return this;
    }
    public PipelineBuilder shutdown(){
        pipeline.addElement(new PipelineShutdownAction());
        return this;
    }

    public PipelineBuilder highPrioCommand(String command, Object... arguments) {
        pipeline.addElement(new PipelineSendCommandAction(String.format(command, arguments), false, true));
        return this;
    }

    public PipelineBuilder globalLock() {
        pipeline.addElement(new PipelineLockAction());
        return this;
    }

    public PipelineBuilder unlock() {
        pipeline.addElement(new PipelineUnlockAction());
        return this;
    }

    public PipelineBuilder updateTransaction(Transaction transaction, Consumer<Transaction> updateFunction) {
        pipeline.addElement(new PipelineUpdateTransactionAction(transaction, updateFunction));
        return this;
    }

    public PipelineBuilder executeAction(PipelineAction action) {
        pipeline.addElement(action);
        return this;
    }

    public PipelineBuilder wait(int ms) {
        pipeline.addElement(new PipelineWaitAction(ms));
        return this;
    }

    public PipelineBuilder waitForPayment(String player, double amount, Consumer<Boolean> consumer) {
        pipeline.addElement(new PipelineWaitForChat(chatMessage -> {
            Pattern payValidPattern = Pattern.compile(".+Du hast.+┃ §r[§0-9a-zA-Z!~_]+§r§a \\$[0-9.,]+ gegeben.§r");

            if(!payValidPattern.matcher(chatMessage.getUnformatted()).matches()) {
                return false;
            }

            String[] message = chatMessage.getFormatted().split(" ");
            String myPlayer = message[4];
            double myAmount = Double.valueOf(message[5].replace("$", "").replace(",", ""));

            String myAmountS = String.format("%.2f", myAmount);
            String amountS = String.format("%.2f", amount);

            Velociraptor.getLogger().debug(String.format("DEBUG: PipelineBuilder#waitForPayment(player=%s,amount=%.2f)", player, amount));

            if(!myPlayer.equals(player)) return false;
            if(!myAmountS.equals(amountS)) return false;

            return true;
        }, Velociraptor.getInstance().getConfigManager().getPipelineSettings().getPayTimeout(), consumer));

        return this;
    }

    public PipelineBuilder wait(PipelineBlock block) {
        pipeline.addElement(block);
        return this;
    }

    public PipelineBuilder scanWarehouse(PipelineExecutor executor, Consumer<Collection<ChestInventory>> chestConsumer){
        return scanAll(executor, ((WarehouseModule)Velociraptor.getInstance().getModuleManager().getModule(WarehouseModule.class)).getManager()
                .getChests()
                .stream()
                .filter(chest -> chest.getType() == ChestType.WAREHOUSE)
                .map(chest -> chest.getPos()).collect(Collectors.toList()), chestConsumer);
    }

    public PipelineBuilder scanAll(PipelineExecutor executor, List<BlockPos> chests, Consumer<Collection<ChestInventory>> chestConsumer){
        pipeline.addElement(new PipeLineWaitForChestContent(executor, chests, chestConsumer));
        return this;
    }

    public PipelineBuilder broadcastPacket(String event, Object packet) {
        pipeline.addElement(new PipelineSocketBroadcastAction(event, packet));
        return this;
    }

    public Pipeline build() {
        return pipeline;
    }
}
