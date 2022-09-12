package de.byteandbit.velociraptor.api.chat;

/**
 * Repräsentiert einen Permission Typ.
 */
public enum PermissionType {
    /**
     * Für interne Velociraptor Befehle.
     */
    INTERNAL,

    /**
     * Für Sudo Befehle.
     */
    SUDO,

    /**
     * Für externe Plugins / die API.
     */
    EXTERNAL;
}
