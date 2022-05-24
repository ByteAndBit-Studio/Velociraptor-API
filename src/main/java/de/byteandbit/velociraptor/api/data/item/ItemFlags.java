package de.byteandbit.velociraptor.api.data.item;

/**
 * Items können sogenannte Flags haben.
 * Flags werden benutzt, um bestimmte Eigenschaften abzufragen und können entweder gesetzt oder nicht gesetzt sein.
 * Beispiel: ist die Flag DISPLAYNAME_EQUALS gesetzt, wird beim Verkauf/Ankauf geprüft, ob der Anzeigename gleich dem eingetragenen Anzeigenamen ist.
 */
public class ItemFlags {
    public static final int DISPLAYNAME_EQUALS = 1 << 0;
    public static final int DISPLAYNAME_CONTAINS = 1 << 1;
    public static final int NOT_USED = 1 << 2;
    public static final int NO_DAMAGE = 1 << 3;
    public static final int REPAIRCOST_EQUALS = 1 << 4;
    public static final int REPAIRCOST_LESS = 1 << 5;
    public static final int REPAIRCOST_LESSEQUALS = 1 << 6;
    public static final int SIGNUSER_CONTAINS = 1 << 7;
    public static final int SIGNUSER_EQUALS = 1 << 8;
    public static final int SIGNDATE_EQUALS = 1 << 9;
    public static final int ITEMLORE_EQUALS = 1 << 10;
    public static final int ENCHANTMENT_EQUALS = 1 << 11;
    public static final int NBT_ZERO = 1 << 12;
    public static final int NBT_ONE = 1 << 13;
    public static final int NBT_TWO = 1 << 14;
    public static final int NBT_THREE = 1 << 15;
    public static final int NBT_FOUR = 1 << 16;
    public static final int NBT_FIVE = 1 << 17;
    public static final int SUBTYPE_EQUALS = 1 << 18;

    /**
     * Hilfsfunktion zur Setzung einer Flag.
     *
     * @param input der aktuelle Flags Wert
     * @param flag  die Flag die gesetzt werden soll, bspw. ItemFlags.ITEMLORE_EQUALS
     * @return der neue Flags Wert
     */
    public static int setFlag(int input, int flag) {
        return input | flag;
    }

    /**
     * Hilfsfunktion zum Entfernen einer Flag-
     *
     * @param input der aktuelle Flags Wert
     * @param flag  die Flag die entfernt werden soll, bspw. ItemFlags.ITEMLORE_EQUALS
     * @return der neue Flags Wert
     */
    public static int unsetFlag(int input, int flag) {
        return input &= ~(flag);
    }

    /**
     * Prüft ob eine Flag gesetzt ist.
     *
     * @param input der aktuelle Flags Wert
     * @param flag  die Flag die geprüft werden soll, bspw. ItemFlags.ITEMLORE_EQUALS
     * @return true, falls die Flag gesetzt ist
     */
    public static boolean hasFlag(int input, int flag) {
        return (input & flag) == flag;
    }
}
