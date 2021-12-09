package de.byteandbit.velociraptor.api.event;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.event.api.PacketReceiveEvent;

import java.lang.reflect.Method;

public class EventBus {

    private Multimap<Class<?>, Object> eventListeners;

    public EventBus() {
        eventListeners = ArrayListMultimap.create();
    }

    public void register(Object o) {
        Velociraptor.getLogger().info("EventBus#register(" + o.getClass().getName() + ")");

        for(Method m : o.getClass().getMethods()) {
            if(!m.isAnnotationPresent(EventHandler.class)) {
                continue;
            }
            if(m.getParameterCount() != 1) {
                continue;
            }
            Velociraptor.getLogger().info(String.format("EventBus registriert folgende Methode %s#%s", o.getClass().getName(), m.getName()));

            Class<?> parameterType = m.getParameterTypes()[0];
            eventListeners.put(parameterType, o);
        }
    }

    public void unregister(Object o) {
        Velociraptor.getLogger().info("EventBus#unregister(" + o.getClass().getName() + ")");
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

    public <T> T post(T event) {
        if(event.getClass() != PacketReceiveEvent.class) Velociraptor.getLogger().info("EventBus#post(" + event.getClass().getName() + ")");

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
                    Velociraptor.getLogger().error("Der EventBus hat einen Fehler geworfen",e);
                }
            }
        }
        return event;
    }
}
