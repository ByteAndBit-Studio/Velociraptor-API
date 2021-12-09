package de.byteandbit.velociraptor.api.pipeline;

import de.byteandbit.velociraptor.api.VelociraptorAPI;
import de.byteandbit.velociraptor.pipeline.command.CommandExecutor;

public abstract class PipelineExecutor {
    public abstract void executePipeline(Pipeline pipeline);
    public static CommandExecutor getCommandPipeline() {
        return VelociraptorAPI.getInstance().getPipelineApi().getCommandExecutor();
    }
}
