package de.byteandbit.velociraptor.api.events.sell;

import de.byteandbit.velociraptor.api.events.player.PlayerEvent;

/**
 * Dieses Event wird aufgerufen, direkt nachdem der Bot eine Zahlung erkannt hat, egal ob der Spieler in der Verkaufszone steht oder nicht.
 */
public class MoneyDetectedEvent extends PlayerEvent {
    private boolean cancelled;
    private boolean outsideZone;
    private double payAmount;

    public MoneyDetectedEvent(String playerName, String playerUUID, boolean outsideZone, double payAmount) {
        super(playerName, playerUUID);
        this.outsideZone = outsideZone;
        this.payAmount = payAmount;
    }


    /**
     * Gibt den bezahlten Betrag an den Bot zurück.
     */
    public double getPayAmount() {
        return payAmount;
    }

    /**
     * Falls dies true zurückgibt, falls die Zahlung von außerhalb der Zone kam.
     */
    public boolean wasOutsideZone() {
        return outsideZone;
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
}
