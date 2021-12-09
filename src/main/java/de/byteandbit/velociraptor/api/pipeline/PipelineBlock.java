package de.byteandbit.velociraptor.api.pipeline;

public abstract class PipelineBlock extends PipelineElement {
    public volatile boolean pipelineBlock;
    protected PipelineExecutor executor;

    protected PipelineBlock(PipelineExecutor executor) {
        this.executor = executor;
    }

    public void setActive() {
        pipelineBlock = true;
    }

}
