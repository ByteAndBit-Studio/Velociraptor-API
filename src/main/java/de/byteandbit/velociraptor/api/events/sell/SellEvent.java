package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;
import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

import java.util.Map;
import java.util.Set;

/**
 * Basis für die Verkaufsevents.
 *
 * @see SellDetectedEvent
 * @see SellPreDropEvent
 * @see SellAbortedEvent
 */
public abstract class SellEvent extends PlayerEvent {
    protected Map<Item, Integer> items;
    protected double payAmount;

    public SellEvent(String playerName, String playerUUID, Map<Item, Integer> items, double payAmount) {
        super(playerName, playerUUID);
        this.items = items;
        this.payAmount = payAmount;
    }

    /**
     * Gibt die verkauften Items zurück, falls diese bereits erkannt wurden.
     */
    public Set<Item> getItems() {
        return items.keySet();
    }

    /**
     * Gibt die Anzahl zurück, wie oft ein Item gedroppt / verkauft wurde.
     */
    public int getAmountOf(Item item) {
        return items.getOrDefault(item, 0);
    }

    /**
     * Gibt den bezahlten Betrag an den Bot zurück.
     */
    public double getPayAmount() {
        return payAmount;
    }
}
