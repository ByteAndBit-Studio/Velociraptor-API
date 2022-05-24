package de.byteandbit.velociraptor.api.pipeline;

/**
 *
 */
public interface PipelineAPI {
    /**
     * Gibt einen neuen PipelineExecutor zurück.
     * @see PipelineExecutor
     */
    PipelineExecutor newPipelineExecutor();

    /**
     * Führt eine Pipeline aus.
     * @param pipeline die Pipeline, die ausgeführt werden soll
     * @see
     */
    void executePipeline(Pipeline pipeline);

    /**
     * Nur für die interne Verwendung gedacht.
     */
    CommandExecutorAPI getInternalCommandExecutor();
}
