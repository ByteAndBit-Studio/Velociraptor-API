package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Ankaufevent wird aufgerufen, nachdem ein Ankaufbefehl über API/via private Nachricht erkannt wurde.
 */
public class PurchaseDetectedEvent extends PlayerEvent {
    private boolean cancelled;

    public PurchaseDetectedEvent(String playerName, String playerUUID) {
        super(playerName, playerUUID);
    }

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
