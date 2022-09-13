package de.byteandbit.velociraptor.api.chat;

import lombok.Getter;

/**
 * Repräsentiert einen IngameCommand.
 * Beispiel: /msg Botname kistenscan <- kistenscan
 */
public abstract class IngameCommand {

    private IngameCommand() {
    }

    /**
     * Initialisiert einen Command mit dem angegebenen Name
     *
     * @param name der eindeutige Name des Befehls, beispielsweise kistenscan, sudo, kick, ...
     */
    protected IngameCommand(String name) {
        this.name = name;
    }

    @Getter protected String name;

    /**
     * Wird aufgerufen, um zu prüfen, ob ein Spieler die Berechtigung hat, einen Message/IngameBefehl auszuführen.
     *
     * @param uuid      die UUID des Spielers
     * @param player    der Nutzername des Spielers
     * @param arguments die Argumente, die übergeben wurden
     * @return true, falls der Spieler den Befehl ausführen darf, false wenn nicht
     */
    public abstract boolean hasPermission(String uuid, String player, String... arguments);

    /**
     * Wird aufgerufen, nachdem die Permission eines Spielers gecheckt wurde und der Command nun ausgeführt werden soll.
     *
     * @param uuid      die UUID des Spielers
     * @param player    der Nutzername des Spielers
     * @param arguments die Argumente, die übergeben wurden
     */
    public abstract void execute(String uuid, String player, String... arguments);
}
