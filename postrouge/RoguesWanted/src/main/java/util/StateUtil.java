package main.java.util;

import main.java.util.InputUtil.InputState;

public class StateUtil {
	public static Boolean processInput(InputUtil.InputState state){
		
		if(state==InputState.QUIT){
			return true;
		}
		
		
		return false;
	}
}
