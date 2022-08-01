package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Verkaufsevent wird aufgerufen, bevor der Bot die Items aus dem Lager holt.
 * Du kannst den Verkauf beenden, indem du die cancelled Variable auf true setzt.
 */
public class SellPreWarehouseEvent extends SellEvent {
    private boolean cancelled;

    public SellPreWarehouseEvent(String playerName, String playerUUID, List<Item> items, double payAmount) {
        super(playerName, playerUUID, items, payAmount);
    }

    /**
     * Falls dies true zurückgibt, wird der Verkauf abgebrochen.
     */
    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
