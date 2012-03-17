package main.java.actors.ActorObjects;

import java.util.ArrayList;

import main.java.Model.ActorClasses.VelociraptorClass;
import main.java.Model.Items.AbstractItem;
import main.java.actors.DisplayObject;
import main.java.util.PlayerSessionUtil;

public class Velociraptor extends ActorCharacter {
	

	
	public Velociraptor(int l){
		setActorClass(new VelociraptorClass());
		
		setVision(6);
		level = l;
		experience = actorClass.getHitDie()*level;
		for (int i = 0; i<level; ++i){
			maxHP = maxHP+PlayerSessionUtil.getPlayerSession().randInt(actorClass.getHitDie())+1+conMod;
		}
			hp = maxHP;
			
		defaultForegroundColor = 0x006620;
		token = new DisplayObject(0x000000, defaultForegroundColor, "V");
		properties.put(PlayerSessionUtil.Property.BLOCKING, 1);
		name = "Velociraptor";
		discription = "Deadly Raptor, Watch Out!";	

	}

}
