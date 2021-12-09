package de.byteandbit.velociraptor.api.events.sell;

/**
 * Dieses Verkaufsevent wird kurz bevor der Bot die Items aus dem Lager holt.
 * Du kannst den Verkauf beenden bzw. abbrechen, indem du die cancelled Variable auf true setzt.
 */
public class SellPreDropEvent extends SellEvent {
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
