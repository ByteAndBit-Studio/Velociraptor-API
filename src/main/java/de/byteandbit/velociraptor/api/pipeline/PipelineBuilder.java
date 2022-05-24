package de.byteandbit.velociraptor.api.pipeline;


public class PipelineBuilder {

    private Pipeline pipeline;

    public PipelineBuilder() {
        pipeline = new Pipeline();
    }

    public Pipeline build() {
        return pipeline;
    }
}
