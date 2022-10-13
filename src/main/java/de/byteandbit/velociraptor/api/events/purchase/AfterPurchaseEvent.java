package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.Map;
import java.util.Set;

/**
 * Dieses Ankaufsevent wird nach jedem abgeschlossenen Ankauf aufgerufen.
 */
public class AfterPurchaseEvent extends PurchaseEvent {
    public AfterPurchaseEvent(String playerName, String playerUUID, Set<Item> items, Map<Item, Integer> acceptedItems, double payAmount) {
        super(playerName, playerUUID, items, acceptedItems, payAmount);
    }
}
