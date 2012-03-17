package main.java.Model.Items;

import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.util.PlayerSessionUtil.ItemTarget;

public class MedKit extends AbstractItem {
	
	public MedKit(){
		name = "MedKit";
		description ="Heals you 10 hp";
		icon = new DisplayObject(0x000000, 0xee0000, "m");
		target = ItemTarget.SELF;
		value = 10;
		range = 0;
	}


	@Override
	public String use(AbstractActorObject user) {
		// TODO Auto-generated method stub
		return null;
	}

}
