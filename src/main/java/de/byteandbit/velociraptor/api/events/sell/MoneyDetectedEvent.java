package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Event wird aufgerufen, direkt nachdem der Bot eine Zahlung erkannt hat, egal ob der Spieler in der Verkaufszone steht oder nicht.
 */
public class MoneyDetectedEvent extends PlayerEvent {
    private boolean cancelled;
    private boolean payBack;
    private double payAmount;

    public MoneyDetectedEvent(String playerName, String playerUUID, double payAmount, boolean payBack) {
        super(playerName, playerUUID);
        this.payAmount = payAmount;
        this.payBack = payBack;
    }

    /**
     * Gibt den bezahlten Betrag an den Bot zurück.
     */
    public double getPayAmount() {
        return payAmount;
    }

    /**
     * Falls dies true zurückgibt, wird der Verkauf abgebrochen.
     */
    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Falls dies true zurückgibt, wird die Zahlung zurückgezahlt bei Abbruch.
     * Standardmäßig ist dies NICHT der Fall! (also Standardmäßig wird hier false zurückgegeben)
     */
    public boolean isPayBack() {
        return payBack;
    }

    public void setPayBack(boolean payBack) {
        this.payBack = payBack;
    }
}
