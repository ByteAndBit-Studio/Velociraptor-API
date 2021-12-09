package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;
import de.byteandbit.velociraptor.pipeline.PipelineExecutorImpl;

public class PipelineUnlockAction extends PipelineAction  {

    @Override
    public void execute() {
        Velociraptor.getLogger().debug("DEBUG: ACHTUNG: Pipeline Lock wurde wieder aufgehoben");
        PipelineExecutorImpl.unlockAllPipelines();
    }
}
