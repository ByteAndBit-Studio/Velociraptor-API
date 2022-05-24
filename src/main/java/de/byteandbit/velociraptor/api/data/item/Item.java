package de.byteandbit.velociraptor.api.data.item;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Datenstruktur für einen Item-Eintrag im Bot.
 */
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int internalId;
    private boolean active;

    private String material;
    private int materialSubId;

    private int stackSize;
    private int amount;
    private boolean hasDamage;

    private double price;
    private ItemType itemType;
    private ItemMetadata metadata;

    /**
     * Gibt die interne ID des Item Eintrags zurück.
     * Die interne ID ist eine eindeutige Kennung dieses eingetragenen Items.
     */
    public int getInternalId() {
        return internalId;
    }

    public void setInternalId(int id) {
        this.internalId = id;
    }

    /**
     * Gibt die Material SubId zurück.
     * Diese ist die Zahl hinter dem ":" bei ID's (z.b. 1:5 <- 5 ist die SubId)
     */
    public int getMaterialSubId() {
        return materialSubId;
    }

    public void setMaterialSubId(int materialSubId) {
        this.materialSubId = materialSubId;
    }

    /**
     * Gibt die maximale Stackanzahl des Items zurück.
     * Dies ist z.B. bei Erde 64, bei Knochen 16.
     */
    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    /**
     * Gibt den Materialnamen des Items zurück.
     */
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
     *
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

    /**
     * Gibt zurück, ob der Itemeintrag gerade aktiv ist.
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gibt zurück, ob dieses Item Schaden hat.
     */
    public boolean isHasDamage() {
        return hasDamage;
    }

    public void setHasDamage(boolean hasDamage) {
        this.hasDamage = hasDamage;
    }

    /**
     * Gibt den Eintragstyp dieses Items zurück. (Ankauf/Verkauf).
     */
    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    /**
     * Gibt die Item Metadaten zurück.
     */
    public ItemMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ItemMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return internalId == item.internalId && active == item.active && materialSubId == item.materialSubId && stackSize == item.stackSize && amount == item.amount && hasDamage == item.hasDamage && Double.compare(item.price, price) == 0 && Objects.equals(material, item.material) && itemType == item.itemType && Objects.equals(metadata, item.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalId, active, material, materialSubId, stackSize, amount, hasDamage, price, itemType, metadata);
    }
}
