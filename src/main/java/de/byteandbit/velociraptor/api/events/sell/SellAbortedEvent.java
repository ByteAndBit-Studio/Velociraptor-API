package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Verkaufsevent wird aufgerufen, wenn der Spieler während des Verkaufs die Zone verlassen hat.
 */
public class SellAbortedEvent extends SellEvent {

    public SellAbortedEvent(String playerName, String playerUUID, List<Item> items, double payAmount) {
        super(playerName, playerUUID, items, payAmount);
    }
}
