package de.byteandbit.velociraptor.api.pipeline;

/**
 * Diese API ist für die Synchronisierung der Bot Funktionen zuständig, die nicht parallel laufen können.
 * Das ist zum Beispiel das Öffnen von Kisten.
 */
public interface PipelineAPI {

    /**
     * Gibt den aktuellen Zustand der Pipeline zurück.
     */
    PipelineState getPipelineState();

    /**
     * Diese Methode wird solange blockiert, bis alle vorherigen Aktionen abgearbeitet wurden und
     * die nächste Aktion starten kann.
     * Nach Beenden der Aktion, die synchronisiert, also nicht parallel, laufen muss, muss unbedingt releaseLock() aufgerufen werden!
     */
    void aquireLock();

    /**
     * Beendet eine Aktion.
     */
    void releaseLock();
}
