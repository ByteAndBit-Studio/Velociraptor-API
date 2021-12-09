package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.api.pipeline.PipelineAction;
import de.byteandbit.velociraptor.api.pipeline.PipelineExecutor;
import de.byteandbit.velociraptor.pipeline.PipelineExecutorImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PipelineSendCommandAction extends PipelineAction {

    private String cmd;
    private boolean delayed;
    private boolean priorized;

    @Override
    public void execute() {
        if(delayed) {
            new Thread(() -> {
                try {
                    Thread.sleep(150L);
                } catch (InterruptedException e) { }
                if(!priorized) PipelineExecutorImpl.getCommandPipeline().addToPipeline(cmd);
                else PipelineExecutorImpl.getCommandPipeline().addPriorizedToPipeline(cmd);
            }).start();
            return;
        }
        if(!priorized) PipelineExecutorImpl.getCommandPipeline().addToPipeline(cmd);
        else PipelineExecutorImpl.getCommandPipeline().addPriorizedToPipeline(cmd);
    }
}
