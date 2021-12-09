package de.byteandbit.velociraptor.api.events.sell;

/**
 * Dieses Verkaufsevent wird vor nach unseren Checks aufgerufen, kurz bevor der Bot die Items aus dem Lager holt.
 * Du kannst den Verkauf beenden bzw. abbrechen, indem du die cancelled Variable auf true setzt.
 */
public class SellPostChecksEvent extends SellEvent {
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
