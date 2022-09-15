package de.byteandbit.velociraptor.api.data.item;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Datenstruktur für das Item Material im Bot
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemMaterial {
    private String name;
    private int subId;
    private int stackSize;

    /**
     * Gibt den Namen des Materials zurück, zum Beispiel minecraft:stone.
     */
    public String getName() {
        return name != null ? name : "";
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Sub-ID des Materials zurück, zum Beispiel "2".
     */
    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    /**
     * Gibt die Stack-Size des Materials zurück, bei Knochen z.B. 16, normalerweise 64.
     */
    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemMaterial)) return false;
        ItemMaterial that = (ItemMaterial) o;
        return getSubId() == that.getSubId() && getStackSize() == that.getStackSize() && Objects.equal(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getSubId(), getStackSize());
    }
}
