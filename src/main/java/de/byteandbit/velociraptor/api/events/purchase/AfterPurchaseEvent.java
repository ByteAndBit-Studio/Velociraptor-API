package de.byteandbit.velociraptor.api.events.purchase;

import lombok.AllArgsConstructor;

/**
 * Dieses Verkaufevent wird nach jedem abgeschlossenen Verkauf aufgerufen.
 */
@AllArgsConstructor
public class AfterSellEvent extends PurchaseEvent {
    private boolean cancelled;

    /**
     * Gibt true zurück, falls der Verkauf abgebrochen wurde.
     */
    public boolean wasCancelled() {
        return cancelled;
    }
}
