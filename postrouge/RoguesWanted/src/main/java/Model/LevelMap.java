package main.java.Model;

import java.util.ArrayList;
import java.util.List;

import main.java.actors.ActorObjects.ActorCharacter;
import main.java.actors.LevelObjects.AbstractMapObject;

public class LevelMap {
	
	private AbstractMapObject[][] map;
	
	private List<ActorCharacter> actionableActors;
	
	int maxX;
	int maxY;

	public LevelMap(){
		actionableActors = new ArrayList<ActorCharacter>();
	}
	
	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	
	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	public AbstractMapObject[][] getMap() {
		return map;
	}

	public void setMap(AbstractMapObject[][] map) {
		this.map = map;
	}

	public List<ActorCharacter> getActionableActors() {
		return actionableActors;
	}

	public void setActionableActors(List<ActorCharacter> actionableActors) {
		this.actionableActors = actionableActors;
	}
	
	public void addActionableActor(ActorCharacter actor){
		actionableActors.add(actor);
	}
	public void removeActionableActor(ActorCharacter actor){
		actionableActors.remove(actor);
	}
}
