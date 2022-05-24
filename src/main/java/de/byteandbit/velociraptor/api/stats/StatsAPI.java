package de.byteandbit.velociraptor.api.stats;

public interface StatsAPI {
    /**
     * Gibt die aktuellen Geldinformationen zu einem Spieler zurück.
     */
    MoneyInformation getCurrentMoneyInformation();

    /**
     * Gibt die aktuelle Server TPS zurück.
     */
    double getTPS();
}
