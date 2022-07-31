package de.byteandbit.velociraptor.api.pipeline;

/**
 * Repräsentiert den aktuellen Status der Bot Pipeline
 */
public enum PipelineState {
    /**
     * Der Bot ist gerade inaktiv und wartet auf den nächsten Auftrag.
     */
    IDLE,

    /**
     * Der Bot arbeitet gerade einen Auftrag ab.
     */
    WORKING;
}
