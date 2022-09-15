package de.byteandbit.velociraptor.api.data.item;

import com.google.common.base.Objects;
import lombok.ToString;

/**
 * Datenstruktur für einen Itempreis
 */
@ToString
public class ItemPrice {
    private double price;
    private int amount;
    private ItemType type;

    /**
     * Gibt den Typ des Eintrags zurück, Verkauf oder Ankauf.
     */
    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * Gibt den Item Preis zurück.
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gibt die Anzahl des Items zurück.
     * Bei Verkauf: Wie oft es gedroppt werden soll.
     * Bei Ankauf: In welchen Stückzahlen angekauft werden soll
     * <p>
     * Beispiel für Ankauf: amount=16, price=10
     * Dann wird angekauft: 16 für 10$, 32 für 20$, 48 für 30$, etc.
     * Packt der Kunde nun 20 Items in die Kiste werden 4 wieder zurückgedroppt und 16 für 10$ angekauft.
     */
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPrice)) return false;
        ItemPrice itemPrice = (ItemPrice) o;
        return Double.compare(itemPrice.getPrice(), getPrice()) == 0 && getAmount() == itemPrice.getAmount() && getType() == itemPrice.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPrice(), getAmount(), getType());
    }
}
