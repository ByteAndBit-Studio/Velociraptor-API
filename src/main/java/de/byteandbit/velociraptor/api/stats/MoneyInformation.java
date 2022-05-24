package de.byteandbit.velociraptor.api.stats;

import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * Repräsentiert die aktuellen Geldinformationen des Bots.
 */
@AllArgsConstructor
public class MoneyInformation {
    private double balance;
    private double bankBalance;
    private Date lastUpdated;

    /**
     * Gibt das aktuelle Guthaben zurück.
     * Hinweis: Wird nur periodisch eingelesen und ist nicht Echtzeit.
     *
     * @see MoneyInformation#getLastUpdated
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gibt das aktuelle Bankguthaben zurück.
     * Hinweis: Wird nur periodisch eingelesen und ist nicht Echtzeit.
     *
     * @see MoneyInformation#getLastUpdated
     */
    public double getBankBalance() {
        return bankBalance;
    }

    /**
     * Gibt zurück, wann die Guthaben Werte das letzte mal von uns aktualisiert/eingelesen wurden.
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }
}
