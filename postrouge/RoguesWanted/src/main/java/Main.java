package main.java;

import main.java.stateEngines.AbstractEngine;
import main.java.stateEngines.IntroEngine;
import main.java.util.DisplayUtil;
import main.java.util.TerminalUtil;

public class Main {
	
	public static void main(String[] args) {
		init();
		loop();
		quit();
	}
	
	private static void init(){
		TerminalUtil.initTerm("Rogues Wanted", DisplayUtil.SCREEN_HEIGHT+1, DisplayUtil.SCREEN_WIDTH);
	}
	
	private static void loop(){
		Boolean quit = false;
		AbstractEngine gameEngine = new IntroEngine(null);
		
		 while (!quit) { 
	         
	         //make game engine take a step
	         gameEngine = gameEngine.takeStep();
	         
	         //display current game state
	         if(gameEngine != null){
	         DisplayUtil.drawScreen(gameEngine);
	         }else{
	        	 quit = true;
	         } 
		 }
	}
	
	private static void quit(){
		TerminalUtil.quit();
	}

}
