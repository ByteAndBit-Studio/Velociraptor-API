package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.events.Event;
import lombok.Getter;

/**
 * description missing.
 */
@Getter
public class ItemActionAbortedEvent extends Event
{
	private final ItemActionEvent itemActionEvent;
	public ItemActionAbortedEvent(ItemActionEvent event){
		itemActionEvent = event;
	}
}
