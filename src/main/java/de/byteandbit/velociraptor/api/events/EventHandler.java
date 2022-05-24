package de.byteandbit.velociraptor.api.events;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Markiert eine Methode für den EventBus.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
}
