package de.byteandbit.velociraptor.api.pipeline;

/**
 * Ausführende Klasse von Pipelines.
 */
public abstract class PipelineExecutor {
    /**
     * Führt eine Pipeline aus.
     * Sollte nicht direkt aufgerufen werden, sondern über @see PipelineAPI#executePipeline.
     *
     * @param pipeline die auszuführende Pipeline
     */
    public abstract void executePipeline(Pipeline pipeline);
}
