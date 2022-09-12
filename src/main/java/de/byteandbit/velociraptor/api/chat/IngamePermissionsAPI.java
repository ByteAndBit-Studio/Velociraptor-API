package de.byteandbit.velociraptor.api.chat;

import java.util.UUID;

/**
 * Die IngamePermissionsAPI ist zuständig für Prüfung, ob ein Spieler eine Ingame Berechtigung hat.
 */
public interface IngamePermissionsAPI {

    /**
     * Prüft, ob der angegebene Spieler die angegebene Permission hat.
     */
    boolean hasPermission(String name, String permission, PermissionType type);

    /**
     * Prüft, ob der angegebene Spieler die angegebene Permission hat.
     */
    boolean hasPermission(UUID uuid, String permission, PermissionType type);
}
