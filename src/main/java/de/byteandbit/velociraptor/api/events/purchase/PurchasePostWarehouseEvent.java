package de.byteandbit.velociraptor.api.events.purchase;

import lombok.AllArgsConstructor;

/**
 * Dieses Verkaufsevent wird aufgerufen, bevor der Bot die Items aus dem Lager holt.
 * Du kannst den Verkauf beenden, indem du die cancelled Variable auf true setzt.
 */
@AllArgsConstructor
public class SellPreWarehouseEvent extends PurchaseEvent {
    private boolean cancelled;

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
