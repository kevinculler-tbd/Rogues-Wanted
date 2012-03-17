package main.java.stateEngines;

import main.java.actors.DisplayObject;

import com.googlecode.blacken.terminal.BlackenKeys;

public class HelpEngine extends AbstractEngine{
	private enum HelpInputState{QUIT,BACK, NONE};
	
	
	public HelpEngine(AbstractEngine lstEng) {
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
		String output;
		output ="Terminal Interface\n"+ 
        "Command keys include:\n"+ 
        "Use the arrow keys to move\n"+
        "F1  - to quit\n"+
        "H  - for help\n"+
        "g - pick up items\n"+
        "u - use items\n"+
        "i - view inventory\n"+
        "s - view character status\n"+
        "a - attack\n"+
        "l - look\n"+
        "Enter - confirm\n"+
        "Esc - go back\n";
		return output;
	}

	@Override
	public AbstractEngine takeStep() {
		HelpInputState state = doInput();
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
	
	private HelpInputState doInput(){
		int ch = getInput();
		HelpInputState state = HelpInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = HelpInputState.QUIT;
         	break;
         case BlackenKeys.KEY_ESCAPE:
        	 state = HelpInputState.BACK;
         	break;
         }
		 
		 return state;
	}

}
