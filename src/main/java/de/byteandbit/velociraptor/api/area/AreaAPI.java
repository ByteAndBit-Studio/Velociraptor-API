package de.byteandbit.velociraptor.api.area;


/**
 * API für die Zonen und Bot Positionen.
 */
public interface AreaAPI {
    boolean isOnBotPos();

    void setHandler(AreaHandler handler);

    void resetHandler();
}
