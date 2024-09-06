package de.byteandbit.velociraptor.api.player;


import java.util.UUID;

/**
 * Diese API ist für die Verwaltung von Spielern zuständig.
 */
public interface PlayerAPI {
    /**
     * Gibt den Spielernamen zu einer UUID zurück.
     *
     * @return Der Spielernamen oder null, wenn die UUID nicht existiert.
     */
    String getPlayerNameByUUID(String uuid);

    /**
     * Gibt den Spielernamen zu einer UUID zurück.
     *
     * @return Der Spielernamen oder null, wenn die UUID nicht existiert.
     */
    String getPlayerNameByUUID(UUID uuid);

    /**
     * Gibt die UUID zu einem Spielernamen zurück.
     *
     * @return Die UUID oder null, wenn der Spielername nicht existiert.
     */
    UUID getUUIDByPlayerName(String playerName);
}
