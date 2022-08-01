package de.byteandbit.velociraptor.api.events.player;

/**
 * Dieses Event wird aufgerufen sobald dem Bot eine private Nachricht von einem Spieler gesendet wurde.
 */
public class PlayerPrivateMessageEvent extends PlayerEvent {
    private String message;

    public PlayerPrivateMessageEvent(String playerName, String playerUUID, String message) {
        super(playerName, playerUUID);
    }

    /**
     * Gibt die Nachricht des Spielers zurück.
     */
    public String getMessage() {
        return message;
    }
}
