package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;
import java.util.Map;

/**
 * Dieses Verkaufevent wird nach jedem abgeschlossenen Verkauf aufgerufen.
 */
public class AfterSellEvent extends SellEvent {
    public AfterSellEvent(String playerName, String playerUUID, Map<Item, Integer> items, double payAmount) {
        super(playerName, playerUUID, items, payAmount);
    }
}
