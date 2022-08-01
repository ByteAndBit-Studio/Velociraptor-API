package de.byteandbit.velociraptor.api.events.area;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Event wird aufgerufen sobald ein Spieler die Verkaufszone wieder verlässt.
 */
public class PlayerAreaLeaveEvent extends PlayerEvent {

    public PlayerAreaLeaveEvent(String playerName, String playerUUID) {
        super(playerName, playerUUID);
    }
}
