package main.java.actors.ActorObjects;

import main.java.Model.Items.AbstractItem;
import main.java.exceptions.ItemInitException;

public class ItemIcon extends AbstractActorObject{
	
	public ItemIcon(AbstractItem i) throws ItemInitException{
		super();
		if(i == null){
			throw new ItemInitException();
		}
		token = i.getIcon();
		inventory.add(i);
		name=i.getName();
	}

	@Override
	public String getDiscription() {
		return inventory.get(0).getDescription();
	}
	
	public AbstractItem getItem(){
		return inventory.get(0);
	}

}