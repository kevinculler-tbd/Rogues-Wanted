package main.java.Model.Items.Equipment;

import main.java.Model.Items.AbstractItem;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.util.PlayerSessionUtil.EquipmentSlot;

public abstract class AbstractEquipment extends AbstractItem{
	protected EquipmentSlot slot;
	protected boolean isEquiped;
	
	@Override
	public abstract String use(AbstractActorObject target);
	
	public boolean isEquiped() {
		return isEquiped;
	}

	public void setEquiped(boolean isEquiped) {
		this.isEquiped = isEquiped;
	}

	public EquipmentSlot getSlot() {
		return slot;
	}

	public void setSlot(EquipmentSlot slot) {
		this.slot = slot;
	}

}
