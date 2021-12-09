package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PipelineWaitAction extends PipelineAction {
    private int time;

    @Override
    public void execute() {
        try {
            Velociraptor.getLogger().debug("DEBUG: Die Pipeline wartet nun " + time + " ms");
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
}
