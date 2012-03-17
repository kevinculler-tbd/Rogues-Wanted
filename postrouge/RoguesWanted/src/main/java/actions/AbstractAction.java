package main.java.actions;

import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.actors.LevelObjects.AbstractMapObject;

public abstract class AbstractAction {
	public abstract String doAction(AbstractActorObject actor, AbstractMapObject target);
	public abstract String doConfirm(AbstractActorObject actor, AbstractMapObject target);
}
