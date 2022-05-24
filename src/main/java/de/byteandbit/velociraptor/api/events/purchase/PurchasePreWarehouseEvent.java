package de.byteandbit.velociraptor.api.events.purchase;

import lombok.AllArgsConstructor;

/**
 * Dieses Ankaufevent wird kurz vorher aufgerufen, bevor der Bot die Ankaufsitems ins Lager legt.
 * Du kannst den Ankauf beenden, indem du die cancelled Variable auf true setzt.
 */
@AllArgsConstructor
public class PurchasePreWarehouseEvent extends PurchaseEvent {
    private boolean cancelled;

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
