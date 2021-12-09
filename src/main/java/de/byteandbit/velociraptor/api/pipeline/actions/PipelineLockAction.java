package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;
import de.byteandbit.velociraptor.pipeline.PipelineExecutorImpl;

public class PipelineLockAction extends PipelineAction  {

    @Override
    public void execute() {
        Velociraptor.getLogger().debug("DEBUG: ACHTUNG: Alle (nicht-priorisierten) Pipelines werden angehalten für priorisierte Ausführung");
        PipelineExecutorImpl.lockAllPipelines();
    }
}
