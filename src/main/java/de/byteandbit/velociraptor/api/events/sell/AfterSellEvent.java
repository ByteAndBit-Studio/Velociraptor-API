package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Verkaufevent wird nach jedem abgeschlossenen Verkauf aufgerufen.
 */
public class AfterSellEvent extends SellEvent {
    private boolean cancelled;

    public AfterSellEvent(String playerName, String playerUUID, List<Item> items, double payAmount) {
        super(playerName, playerUUID, items, payAmount);
        this.cancelled = false;
    }

    /**
     * Gibt true zurück, falls der Verkauf abgebrochen wurde.
     */
    public boolean wasCancelled() {
        return cancelled;
    }
}
