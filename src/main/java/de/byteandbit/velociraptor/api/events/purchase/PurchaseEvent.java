package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.Item;
import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

import java.util.List;

/**
 * Basis für die Verkaufsevents.
 * @see SellPreWarehouseEvent
 * @see SellPreDropEvent
 */
public abstract class SellEvent extends PlayerEvent {
    protected List<Item> items;
    protected int payAmount;

    /**
     * Gibt die verkauften Items zurück.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Gibt den bezahlten Betrag an den Bot zurück.
     */
    public int getPayAmount() {
        return payAmount;
    }
}
