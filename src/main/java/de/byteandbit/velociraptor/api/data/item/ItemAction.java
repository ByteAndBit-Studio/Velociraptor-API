package de.byteandbit.velociraptor.api.data.item;

public class ItemAction
{
	public enum ItemActionType{
		CHAT, NOTIFY;
	}

	public ItemActionType getType()
	{
		return type;
	}

	public void setType(ItemActionType type)
	{
		this.type = type;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public ItemAction(ItemActionType type, String content)
	{
		this.type = type;
		this.content = content;
	}

	private ItemActionType type;
	private String content;
}
