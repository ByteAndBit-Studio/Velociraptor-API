package de.byteandbit.velociraptor.api.events.area;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Event wird aufgerufen sobald ein Spieler die Bot Zone betritt.
 */
public class BotAreaEnterEvent extends PlayerEvent {
    public BotAreaEnterEvent(String playerName, String playerUUID) {
        super(playerName, playerUUID);
    }
}
