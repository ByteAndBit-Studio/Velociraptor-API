package de.byteandbit.velociraptor.api.events.player;

import lombok.AllArgsConstructor;

/**
 * Dieses Event wird aufgerufen sobald dem Bot eine private Nachricht von einem Spieler gesendet wurde.
 */
@AllArgsConstructor()
public class PlayerPrivateMessageEvent extends PlayerEvent {
    private String message;

    /**
     * Gibt die Nachricht des Spielers zurück.
     */
    public String getMessage() {
        return message;
    }
}
