package main.java.actors.LevelObjects;

import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;

public class FloorTile extends AbstractMapObject{
	
	public FloorTile(int xPos, int yPos){
		super();
		x=xPos;
		y=yPos;
		displayObject = new DisplayObject(0x000000, 0xeeeeee, ".");
		discription = "a dirty floor";
	}


	@Override
	public AbstractActorObject effectActor(AbstractActorObject act) {
		// TODO nothing safe sqare
		return null;
	}

}
