package de.byteandbit.velociraptor.api.data.item;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemLimits {

    private int buyLimit;
    private int currentBuy;

    /**
     * Gibt das aktuelle Ankaufslimit zurück.
     */
    public int getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(int buyLimit) {
        this.buyLimit = buyLimit;
    }

    /**
     * Gibt den aktuellen Ankaufsstand zurück
     */
    public int getCurrentBuy() {
        return currentBuy;
    }

    public void setCurrentBuy(int currentBuy) {
        this.currentBuy = currentBuy;
    }
}

