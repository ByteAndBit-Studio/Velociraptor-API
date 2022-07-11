package de.byteandbit.velociraptor.api.chat;

/**
 * Definiert die Priorität, mit der Befehle/Nachrichten gesendet werden.
 * Je höher die Priorität ist, desto schneller wird der Befehl/die Nachricht gesendet, wenn mehrer Nachrichten in der Warteschlange sind.
 */
public final class ChatPriority {

    private int value;

    private ChatPriority(int value) {
        this.value = value;
    }

    /**
     * Gibt den Wert der ChatPriority zurück.
     */
    public int value() {
        return value;
    }


    public static final ChatPriority LOW = new ChatPriority(1);
    public static final ChatPriority NORMAL = new ChatPriority(2);
    public static final ChatPriority MEDIUM = new ChatPriority(3);
    public static final ChatPriority HIGH = new ChatPriority(4);
    public static final ChatPriority HIGHEST = new ChatPriority(5);
}
