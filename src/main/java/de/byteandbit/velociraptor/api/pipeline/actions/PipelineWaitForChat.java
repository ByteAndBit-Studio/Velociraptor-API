package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.data.chat.ChatHook;
import de.byteandbit.velociraptor.data.chat.ChatMessage;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;

import java.util.function.Consumer;
import java.util.function.Function;

public class PipelineWaitForChat extends PipelineAction {

    private Thread timeoutThread;
    private Consumer<Boolean> callback;
    private int timeout;
    private Function<ChatMessage, Boolean> filterFunction;
    private boolean active = false;

    private ChatHook hook = new ChatHook() {
        @Override
        public void onChat(ChatMessage message) {
            if (!active) return;
            if (filterFunction.apply(message)) {

                if (timeoutThread != null) timeoutThread.interrupt();
                Velociraptor.getInstance().getChatHookManager().removeLock(hook);

                callback.accept(true);
            }
        }
    };

    public PipelineWaitForChat(Function<ChatMessage, Boolean> filter, int timeout, Consumer<Boolean> callback) {
        this.filterFunction = filter;
        this.callback = callback;
        this.timeout = timeout;

        Velociraptor.getInstance().getChatHookManager().addHook(hook);
    }

    @Override
    public void execute() {
        timeoutThread = new Thread(() -> {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                return;
            }

            active = false;
            Velociraptor.getInstance().getChatHookManager().removeLock(hook);

            callback.accept(false);
        });

        active = true;
        timeoutThread.start();
    }
}