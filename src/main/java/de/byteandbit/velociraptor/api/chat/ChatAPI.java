package de.byteandbit.velociraptor.api.chat;

/**
 * Die ChatAPI ist zuständig für die Verwaltung des Chats, das Abfangen von Chat Nachrichten,
 * die Validierung von Geldeingängen sowie das geordnete Senden von Befehlen.
 */
public interface ChatAPI {

    /**
     * Sendet eine Nachricht oder einen Befehl.
     *
     * @param message die Nachricht/der Befehl
     * @see ChatMessage
     */
    void send(ChatMessage message);
}
