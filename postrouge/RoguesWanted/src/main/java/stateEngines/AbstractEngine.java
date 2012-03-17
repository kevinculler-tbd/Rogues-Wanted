package main.java.stateEngines;

import main.java.actors.DisplayObject;
import main.java.util.TerminalUtil;

public abstract class AbstractEngine {
	
	protected AbstractEngine lastEngine;
	
	protected String actionMessage;

	public AbstractEngine(AbstractEngine lstEng){
		lastEngine = lstEng;
	}
	
	public abstract DisplayObject[][] getDisplayMap();
	
	public abstract String getOutputText();
	
	public abstract AbstractEngine takeStep();
	
	public int getInput(){
		return TerminalUtil.getTerm().getch();
	}

	public AbstractEngine getLastEngine() {
		return lastEngine;
	}

	public void setLastEngine(AbstractEngine lastEngine) {
		this.lastEngine = lastEngine;
	}
	
	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}
}
