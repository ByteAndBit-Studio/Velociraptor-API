package de.byteandbit.velociraptor.api.events.sell;

/**
 * Dieses Verkaufsevent wird vor unseren Checks (ist der Spieler überhaupt in der Verkaufszone, etc) aufgerufen.
 * Du kannst den Verkauf beenden, indem du die cancelled Variable auf true setzt.
 */
public class SellPreCheckEvent extends SellEvent {
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
