package de.byteandbit.velociraptor.api.chat;

import java.util.UUID;

/**
 * Die IngamePermissionsAPI ist zuständig für Prüfung, ob ein Spieler eine Ingame Berechtigung hat.
 */
public interface IngamePermissionsAPI {

    /**
     * Prüft, ob der angegebene Spieler die angegebene Permission hat.
     * Externe Plugins sollten als PermissionType den PermissionType.EXTERNAL nutzen!
     */
    boolean hasPermission(String name, String permission, PermissionType type);

    /**
     * Prüft, ob der angegebene Spieler die angegebene Permission hat.
     * Externe Plugins sollten als PermissionType den PermissionType.EXTERNAL nutzen!
     */
    boolean hasPermission(UUID uuid, String permission, PermissionType type);
}
