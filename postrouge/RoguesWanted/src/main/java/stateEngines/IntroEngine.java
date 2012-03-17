package main.java.stateEngines;

import main.java.actors.DisplayObject;
import main.java.util.DisplayUtil;

import com.googlecode.blacken.terminal.BlackenKeys;

public class IntroEngine extends AbstractEngine{
	
	public IntroEngine(AbstractEngine lstEng) {
		super(lstEng);
		// TODO Auto-generated constructor stub
	}

	private enum IntroInputState{QUIT,START, HELP, NONE};

	@Override
	public AbstractEngine takeStep() {
		IntroInputState state = doInput();
		AbstractEngine ret = this;
		switch(state){
		case QUIT:
			ret = new QuitEngine(this);
			break;
		case START:
			ret = new StartEngine(this);
			break;
		case HELP:
			ret = new HelpEngine(this);
			break;
		}
		
		return ret;
	}
	@Override
	public DisplayObject[][] getDisplayMap(){

		DisplayObject[][] ret = new DisplayObject[DisplayUtil.SCREEN_HEIGHT][DisplayUtil.SCREEN_WIDTH];
		for(int y = 0; y<DisplayUtil.SCREEN_HEIGHT; ++y){
			for (int x = 0; x<DisplayUtil.SCREEN_WIDTH; ++x){
				ret[y][x] = new DisplayObject(0xffee0000, 0x00eeeeee, "A");
			}
		}
		return ret;
	}
	@Override
	public String getOutputText() {
		
		return "Hello Intro Press H for help, F1 to quit";
	}
	
	private IntroInputState doInput(){
		int ch = getInput();
		IntroInputState state = IntroInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = IntroInputState.QUIT;
         	break;
         case BlackenKeys.KEY_ENTER:
        	 state = IntroInputState.START;
         	break;
         case 'H':
        	 state = IntroInputState.HELP;
        	 break;
         }
		 
		 return state;
	}
}
