package main.java.stateEngines;

import main.java.actors.DisplayObject;

public class QuitEngine extends AbstractEngine{
	enum QuitInputState{YES, NO, NONE};
	public QuitEngine(AbstractEngine lstEng) {
		super(lstEng);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractEngine takeStep() {
		QuitInputState state = doInput();
		AbstractEngine ret = this;
		switch(state){
		case YES:
			ret = null;
			break;
		case NO:
			ret = lastEngine;
			break;
		}
		
		return ret;
	}

	@Override
	public DisplayObject[][] getDisplayMap() {
		
		return lastEngine.getDisplayMap();
	}

	@Override
	public String getOutputText() {
		String ret = "Do you really want to quit? Y/n :";
		return ret;
	}
	
	private QuitInputState doInput(){
		int ch = getInput();
		QuitInputState state = QuitInputState.NONE;
		 switch(ch) {
         case 'Y':
        	 state = QuitInputState.YES;
         	break;
         case 'n':
        	 state = QuitInputState.NO;
         	break;
         }
		 
		 return state;
	}

}
