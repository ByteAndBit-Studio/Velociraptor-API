package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.Map;
import java.util.Set;

/**
 * Dieses Ankaufsevent wird aufgerufen, wenn der Ankauf eines Spielers abgebrochen wurde.
 * Der Grund wird in der AbortReason angegeben.
 */
public class PurchaseAbortedEvent extends PurchaseEvent {
    private AbortReason reason;

    public PurchaseAbortedEvent(String playerName, String playerUUID, Set<Item> items, Map<Item, Integer> acceptedItems, double payAmount, AbortReason reason) {
        super(playerName, playerUUID, items, acceptedItems, payAmount);
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
        NO_VALID_ITEMS,
        NOT_ENOUGH_ITEMS,
        INVENTORY_ERROR,
        INTERNAL_ERROR,
        PLAYER_LEFT_ZONE;
    }
}
