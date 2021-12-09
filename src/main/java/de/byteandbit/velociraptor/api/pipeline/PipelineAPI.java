package de.byteandbit.velociraptor.api.pipeline;

import de.byteandbit.velociraptor.pipeline.command.CommandExecutor;

public interface PipelineAPI {
    PipelineExecutor newPipelineExecutor();
    void executePipeline(Pipeline pipeline);
    CommandExecutor getCommandExecutor();
}
