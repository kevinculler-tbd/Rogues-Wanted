package main.java.stateEngines;

import main.java.actors.DisplayObject;
import main.java.util.PlayerSessionUtil;

import com.googlecode.blacken.terminal.BlackenKeys;

public class LobbyEngine extends AbstractEngine {
	enum LobbyInputState{UP,DOWN,LEFT,RIGHT,QUIT,NONE};
	public LobbyEngine(AbstractEngine lstEng) {
		super(lstEng);
		PlayerSessionUtil.getPlayerSession().getPlayer().setX(5);
		PlayerSessionUtil.getPlayerSession().getPlayer().setY(5);
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
		return null;
	}

	@Override
	public AbstractEngine takeStep() {
		LobbyInputState state = doInput();
		AbstractEngine ret = this;
		switch(state){
		case QUIT:
			ret = new QuitEngine(this);
			break;
		case UP:
			ret = new ClassTOCEngine(this);
			break;
		case DOWN:
			ret = new ClassTOCEngine(this);
			break;
		case LEFT:
			ret = new ClassTOCEngine(this);
			break;
		case RIGHT:
			ret = new ClassTOCEngine(this);
			break;
		}
		
		return ret;
	}
	
	private LobbyInputState doInput(){
		int ch = getInput();
		LobbyInputState state = LobbyInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = LobbyInputState.QUIT;
         	break;
         case BlackenKeys.KEY_UP:
        	 state = LobbyInputState.UP;
         	break;
         case BlackenKeys.KEY_DOWN:
        	 state = LobbyInputState.DOWN;
         	break;
         case BlackenKeys.KEY_LEFT:
        	 state = LobbyInputState.LEFT;
         	break;
         case BlackenKeys.KEY_RIGHT:
        	 state = LobbyInputState.RIGHT;
         	break;
         }
		 
		 return state;
	}
}
