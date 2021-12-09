package de.byteandbit.velociraptor.api.pipeline.block;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineBlock;
import de.byteandbit.velociraptor.api.pipeline.PipelineExecutor;
import de.byteandbit.velociraptor.data.chat.ChatMessage;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.function.Consumer;
import java.util.function.Function;

public class PipelineWaitForChatBlock extends PipelineBlock implements MessageReceiveEvent {

    private Thread timeoutThread;
    private Consumer<Boolean> callback;
    private Function<ChatMessage, Boolean> filterFunction;

    public PipelineWaitForChatBlock(PipelineExecutor executor, Function<ChatMessage, Boolean> filter, int timeout, Consumer<Boolean> callback) {
        super(executor);
        this.filterFunction = filter;
        this.callback = callback;

        MinecraftForge.EVENT_BUS.register(this);

        timeoutThread = new Thread(() -> {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                return;
            }

            callback.accept(false);
        });

        timeoutThread.start();
    }

    @Override
    public void setActive() {
        super.setActive();
        Velociraptor.getLogger().debug("DEBUG: Der Pipeline Chat-Block wurde aktiviert");
    }

    @Override
    public boolean onReceive(String unformatted, String formatted) {
        if(!pipelineBlock) {
            return false;
        }

        if(filterFunction.apply(new ChatMessage(unformatted, formatted))) {
            if(timeoutThread != null) timeoutThread.interrupt();

            MinecraftForge.EVENT_BUS.unregister(this);

            callback.accept(true);
            pipelineBlock = false;
        }

        return false;
    }
}
