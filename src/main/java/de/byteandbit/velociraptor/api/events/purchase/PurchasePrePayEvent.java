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

    public PurchasePrePayEvent(String playerName, String playerUUID, Set<Item> items, Map<Item, Integer> acceptedItems, double payAmount) {
        super(playerName, playerUUID, items, acceptedItems, payAmount);
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
}
