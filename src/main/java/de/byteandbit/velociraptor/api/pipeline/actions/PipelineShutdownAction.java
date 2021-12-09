package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;
import net.minecraft.client.Minecraft;

public class PipelineShutdownAction extends PipelineAction {
    @Override
    public void execute() {
        Velociraptor.getLogger().info("Shutting down...");
        Minecraft.getMinecraft().shutdown();
    }
}
