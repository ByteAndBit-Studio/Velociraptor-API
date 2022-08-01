package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Ankaufsevent wird nach jedem abgeschlossenen Ankauf aufgerufen.
 */
public class AfterPurchaseEvent extends PurchaseEvent {
    private boolean cancelled;

    public AfterPurchaseEvent(String playerName, String playerUUID, List<Item> items, List<Item> acceptedItems, double payAmount) {
        super(playerName, playerUUID, items, acceptedItems, payAmount);
    }
}
