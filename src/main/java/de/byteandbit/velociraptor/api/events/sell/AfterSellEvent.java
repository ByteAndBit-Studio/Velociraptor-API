package de.byteandbit.velociraptor.api.events.sell;

import lombok.AllArgsConstructor;

/**
 * Dieses Verkaufevent wird nach jedem abgeschlossenen Verkauf aufgerufen.
 */
@AllArgsConstructor
public class AfterSellEvent extends SellEvent {
    private boolean cancelled;

    /**
     * Gibt true zurück, falls der Verkauf abgebrochen wurde.
     */
    public boolean wasCancelled() {
        return cancelled;
    }
}
