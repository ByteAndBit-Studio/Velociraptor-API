package de.byteandbit.velociraptor.api.events.purchase;

import de.byteandbit.velociraptor.api.data.item.ItemAction;
import de.byteandbit.velociraptor.api.events.Event;
import lombok.Getter;

/**
 * description missing.
 */
public class ItemActionEvent extends Event
{
	@Getter
	boolean cancelled = false;

	@Getter
	private final ItemAction action;
	@Getter
	private String cancelReason;
	public void setCancelled(String reason)
	{
		this.cancelled = true;
		this.cancelReason = reason;
	}

	public ItemActionEvent(ItemAction action)
	{
		this.action = action;
	}
}
