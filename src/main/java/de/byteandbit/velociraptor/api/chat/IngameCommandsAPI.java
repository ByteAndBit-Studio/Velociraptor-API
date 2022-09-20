package de.byteandbit.velociraptor.api.chat;

import java.util.UUID;

/**
 * Die IngamePermissionsAPI ist zuständig für die Registrierung und Verwaltung von /msg Commands.
 * Beispiel: /msg Botname kistenscan
 * Beispiel: /msg Botname sudo p kick AbgegrieftHD
 */
public interface IngameCommandsAPI {

    /**
     * Registriert einen neuen IngameCommand.
     *
     * @param command der Befehl
     */
    void register(IngameCommand command);

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
