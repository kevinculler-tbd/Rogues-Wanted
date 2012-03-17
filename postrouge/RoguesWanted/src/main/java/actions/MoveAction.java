package main.java.actions;

import main.java.actors.ActorObjects.AbstractActorObject;
import main.java.actors.LevelObjects.AbstractMapObject;
import main.java.util.PlayerSessionUtil;

public class MoveAction extends AbstractAction{

	@Override
	public String doAction(AbstractActorObject actor, AbstractMapObject target) {
		//check properties of actor environment...when can actor move 
		if(target!=null){
		Integer entangleStr = actor.getEnvironment().getProperties().get(PlayerSessionUtil.Property.ENTANGLING);
			//ENTANGLING can't move without a strength check
			
			//Do str check
			
			//if pass or entangleStr==null Move
			
			//else return you suck message

		
		//check properties of target...can it be moved into
		Integer targetBlockVal = target.getProperties().get(PlayerSessionUtil.Property.BLOCKING);
		Integer actorBlockVal = actor.getProperties().get(PlayerSessionUtil.Property.BLOCKING);
		if(targetBlockVal!=null && targetBlockVal>0 && actorBlockVal>0){
			return "Ouch that is a wall";
		}
		
		//check possessions of the target...is something stopping up from moving into it
		for(AbstractActorObject possessions: target.getPossessions()){
			Integer possessionBlock = possessions.getProperties().get(PlayerSessionUtil.Property.BLOCKING);
			if(possessionBlock!=null && possessionBlock>0 && actorBlockVal > 0){
				return "There is a(n) " + possessions.getName()+" in the way!";
			}
		}
		
		//XD move that dude
		actor.getEnvironment().getPossessions().remove(actor);
		target.addPossession(actor);
		actor.setEnvironment(target);
		actor.setX(target.getX());
		actor.setY(target.getY());
		}
		return null;
	}

	@Override
	public String doConfirm(AbstractActorObject actor, AbstractMapObject target) {
		// TODO Auto-generated method stub
		return null;
	}

}
