package main.java.stateEngines;

import main.java.Model.Items.AbstractItem;
import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.Player;
import main.java.stateEngines.SelectItemEngine.SelectItemInputState;
import main.java.util.PlayerSessionUtil;

import com.googlecode.blacken.terminal.BlackenKeys;

public class InventoryEngine extends AbstractEngine{
	
	enum InventoryInputState{QUIT,BACK,NONE}
	public InventoryEngine(AbstractEngine lstEng) {
		super(lstEng);
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
		String ret = "Inventory: \n";
		for(AbstractItem item:p.getInventory()){
			ret= ret+item.getName()+" - "+item.getDescription()+"\n";
		}
		return ret;
	}

	@Override
	public AbstractEngine takeStep() {
		InventoryInputState state = doInput();
		AbstractEngine ret = this;
		switch(state){
		case QUIT:
			ret = new QuitEngine(this);
			break;
		case BACK:
			ret = lastEngine;
			break;
		}
		
		return ret;
	}
	
	private InventoryInputState doInput(){
		int ch = getInput();
		InventoryInputState state = InventoryInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = InventoryInputState.QUIT;
         	break;
         case BlackenKeys.KEY_ENTER:
        	 state = InventoryInputState.BACK;
         	break;
         case BlackenKeys.KEY_ESCAPE:
        	 state = InventoryInputState.BACK;
         	break;
         }
		 
		 return state;
	}

}



