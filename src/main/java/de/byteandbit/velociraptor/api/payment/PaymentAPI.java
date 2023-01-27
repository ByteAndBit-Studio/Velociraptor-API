package de.byteandbit.velociraptor.api.payment;

/**
 * Die PaymentAPI steuert die Zahlungsaktionen wie Verkauf und Ankauf.
 */
public interface PaymentAPI {

    /**
     * Löst einen Verkauf für den angegebenen Spieler und den angegebenen Betrag aus.
     */
    void triggerPayment(String playerName, double amount);

    /**
     * Löst einen Ankauf aus.
     */
    void triggerPurchase();
}
