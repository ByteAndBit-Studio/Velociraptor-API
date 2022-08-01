package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.Item;
import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

import java.util.List;

/**
 * Basis für die Ankaufsevents
 *
 * @see PurchasePostWarehouseEvent
 * @see PurchasePreWarehouseEvent
 */
public abstract class PurchaseEvent extends PlayerEvent {
    protected List<Item> items;
    protected List<Item> acceptedItems;
    protected double payAmount;

    public PurchaseEvent(String playerName, String playerUUID, List<Item> items, List<Item> acceptedItems, double payAmount) {
        super(playerName, playerUUID);
        this.items = items;
        this.acceptedItems = acceptedItems;
        this.payAmount = payAmount;
    }

    /**
     * Gibt die Items zurück, die der Spieler eingelegt hat.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Gibt die akzeptierten Items zurück.
     */
    public List<Item> getAcceptedItems() {
        return acceptedItems;
    }

    /**
     * Gibt den ausgezahlten Betrag an den Spieler zurück.
     */
    public double getPayOutAmount() {
        return payAmount;
    }
}
