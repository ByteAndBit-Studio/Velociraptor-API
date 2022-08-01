package de.byteandbit.velociraptor.api.events.area;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Event wird aufgerufen sobald ein Spieler die Bot Zone wieder verlässt.
 */
public class BotAreaLeaveEvent extends PlayerEvent {

    public BotAreaLeaveEvent(String playerName, String playerUUID) {
        super(playerName, playerUUID);
    }
}
