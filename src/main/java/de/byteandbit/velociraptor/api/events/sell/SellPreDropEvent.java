package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.Map;

/**
 * Dieses Verkaufsevent wird kurz bevor der Bot die Items aus dem Lager holt.
 * Du kannst den Verkauf beenden bzw. abbrechen, indem du die cancelled Variable auf true setzt.
 */
public class SellPreDropEvent extends SellEvent {
    private boolean cancelled;
    private String cancelReason;

    private float yaw = Float.MIN_VALUE;
    private float pitch = Float.MIN_VALUE;
    
    public SellPreDropEvent(String playerName, String playerUUID, Map<Item, Integer> items, double payAmount) {
        super(playerName, playerUUID, items, payAmount);
    }

    public void setYawPitchForDrop(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
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

    /**
     * Gibt die Nachricht zurück, die an den Spieler geschickt wird, wenn das Event gecancelled wird.
     * Falls dies leer ist, wird die Standardnachricht an den Spieler geschickt.
     */
    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }
}
