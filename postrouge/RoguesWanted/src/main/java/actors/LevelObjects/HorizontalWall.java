package main.java.actors.LevelObjects;

import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.util.PlayerSessionUtil;

public class HorizontalWall extends AbstractMapObject {
	
	public HorizontalWall(int xPos, int yPos){
		super();
		x=xPos;
		y=yPos;
		displayObject = new DisplayObject(0x000000, 0xeeeeee, "-");
		properties.put(PlayerSessionUtil.Property.BLOCKING, 1);
		discription = "an old stone wall";
	}


	@Override
	public AbstractActorObject effectActor(AbstractActorObject act) {
		// TODO Auto-generated method stub
		return null;
	}

}
