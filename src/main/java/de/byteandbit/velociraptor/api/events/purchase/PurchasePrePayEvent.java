package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.Map;
import java.util.Set;

/**
 * Dieses Ankaufevent wird aufgerufen, nachdem Bot die Ankaufsitems ins Lager gelegt und die falschen Items droppt/zurücklegt hat.
 * Du kannst den Ankauf beenden, indem du die cancelled Variable auf true setzt.
 */
public class PurchasePrePayEvent extends PurchaseEvent {
    private boolean cancelled;
    private String cancelReason;

    private float yaw = Float.MIN_VALUE;
    private float pitch = Float.MIN_VALUE;

    public PurchasePrePayEvent(String playerName, String playerUUID, Set<Item> items, Map<Item, Integer> acceptedItems, double payAmount) {
        super(playerName, playerUUID, items, acceptedItems, payAmount);
    }

    public void setYawPitchForDrop(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
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
