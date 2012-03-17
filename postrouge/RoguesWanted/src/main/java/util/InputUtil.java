package main.java.util;

import com.googlecode.blacken.terminal.BlackenKeys;

public class InputUtil {
	
	public enum InputState{NONE, UP, DOWN, LEFT, RIGHT, QUIT};
	public static InputState getInput(){
		 InputState state = InputState.NONE;
		 int ch = TerminalUtil.getTerm().getch();
         switch(ch) {
         case BlackenKeys.KEY_UP:
        	 state = InputState.UP;
         	break;
         case BlackenKeys.KEY_DOWN:
        	 state = InputState.DOWN;
         	break;
         case BlackenKeys.KEY_LEFT:
        	 state = InputState.LEFT;
         	break;
         case BlackenKeys.KEY_RIGHT:
        	 state = InputState.RIGHT;
         	break;
         case BlackenKeys.KEY_F01:
        	 state = InputState.QUIT;
         	break;
         default:
//        	 TerminalUtil.getTerm().puts(BlackenKeys.toString(ch)+", "+ch);
//        	 TerminalUtil.getTerm().puts("\n"); //$NON-NLS-1$
         	break;
         }
		return state;
	}
}
