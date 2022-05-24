package de.byteandbit.velociraptor.api.events;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import de.byteandbit.velociraptor.api.VelociraptorAPI;

import java.lang.reflect.Method;

/**
 * Der EventBus ist eines der wichtigsten Features der API.
 * Hier kannst du die ganzen Events abfangen, die durch Velociraptor geworfen werden.
 * Hier nachfolgend ein Beispiel für die Benutzung des EventBus:
 *
 * public MeinEventListener() {
 *   VelociraptorAPI.EVENT_BUS.register(this);
 * }
 *
 * \@EventHandler
 * public void onSellEvent(SellPreCheckEvent event) {}
 */
public class EventBus {

    private Multimap<Class<?>, Object> eventListeners;

    public EventBus() {
        eventListeners = ArrayListMultimap.create();
    }

    /**
     * Registriert eine Klasse im EventBus.
     */
    public void register(Object o) {
        VelociraptorAPI.getLogger().info("EventBus#register(" + o.getClass().getName() + ")");

        for(Method m : o.getClass().getMethods()) {
            if(!m.isAnnotationPresent(EventHandler.class)) {
                continue;
            }
            if(m.getParameterCount() != 1) {
                continue;
            }
            VelociraptorAPI.getLogger().info(String.format("EventBus registriert folgende Methode %s#%s", o.getClass().getName(), m.getName()));

            Class<?> parameterType = m.getParameterTypes()[0];
            eventListeners.put(parameterType, o);
        }
    }

    /**
     * Unregistriert eine Klasse vom EventBus.
     */
    public void unregister(Object o) {
        VelociraptorAPI.getLogger().info("EventBus#unregister(" + o.getClass().getName() + ")");
        for(Method m : o.getClass().getMethods()) {
            if(!m.isAnnotationPresent(EventHandler.class)) {
                continue;
            }
            if(m.getParameterCount() != 1) {
                continue;
            }
            Class<?> parameterType = m.getParameterTypes()[0];
            eventListeners.remove(parameterType, o);
        }
    }

    /**
     * Wirft ein Event an alle registrierten Klassen im EventBus.
     */
    public <T> T post(T event) {
        if(!event.getClass().getName().contains("PacketReceiveEvent")) VelociraptorAPI.getLogger().info("EventBus#post(" + event.getClass().getName() + ")");

        for(Object listener : eventListeners.get(event.getClass())) {
            for(Method m : listener.getClass().getMethods()) {
                if(!m.isAnnotationPresent(EventHandler.class)) {
                    continue;
                }
                if(m.getParameterCount() != 1) {
                    continue;
                }
                Class<?> parameterType = m.getParameterTypes()[0];
                if(parameterType != event.getClass()) continue;

                try {
                    m.invoke(listener, event);
                } catch (Exception e) {
                    VelociraptorAPI.getLogger().error("Der EventBus hat einen Fehler geworfen",e);
                }
            }
        }
        return event;
    }
}
