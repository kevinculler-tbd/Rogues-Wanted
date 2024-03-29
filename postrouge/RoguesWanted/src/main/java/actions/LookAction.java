package main.java.actions;

import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.actors.ActorObjects.ActorCharacter;
import main.java.actors.LevelObjects.AbstractMapObject;
import main.java.util.PlayerSessionUtil;

public class LookAction extends AbstractAction{
	
	private int range;
	private ActorCharacter looker;
	public LookAction(int lookRange, ActorCharacter actorLooking){
		range = lookRange;
		looker = actorLooking;
	}

	@Override
	public String doAction(AbstractActorObject actor, AbstractMapObject target) {
		if(target!=null && PlayerSessionUtil.distanceSqr(target.getX(), target.getY(), looker.getX(), looker.getY())<=range){
			//XD move that dude
			actor.getEnvironment().getPossessions().remove(actor);
			target.addPossession(actor);
			actor.setEnvironment(target);
			actor.setX(target.getX());
			actor.setY(target.getY());
			actor.setToken(new DisplayObject(actor.getToken().getBackground(), actor.getToken().getForeground(), target.getDisplayObject().getCharacter()));
			
			String targetDiscription = "Looking at "+actor.getEnvironment().getDiscription();
				
			if(actor.getEnvironment().getPossessions().size()>1){
				targetDiscription = targetDiscription + " containing";
			}
			
			for ( AbstractActorObject possession: actor.getEnvironment().getPossessions()){
				if(possession.getDiscription() !=null){
					targetDiscription = targetDiscription+" :"+possession.getName();
				}
			}
			return targetDiscription;
		}
		return null;
	}

	@Override
	public String doConfirm(AbstractActorObject actor, AbstractMapObject target) {
		return doAction(actor, target);
	}

}
