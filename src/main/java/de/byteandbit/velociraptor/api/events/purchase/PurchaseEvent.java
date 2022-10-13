package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;
import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

import java.util.Map;
import java.util.Set;

/**
 * Basis für die Ankaufsevents
 *
 * @see PurchasePrePayEvent
 * @see PurchaseDetectedEvent
 * @see PurchaseAbortedEvent
 * @see AfterPurchaseEvent
 */
public abstract class PurchaseEvent extends PlayerEvent {
    protected Set<Item> items;
    protected Map<Item, Integer> acceptedItems;
    protected double payAmount;

    public PurchaseEvent(String playerName, String playerUUID, Set<Item> items, Map<Item, Integer> acceptedItems, double payAmount) {
        super(playerName, playerUUID);
        this.items = items;
        this.acceptedItems = acceptedItems;
        this.payAmount = payAmount;
    }

    /**
     * Gibt die Items zurück, die der Spieler eingelegt hat.
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * Gibt die akzeptierten Items zurück.
     */
    public Set<Item> getAcceptedItems() {
        return acceptedItems.keySet();
    }

    public int getAmountOf(Item item) {
        if (acceptedItems != null && acceptedItems.containsKey(item)) {
            return acceptedItems.get(item);
        }

        if (items != null && items.contains(item)) {
            return item.getWarehouseCount();
        }

        return 0;
    }

    /**
     * Gibt den ausgezahlten Betrag an den Spieler zurück.
     */
    public double getPayOutAmount() {
        return payAmount;
    }
}
