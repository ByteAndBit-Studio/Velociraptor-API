package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Verkaufsevent wird aufgerufen, wenn der Verkauf eines Spielers abgebrochen wurde.
 * Der Grund wird in der AbortReason angegeben.
 */
public class SellAbortedEvent extends SellEvent {

    private AbortReason reason;

    public SellAbortedEvent(String playerName, String playerUUID, List<Item> items, double payAmount, AbortReason reason) {
        super(playerName, playerUUID, items, payAmount);
        this.reason = reason;
    }

    /**
     * Gibt den Grund zurück, wieso das Verkaufsevent abgebrochen wurde.
     */
    public AbortReason getReason() {
        return reason;
    }

    public enum AbortReason {
        NICKED,
        NOT_IN_ZONE,
        API_CANCEL,
        INVALID_PRICE,
        NOT_ENOUGH_ITEMS,
        INVENTORY_ERROR,
        INTERNAL_ERROR,
        PLAYER_LEFT_ZONE;
    }
}
