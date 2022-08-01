package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;
import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

import java.util.List;

/**
 * Basis für die Verkaufsevents.
 *
 * @see SellPreWarehouseEvent
 * @see SellPreDropEvent
 * @see SellAbortedEvent
 */
public abstract class SellEvent extends PlayerEvent {
    protected List<Item> items;
    protected double payAmount;

    public SellEvent(String playerName, String playerUUID, List<Item> items, double payAmount) {
        super(playerName, playerUUID);
        this.items = items;
        this.payAmount = payAmount;
    }

    /**
     * Gibt die verkauften Items zurück, falls
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Gibt den bezahlten Betrag an den Bot zurück.
     */
    public double getPayAmount() {
        return payAmount;
    }
}
