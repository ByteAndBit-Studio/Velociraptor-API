package de.byteandbit.velociraptor.api.events.purchase;

import lombok.AllArgsConstructor;

/**
 * Dieses Ankaufsevent wird nach jedem abgeschlossenen Ankauf aufgerufen.
 */
@AllArgsConstructor
public class AfterPurchaseEvent extends PurchaseEvent {
    private boolean cancelled;

    /**
     * Gibt true zurück, falls der Ankauf abgebrochen wurde.
     */
    public boolean wasCancelled() {
        return cancelled;
    }
}
