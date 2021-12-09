package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;
import lombok.AllArgsConstructor;
import net.minecraft.client.Minecraft;

@AllArgsConstructor
public class PipelineSendChatAction extends PipelineAction {

    private String message;

    @Override
    public void execute() {
        Velociraptor.getLogger().debug("DEBUG: Die Pipeline sendet nun in den Chat: " + message);
        Minecraft.getMinecraft().player.sendChatMessage(message);
    }
}
