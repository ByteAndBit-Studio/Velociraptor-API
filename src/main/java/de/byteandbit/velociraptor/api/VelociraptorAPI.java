package de.byteandbit.velociraptor.api;

import de.byteandbit.velociraptor.api.events.EventBus;
import de.byteandbit.velociraptor.api.pipeline.PipelineAPI;
import de.byteandbit.velociraptor.api.stats.StatsAPI;
import org.slf4j.Logger;


/**
 * Dies ist die Hauptklasse der Velociraptor API.
 * Von hier aus kannst du Events registrieren oder Aktionen triggern.
 * Detailliertere Beschreibungen findest du in den einzelnen Subklassen.
 */
public class VelociraptorAPI {
    /**
     * Der EventBus ist eines der wichtigsten Features der API.
     * Hier kannst du die ganzen Events abfangen, die durch Velociraptor geworfen werden.
     * Hier nachfolgend ein Beispiel für die Benutzung des EventBus:
     * <p>
     * public MeinEventListener() {
     * VelociraptorAPI.EVENT_BUS.register(this);
     * }
     * <p>
     * \@EventHandler
     * public void onSellEvent(SellPreCheckEvent event) {}
     */
    public static EventBus EVENT_BUS = new EventBus();

    private static VelociraptorAPI instance;

    private static Logger logger;
    private StatsAPI statsApi;
    private PipelineAPI pipelineApi;

    public VelociraptorAPI(Logger logger, StatsAPI statsApi, PipelineAPI pipelineApi) {
        instance = this;
        this.logger = logger;
        this.statsApi = statsApi;
        this.pipelineApi = pipelineApi;
    }

    /**
     * Gibt den Logger für die velociraptor.log zurück.
     */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * Gibt die Statistik API zurück.
     */
    public StatsAPI getStatsAPI() {
        return this.statsApi;
    }

    /**
     * Gibt die Pipeline API zurück.
     */
    public PipelineAPI getPipelineAPI() {
        return this.pipelineApi;
    }

    /**
     * Gibt die aktuelle VelociraptorAPI Instanz zurück.
     */
    public static VelociraptorAPI getInstance() {
        return instance;
    }
}
