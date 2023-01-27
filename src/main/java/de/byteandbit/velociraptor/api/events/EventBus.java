package de.byteandbit.velociraptor.api.events;

import org.slf4j.Logger;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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

    private ReentrantReadWriteLock lock;
    private Map<String, List<Object>> eventListeners;
    private final Logger logger;

    public EventBus(Logger logger) {
        this.logger = logger;
        lock = new ReentrantReadWriteLock();
        eventListeners = new ConcurrentHashMap<>();
    }

    /**
     * Registriert eine Klasse im EventBus.
     */
    public void register(Object o) {
        lock.writeLock().lock();

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
            List<Object> listeners = eventListeners.getOrDefault(parameterType.getCanonicalName(), new ArrayList<>());
            listeners.add(o);

            eventListeners.put(parameterType.getCanonicalName(), listeners);
        }

        lock.writeLock().unlock();
    }

    /**
     * Unregistriert eine Klasse vom EventBus.
     */
    public void unregister(Object o) {
        lock.writeLock().lock();

        logger.info("EventBus#unregister(" + o.getClass().getName() + ")");
        for (Method m : o.getClass().getMethods()) {
            if (!m.isAnnotationPresent(EventHandler.class)) {
                continue;
            }
            if (m.getParameterCount() != 1) {
                continue;
            }
            Class<?> parameterType = m.getParameterTypes()[0];
            List<Object> listeners = eventListeners.getOrDefault(parameterType.getCanonicalName(), new ArrayList<>());
            listeners.remove(o);

            eventListeners.put(parameterType.getCanonicalName(), listeners);
        }

        lock.writeLock().unlock();
    }

    /**
     * Wirft ein Event an alle registrierten Klassen im EventBus.
     */
    public <T> T post(T event) {
        logger.info("EventBus#post(" + event.getClass().getName() + ")");

        for (Object listener : eventListeners.getOrDefault(event.getClass().getCanonicalName(), Collections.emptyList())) {
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
