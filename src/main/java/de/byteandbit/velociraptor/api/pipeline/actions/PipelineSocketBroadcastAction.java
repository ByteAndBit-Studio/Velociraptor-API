package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;

public class PipelineSocketBroadcastAction extends PipelineAction {

    private String event;
    private Object packet;

    public PipelineSocketBroadcastAction(String event, Object packet) {
        this.event = event;
        this.packet = packet;
    }

    @Override
    public void execute() {
        Velociraptor.getLogger().debug(String.format("DEBUG: PipelineBroadcastAction#execute(event=%s,packet=%s)", event, packet.toString()));
        Velociraptor.getInstance().getWebEnvironment().getSocketServer().broadcast(event, packet);
    }
}
