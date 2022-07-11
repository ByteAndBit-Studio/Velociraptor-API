package de.byteandbit.velociraptor.api.pipeline;

/**
 *
 */
public interface PipelineAPI {

    PipelineState getPipelineState();

    void pause();
}
