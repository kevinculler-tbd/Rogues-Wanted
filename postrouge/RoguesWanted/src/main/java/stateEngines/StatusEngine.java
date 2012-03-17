package main.java.stateEngines;

import main.java.actors.DisplayObject;
import main.java.util.PlayerSessionUtil;

import com.googlecode.blacken.terminal.BlackenKeys;

public class StatusEngine extends AbstractEngine{
	
	enum StatusInputState{QUIT,BACK,NONE}

	public StatusEngine(AbstractEngine lstEng) {
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
		// TODO Auto-generated method stub
		return PlayerSessionUtil.getPlayerSession().getPlayer().getStatus();
	}

	@Override
	public AbstractEngine takeStep() {
		StatusInputState state = doInput();
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
	
	private StatusInputState doInput(){
		int ch = getInput();
		StatusInputState state = StatusInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = StatusInputState.QUIT;
         	break;
         case BlackenKeys.KEY_ENTER:
        	 state = StatusInputState.BACK;
         	break;
         case BlackenKeys.KEY_ESCAPE:
        	 state = StatusInputState.BACK;
         	break;
         }
		 
		 return state;
	}

}
