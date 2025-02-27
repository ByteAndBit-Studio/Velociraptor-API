package de.byteandbit.velociraptor.api.chat;

import java.util.function.Consumer;

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

    /**
     * Sendet eine Nachricht oder einen Befehl.
     *
     * @param message  die Nachricht/der Befehl
     * @param callback callback für den tatsächlichen Zeitpunkt des Sendens
     * @see ChatMessage
     */
    void send(ChatMessage message, Consumer<ChatMessage> callback);
}
