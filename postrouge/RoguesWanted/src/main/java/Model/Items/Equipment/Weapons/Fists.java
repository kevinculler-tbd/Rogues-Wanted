package main.java.Model.Items.Equipment.Weapons;

import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.actors.ActorObjects.ActorCharacter;
import main.java.util.PlayerSessionUtil;
import main.java.util.PlayerSessionUtil.ItemTarget;

public class Fists extends AbstractWeapon{
	
	public Fists(){
		super();
		name = "Fists";
		description = "Knocker Outers";
		icon = new DisplayObject(0x000000, 0x00ee00, "f");
		target = ItemTarget.ACTOR;
		value = 3;
		range = 1;
	}

	@Override
	public String use(AbstractActorObject target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String attack(ActorCharacter attacker, ActorCharacter target) {
		int roll = PlayerSessionUtil.getPlayerSession().randInt(20)+1;
		int damage = attacker.getStrMod()+PlayerSessionUtil.getPlayerSession().randInt(value)+1;
		if(roll ==1 ){
			attacker.setHp(attacker.getHp()-damage/2);
			if(attacker.checkDeath()){
				return "You knocked your block off!";
			}
			return "You punch yourself in the face!";
		}else if (roll == 20){
			target.setHp(target.getHp()-damage*2);
			boolean dead = target.checkDeath();
			if(dead){
				return "You put your fist through the "+target.getName()+"'s head!";
			}
			return "Critical hit for "+(damage*2)+" damage!";
		}else if(roll+attacker.getDexMod()>=target.getAc()){
			target.setHp(target.getHp()-damage);
			boolean dead = target.checkDeath();
			if(dead){
				return "You punch the "+target.getName()+" to death with "+damage+" damage!";
			}
			return "You punch the "+target.getName()+" for "+damage+" damage!";
		}
		return null;
	}
}
