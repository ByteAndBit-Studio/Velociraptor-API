package de.byteandbit.velociraptor.api.pipeline;

/**
 *
 */
public interface CommandExecutorAPI {
    void addToPipeline(String command);

    void addPriorizedToPipeline(String command);
}
