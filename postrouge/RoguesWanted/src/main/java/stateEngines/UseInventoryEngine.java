package main.java.stateEngines;

import main.java.Model.Items.AbstractItem;
import main.java.Model.Items.Equipment.AbstractEquipment;
import main.java.actions.AbstractAction;
import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.Player;
import main.java.util.PlayerSessionUtil;
import main.java.util.PlayerSessionUtil.ItemTarget;

import com.googlecode.blacken.terminal.BlackenKeys;

public class UseInventoryEngine extends AbstractEngine{
	
	enum UseInventoryInputState{QUIT,BACK,SELECTION,NONE}
	char input;
	private AbstractAction action;
	public UseInventoryEngine(AbstractEngine lstEng) {
		super(lstEng);
		// TODO Auto-generated constructor stub
	}
	
	public UseInventoryEngine(AbstractEngine lstEng, AbstractAction a) {
		super(lstEng);
		action = a;
		// TODO Auto-generated constructor stub
	}

	@Override
	public DisplayObject[][] getDisplayMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOutputText() {
		Player p = PlayerSessionUtil.getPlayerSession().getPlayer();
		if(p.getInventory().size() == 0){
			return "You have nothing in your inventory!";
		}
		String ret = "What do you want to use/equip/unequip?\n";
		for(AbstractItem item:p.getInventory()){
			String equiped = "";
			if(item instanceof AbstractEquipment && ((AbstractEquipment)item).isEquiped()){
				equiped = " (equiped)";
			}
			ret= ret+item.getSelectionKey()+". "+item.getName()+equiped+" - "+item.getDescription()+"\n";
		}
		return ret;
	}

	@Override
	public AbstractEngine takeStep() {
		UseInventoryInputState state = doInput();
		AbstractEngine ret = this;
		switch(state){
		case QUIT:
			ret = new QuitEngine(this);
			break;
		case BACK:
			ret = lastEngine;
			break;
		case SELECTION:
			Player p = PlayerSessionUtil.getPlayerSession().getPlayer();
			for(AbstractItem item: p.getInventory()){
				if(input == item.getSelectionKey()){
					if(item.getTarget()==ItemTarget.SELF){
						lastEngine.setActionMessage(item.use(p));
						ret = lastEngine;
					}else{
						ret = lastEngine;
					}
					break;
				}
			}
			break;
		}
		
		return ret;
	}
	
	private UseInventoryInputState doInput(){
		int ch = getInput();
		UseInventoryInputState state = UseInventoryInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = UseInventoryInputState.QUIT;
         	break;
         case BlackenKeys.KEY_ESCAPE:
        	 state = UseInventoryInputState.BACK;
         	break;
         }
		 if(ch > 64&& ch<123)
		 {
			 state = UseInventoryInputState.SELECTION;
			 input = (char)ch;
		 }
		 
		 return state;
	}

}