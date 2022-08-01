package de.byteandbit.velociraptor.api.events.player;

import de.byteandbit.velociraptor.api.events.Event;
import lombok.AllArgsConstructor;

/**
 * Basis für jegliche spielerbezogene Events.
 */
@AllArgsConstructor
public abstract class PlayerEvent extends Event {
    protected String playerName;
    protected String playerUUID;

    /**
     * Gibt den Spielernamen zurück, der das Event verursacht hat.
     *
     * @return der echte Spielername (nicht der Nickname!)
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Gibt die UUID des Spielers zurück, der das Event verursacht hat.
     *
     * @return die Spieler UUID
     */
    public String getPlayerUUID() {
        return playerUUID;
    }
}
