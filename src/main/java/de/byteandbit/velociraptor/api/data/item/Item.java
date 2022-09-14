package de.byteandbit.velociraptor.api.data.item;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Datenstruktur für einen Item-Eintrag im Bot.
 */
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String _id;
    private String nickname;
    private boolean active;

    private int warehouseCount;
    private ItemMaterial material;

    private int itemFlags;

    private ItemMetadata metadata;
    private ItemPrice[] prices;

    /**
     * Gibt die interne ID des Item Eintrags zurück.
     * Die interne ID ist eine eindeutige Kennung dieses eingetragenen Items.
     */
    public String getInternalId() {
        return _id;
    }

    public void setInternalId(String id) {
        this._id = id;
    }

    /**
     * Gibt den Nickname des Items zurück.
     * Der Nickname ist ein eindeutiger Name, der aber nur kosmetische Auswirkungen hat.
     */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * Gibt die Item Metadaten zurück.
     */
    public ItemMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ItemMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * Gibt den aktuellen Lagerstand zurück.
     */
    public int getWarehouseCount() {
        return warehouseCount;
    }

    public void setWarehouseCount(int warehouseCount) {
        this.warehouseCount = warehouseCount;
    }

    /**
     * Gibt das Item Material zurück.
     */
    public ItemMaterial getItemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(ItemMaterial itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    /**
     * Gibt die eingestellten ItemFlags zurück.
     *
     * @see ItemFlags
     */
    public int getItemFlags() {
        return itemFlags;
    }

    public void setItemFlags(int itemFlags) {
        this.itemFlags = itemFlags;
    }

    /**
     * Gibt die eingestellten Item Preise zurück.
     *
     * @see ItemPrice
     */
    public ItemPrice[] getPrices() {
        return prices;
    }

    public void setPrices(ItemPrice[] prices) {
        this.prices = prices;
    }
}
