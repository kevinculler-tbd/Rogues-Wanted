package main.java.Model.Items.Equipment.Weapons;

import main.java.Model.Items.Equipment.AbstractEquipment;
import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.actors.ActorObjects.ActorCharacter;
import main.java.util.PlayerSessionUtil;
import main.java.util.PlayerSessionUtil.ItemTarget;

public class Pistol extends AbstractWeapon{
	
	public Pistol(){
		super();
		name = "Pistol";
		description = "Maker or the Bang";
		icon = new DisplayObject(0x000000, 0x00ee00, "p");
		target = ItemTarget.SELF;
		value = 6;
		range = 6;
	}

	@Override
	public String use(AbstractActorObject target) {
		String ret = "";
		if(target instanceof ActorCharacter){
			ActorCharacter targetCharacter = (ActorCharacter)target; 
			if (this.isEquiped){
				targetCharacter.removeEquipedItems(this);
				this.isEquiped = false;
				
				return "Removed "+name+" ";
			}
			for (AbstractEquipment equipment: targetCharacter.getEquipedItems()){
				if (equipment.getSlot() == slot && equipment.isEquiped()){
					ret = equipment.use(target);
					break;
				}
			}
			targetCharacter.addEquipedItems(this);
			this.isEquiped = true;
			
			return ret+"Equiped "+name;
			
			
		}

		return "Can't be used on that";
	}

	@Override
	public String attack(ActorCharacter attacker, ActorCharacter target) {
		int roll = PlayerSessionUtil.getPlayerSession().randInt(20)+1;
		int damage = attacker.getDexMod()+PlayerSessionUtil.getPlayerSession().randInt(value)+1;
		if(roll ==1 ){
			attacker.setHp(attacker.getHp()-damage/2);
			if(attacker.checkDeath()){
				return "Bang, you killed yourself!";
			}
			return "You shoot yourself in the foot!";
		}else if (roll == 20){
			target.setHp(target.getHp()-damage*2);
			boolean dead = target.checkDeath();
			if(dead){
				return "You put a bullet through the "+target.getName()+"'s head!";
			}
			return "Critical hit for "+(damage*2)+" damage!";
		}else if(roll+attacker.getDexMod()>=target.getAc()){
			target.setHp(target.getHp()-damage);
			boolean dead = target.checkDeath();
			if(dead){
				return "You shoot the "+target.getName()+" to death with "+damage+" damage!";
			}
			return "You shoot the "+target.getName()+" for "+damage+" damage!";
		}
		return null;
	}

}
