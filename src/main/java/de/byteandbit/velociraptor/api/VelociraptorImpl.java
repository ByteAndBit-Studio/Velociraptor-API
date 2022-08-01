package de.byteandbit.velociraptor.api;

import de.byteandbit.velociraptor.api.chat.ChatAPI;
import de.byteandbit.velociraptor.api.pipeline.PipelineAPI;
import de.byteandbit.velociraptor.api.stats.StatsAPI;
import org.slf4j.Logger;

/**
 * Nur für die interne Verwendung.
 */
public interface VelociraptorImpl {
    StatsAPI getStatsImpl();

    PipelineAPI getPipelineImpl();

    ChatAPI getChatImpl();

    Logger getLogger();
}
