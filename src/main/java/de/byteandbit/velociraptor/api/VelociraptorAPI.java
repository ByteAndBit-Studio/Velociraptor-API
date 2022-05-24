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
     * <p>w
     * \@EventHandler
     * public void onSellEvent(SellPreCheckEvent event) {}
     */
    public final EventBus EVENT_BUS;

    private Logger logger;
    private StatsAPI statsApi;
    private PipelineAPI pipelineApi;

    public VelociraptorAPI() {
        try {
            Class<VelociraptorImpl> implClass = (Class<VelociraptorImpl>) Class.forName("de.byteandbit.velociraptor.api.impl.APIImpl");
            VelociraptorImpl impl = implClass.newInstance();

            this.logger = impl.getLogger();
            this.statsApi = impl.getStatsImpl();
            this.pipelineApi = impl.getPipelineImpl();
            this.EVENT_BUS = new EventBus(logger);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Es ist ein Fehler beim Laden der Velociraptor API aufgetreten", e);
        }
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
     * Gibt den Logger für die velociraptor.log zurück.
     */
    public Logger getLogger() {
        return logger;
    }
}
