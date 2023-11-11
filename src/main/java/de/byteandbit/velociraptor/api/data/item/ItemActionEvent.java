package de.byteandbit.velociraptor.api.data.item;

import de.byteandbit.velociraptor.api.events.Event;
import de.byteandbit.velociraptor.api.events.player.PlayerEvent;
import lombok.Getter;

/**
 * description missing.
 */
@Getter
public class ItemActionEvent<T extends PlayerEvent> extends Event
{
	boolean cancelled = false;
	@Getter
	final T callingEvent; // aktuell entweder ein AfterSellEvent oder ein AfterBuyEvent
	@Getter
	private final ItemAction action;
	@Getter
	private String cancelReason;
	public void setCancelled(String reason)
	{
		this.cancelled = true;
		this.cancelReason = reason;
	}

	public ItemActionEvent(ItemAction action, T callingEvent)
	{
		this.action = action;
		this.callingEvent = callingEvent;
	}
}
