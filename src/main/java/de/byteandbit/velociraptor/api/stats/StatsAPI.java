package de.byteandbit.velociraptor.api.stats;

import de.byteandbit.velociraptor.api.data.item.Item;

public interface StatsAPI {
    /**
     * Gibt die aktuellen Geldinformationen zu einem Spieler zurück.
     */
    MoneyInformation getCurrentMoneyInformation();

    /**
     * Gibt die aktuelle Server TPS zurück.
     */
    double getTPS();

    /**
     * Fügt eine Itemstatistik hinzu.
     */
    void addItemStat(StatType type, double money, Item item);

    /**
     * Fügt eine Spielerstatistik hinzu.
     */
    void addPlayerStat(StatType type, double money, String name, String uuid);
}
