package main.java.Model.Items;

import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.util.PlayerSessionUtil;
import main.java.util.PlayerSessionUtil.ItemTarget;

public class PistolAmmo extends AbstractItem{
	
	
	
	public PistolAmmo(){
		name = "Pistol Ammo";
		description =" bullets for a pistol";
		icon = new DisplayObject(0x000000, 0xee0000, "m");
		target = ItemTarget.SELF;
		value = PlayerSessionUtil.getPlayerSession().randInt(12)+1;
		range = 0;
	}

	@Override
	public String use(AbstractActorObject target) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getDescription(){
		return value+description;
	}
	
	

}
