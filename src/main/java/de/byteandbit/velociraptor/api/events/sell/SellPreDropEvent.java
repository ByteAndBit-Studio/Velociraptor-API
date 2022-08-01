package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;

/**
 * Dieses Verkaufsevent wird kurz bevor der Bot die Items aus dem Lager holt.
 * Du kannst den Verkauf beenden bzw. abbrechen, indem du die cancelled Variable auf true setzt.
 */
public class SellPreDropEvent extends SellEvent {
    private boolean cancelled;

    public SellPreDropEvent(String playerName, String playerUUID, List<Item> items, double payAmount) {
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
