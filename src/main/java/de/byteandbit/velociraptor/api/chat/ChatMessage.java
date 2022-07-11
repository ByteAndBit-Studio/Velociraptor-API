package de.byteandbit.velociraptor.api.chat;

import lombok.Getter;

/**
 * Repräsentiert eine ChatNachricht oder einen Befehl.
 * Wird über die statischen Methoden command(), chat() oder plotChat() initialisiert.
 *
 * @example <p>ChatMessage.command().text("spawn")</p>
 * @example <p>ChatMessage.chat().text("Hallo liebe User!")</p>
 */
public class ChatMessage {

    private ChatMessage() {
    }

    private ChatMessage(Type type) {
        this.type = type;
    }

    @Getter private String message;
    @Getter private Type type;
    @Getter private int priority = ChatPriority.NORMAL.value();

    /**
     * Erstellt eine ChatMessage, die als Befehl ausgeführt wird.
     */
    public static ChatMessage command() {
        return new ChatMessage(Type.COMMAND);
    }

    /**
     * Erstellt eine ChatMessage, die in den normalen Chat geschickt wird.
     */
    public static ChatMessage chat() {
        return new ChatMessage(Type.CHAT);
    }

    /**
     * Erstellt eine ChatMessage, die in den Plot Chat geschickt wird.
     */
    public static ChatMessage plotChat() {
        return new ChatMessage(Type.PLOT_CHAT);
    }

    /**
     * Setzt die Nachricht, die geschickt werden soll.
     *
     * @param message   Nachricht, die geschickt werden soll
     * @param arguments Argumente zu dieser Nachricht (siehe Beispiele)
     * @example <p>message.text("spawn")</p>
     * @example <p>message.text("p deny %s", "Maxi1204")</p>
     * @example <p>message.text("time %d", 1200)</p>
     * @example <p>message.text("Der Spieler %s ist heute %s mit %d Punkten!", "Maxi1204", "glücklich", 5)</p>
     */
    public ChatMessage text(String message, Object... arguments) {
        if (this.type != Type.COMMAND && message.startsWith("/")) {
            while (message.startsWith("/")) {
                message = message.substring(1);
            }
        }

        this.message = String.format(message, arguments);
        return this;
    }

    /**
     * Setzt die Chat Priorität.
     *
     * @see ChatPriority
     */
    public ChatMessage priority(ChatPriority priority) {
        this.priority = priority.value();
        return this;
    }

    public enum Type {
        COMMAND,
        PLOT_CHAT,
        CHAT;
    }
}
