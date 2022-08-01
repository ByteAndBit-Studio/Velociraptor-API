package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Ankaufevent wird aufgerufen, nachdem Bot die Ankaufsitems ins Lager gelegt und die falschen Items droppt/zurücklegt hat.
 * Du kannst den Ankauf beenden, indem du die cancelled Variable auf true setzt.
 */
public class PurchasePostWarehouseEvent extends PurchaseEvent {
    private boolean cancelled;

    public PurchasePostWarehouseEvent(String playerName, String playerUUID, List<Item> items, List<Item> acceptedItems, double payAmount) {
        super(playerName, playerUUID, items, acceptedItems, payAmount);
    }

    /**
     * Falls dies true zurückgibt, wird der Ankauf abgebrochen.
     */
    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
