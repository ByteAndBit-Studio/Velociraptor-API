package de.byteandbit.velociraptor.api.data.item;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemMetadata {
    private String displayName;
    private int repairCost;
    private String signUser;
    private String signDate;
    private ItemLore[] itemLore;
    private ItemEnchantments[] itemEnchantments;

    /**
     * Gibt den gesetzten Anzeigenamen des Item Eintrags zurück.
     */
    public String getDisplayName() {
        return displayName != null ? displayName : "";
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gibt die Reparaturkosten zurück.
     */
    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    /**
     * Gibt den Nutzer, der das Item signiert hat zurück, falls gesetzt.
     */
    public String getSignUser() {
        return signUser != null ? signUser : "";
    }

    public void setSignUser(String signUser) {
        this.signUser = signUser;
    }

    /**
     * Gibt das Datum, an dem das Item signiert wurde zurück, falls gesetzt.
     */
    public String getSignDate() {
        return signDate != null ? signDate : "";
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    /**
     * Gibt, falls gesetzt, die ItemLore in einem Array zurück (Zeile für Zeile).
     */
    public ItemLore[] getItemLore() {
        return itemLore != null ? itemLore : new ItemLore[0];
    }

    public void setItemLore(ItemLore[] itemLore) {
        this.itemLore = itemLore;
    }

    /**
     * Gibt, falls gesetzt, die Item Verzauberungen zurück.
     */
    public ItemEnchantments[] getEnchantments() {
        return this.itemEnchantments != null ? this.itemEnchantments : new ItemEnchantments[0];
    }

    public void setEnchantments(ItemEnchantments[] enchantments) {
        this.itemEnchantments = enchantments;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class ItemLore {
        private int lineNumber;
        private String lineContent;

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        public String getLine() {
            return lineContent != null ? lineContent : "";
        }

        public void setLine(String line) {
            this.lineContent = line;
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class ItemEnchantments {
        private int id;
        private int level;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

}

