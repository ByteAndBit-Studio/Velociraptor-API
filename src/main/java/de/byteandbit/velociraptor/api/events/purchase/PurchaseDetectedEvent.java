package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Ankaufevent wird kurz vorher aufgerufen, bevor der Bot die Ankaufsitems ins Lager legt.
 * Du kannst den Ankauf beenden, indem du die cancelled Variable auf true setzt.
 */
public class PurchaseDetectedEvent extends PurchaseEvent {
    private boolean cancelled;

    public PurchaseDetectedEvent(String playerName, String playerUUID, List<Item> items, List<Item> acceptedItems, double payAmount) {
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
