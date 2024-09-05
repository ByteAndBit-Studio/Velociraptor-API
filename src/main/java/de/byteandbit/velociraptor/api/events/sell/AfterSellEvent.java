package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.data.item.Item;

import java.util.List;
import java.util.Map;

/**
 * Dieses Verkaufevent wird nach jedem abgeschlossenen Verkauf aufgerufen.
 */
public class AfterSellEvent extends SellEvent {
     /**
     * Gibt an, ob die Statistiken für diesen Verkauf ignoriert werden sollen.
     */
    private boolean ignoreStats;

    public AfterSellEvent(String playerName, String playerUUID, Map<Item, Integer> items, double payAmount) {
        super(playerName, playerUUID, items, payAmount);
    }

    public boolean isIgnoreStats() {
        return ignoreStats;
    }

    public void setIgnoreStats(boolean ignoreStats) {
        this.ignoreStats = ignoreStats;
    }
}
