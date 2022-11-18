package de.byteandbit.velociraptor.api.events;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.slf4j.Logger;

import java.lang.reflect.Method;

/**
 * Der EventBus ist eines der wichtigsten Features der API.
 * Hier kannst du die ganzen Events abfangen, die durch Velociraptor geworfen werden.
 * Hier nachfolgend ein Beispiel für die Benutzung des EventBus:
 * <p>
 * public MeinEventListener() {
 * VelociraptorAPI.EVENT_BUS.register(this);
 * }
 * <p>
 * \@EventHandler
 * public void onSellEvent(SellPreCheckEvent event) {}
 */
public class EventBus {

    private Multimap<String, Object> eventListeners;
    private final Logger logger;

    public EventBus(Logger logger) {
        this.logger = logger;
        eventListeners = ArrayListMultimap.create();
    }

    /**
     * Registriert eine Klasse im EventBus.
     */
    public void register(Object o) {
        logger.info("EventBus#register(" + o.getClass().getName() + ")");

        for (Method m : o.getClass().getMethods()) {
            if (!m.isAnnotationPresent(EventHandler.class)) {
                continue;
            }
            if (m.getParameterCount() != 1) {
                continue;
            }
            Class<?> parameterType = m.getParameterTypes()[0];

            logger.info(String.format("EventBus registriert folgende Methode %s#%s(%s)", o.getClass().getName(), m.getName(), parameterType.getCanonicalName()));
            eventListeners.put(parameterType.getCanonicalName(), o);
        }
    }

    /**
     * Unregistriert eine Klasse vom EventBus.
     */
    public void unregister(Object o) {
        logger.info("EventBus#unregister(" + o.getClass().getName() + ")");
        for (Method m : o.getClass().getMethods()) {
            if (!m.isAnnotationPresent(EventHandler.class)) {
                continue;
            }
            if (m.getParameterCount() != 1) {
                continue;
            }
            Class<?> parameterType = m.getParameterTypes()[0];
            eventListeners.remove(parameterType.getCanonicalName(), o);
        }
    }

    /**
     * Wirft ein Event an alle registrierten Klassen im EventBus.
     */
    public <T> T post(T event) {
        logger.info("EventBus#post(" + event.getClass().getName() + ")");

        for (Object listener : eventListeners.get(event.getClass().getCanonicalName())) {
            for (Method m : listener.getClass().getMethods()) {
                if (!m.isAnnotationPresent(EventHandler.class)) {
                    continue;
                }
                if (m.getParameterCount() != 1) {
                    continue;
                }
                Class<?> parameterType = m.getParameterTypes()[0];
                if (!parameterType.getCanonicalName().equals(event.getClass().getCanonicalName())) continue;

                try {
                    m.invoke(listener, event);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("Der EventBus hat einen Fehler geworfen", e);
                }
            }
        }
        return event;
    }
}
