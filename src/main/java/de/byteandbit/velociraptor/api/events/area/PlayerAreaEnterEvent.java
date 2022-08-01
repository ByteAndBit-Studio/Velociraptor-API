package de.byteandbit.velociraptor.api.events.area;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Event wird aufgerufen sobald ein Spieler die Verkaufszone betritt.
 */
public class PlayerAreaEnterEvent extends PlayerEvent {

    public PlayerAreaEnterEvent(String playerName, String playerUUID) {
        super(playerName, playerUUID);
    }
}
