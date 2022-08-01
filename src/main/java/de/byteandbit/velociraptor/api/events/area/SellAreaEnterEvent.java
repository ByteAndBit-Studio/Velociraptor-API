package de.byteandbit.velociraptor.api.events.area;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Event wird aufgerufen sobald ein Spieler die Verkaufszone betritt.
 */
public class SellAreaEnterEvent extends PlayerEvent {

    public SellAreaEnterEvent(String playerName, String playerUUID) {
        super(playerName, playerUUID);
    }
}
