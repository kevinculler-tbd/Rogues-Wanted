package main.java.stateEngines;

import main.java.actors.DisplayObject;

import com.googlecode.blacken.terminal.BlackenKeys;

public class StartEngine extends AbstractEngine{
	private enum StartInputState {NEXT,QUIT, NONE};
	public StartEngine(AbstractEngine lstEng) {
		super(lstEng);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DisplayObject[][] getDisplayMap() {
		// TODO Auto-generated method stub
		//put padding here to make text go in the center
		return null;
	}

	@Override
	public String getOutputText() {
		String ret = "Story Goes here! Press Enter ->";
		return ret;
	}

	@Override
	public AbstractEngine takeStep() {
		StartInputState state = doInput();
		AbstractEngine ret = this;
		switch(state){
		case QUIT:
			ret = new QuitEngine(this);
			break;
		case NEXT:
			ret = new ClassTOCEngine(this);
			break;
		}
		
		return ret;
	}
	
	private StartInputState doInput(){
		int ch = getInput();
		StartInputState state = StartInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = StartInputState.QUIT;
         	break;
         case BlackenKeys.KEY_ENTER:
        	 state = StartInputState.NEXT;
         	break;
         }
		 
		 return state;
	}

}
