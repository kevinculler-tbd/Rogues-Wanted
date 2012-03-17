package main.java.Model.Items.Equipment;

import main.java.Model.Items.Equipment.AbstractEquipment;
import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.actors.ActorObjects.ActorCharacter;
import main.java.util.PlayerSessionUtil.EquipmentSlot;
import main.java.util.PlayerSessionUtil.ItemTarget;

public class Jacket extends AbstractEquipment{
	
	public Jacket(){
		name = "Blue Jacket";
		description ="keeps you warm at night";
		icon = new DisplayObject(0x000000, 0x0000ee, "j");
		target = ItemTarget.SELF;
		slot = EquipmentSlot.CHEST;
		value = 5;
		range = 0;
	}

	@Override
	public String use(AbstractActorObject target) {
		String ret = "";
		if(target instanceof ActorCharacter){
			ActorCharacter targetCharacter = (ActorCharacter)target; 
			if (this.isEquiped){
				targetCharacter.setAc(targetCharacter.getAc() - value);
				targetCharacter.getToken().setForeground(targetCharacter.getDefaultForegroundColor());
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
			
			targetCharacter.setAc(targetCharacter.getAc() + value);
			targetCharacter.getToken().setForeground(icon.getForeground());
			targetCharacter.addEquipedItems(this);
			this.isEquiped = true;
			
			return ret+"Put on "+name;
			
			
		}

		return "Can't be used on that";
	}

}
