package main.java.stateEngines;

import main.java.actions.AbstractAction;
import main.java.actions.AttackAction;
import main.java.actions.LookAction;
import main.java.actions.MoveAction;
import main.java.actions.PickupAction;
import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.Player;
import main.java.actors.LevelObjects.AbstractMapObject;
import main.java.util.PlayerSessionUtil;

import com.googlecode.blacken.terminal.BlackenKeys;

public class LevelEngine extends AbstractEngine{
	enum LevelInputState{UP, DOWN, LEFT, RIGHT, QUIT, LOOK, INVENTORY, PICKUP, USE, STATUS, ATTACK, HELP, NONE};

	public LevelEngine(AbstractEngine lstEng) {
		super(lstEng);
		PlayerSessionUtil.getPlayerSession().makeLobby();
		PlayerSessionUtil.getPlayerSession().getPlayer().setX(5);
		PlayerSessionUtil.getPlayerSession().getPlayer().setY(5);
		AbstractMapObject aObj = PlayerSessionUtil.getPlayerSession().getMapObjectAtCord(5, 5);
		aObj.addPossession(PlayerSessionUtil.getPlayerSession().getPlayer());
		PlayerSessionUtil.getPlayerSession().getPlayer().setEnvironment(aObj);
	}

	@Override
	public DisplayObject[][] getDisplayMap() {
//		AbstractMapObject[][] map = PlayerSessionUtil.getPlayerSession().getCurrentMap().getMap();
//		Player p = PlayerSessionUtil.getPlayerSession().getPlayer();
//		DisplayObject[][] drawMap = new DisplayObject[DisplayUtil.SCREEN_HEIGHT][DisplayUtil.SCREEN_WIDTH];
//		int orgX = p.getX()-(DisplayUtil.SCREEN_WIDTH/2);
//		int orgY = p.getY()-(DisplayUtil.SCREEN_HEIGHT/2);
//		
//		
//		for(int y = 0; y<DisplayUtil.SCREEN_HEIGHT; ++y){
//			for(int x = 0; x<DisplayUtil.SCREEN_WIDTH; ++x){
//				if(orgX+x>=0 &&
//				   orgY+y>=0 &&
//				   orgX+x<PlayerSessionUtil.getPlayerSession().getCurrentMap().getMaxX() &&
//				   orgY+y<PlayerSessionUtil.getPlayerSession().getCurrentMap().getMaxY()){
//					
//					 List<AbstractActorObject> tilePossessions = map[orgY+y][orgX+x].getPossessions();
//					 for (AbstractActorObject possession: tilePossessions){
//						 drawMap[y][x] = possession.getToken();
//						 if(possession.getProperties().get(PlayerSessionUtil.Property.BLOCKING)!=null && possession.getProperties().get(PlayerSessionUtil.Property.BLOCKING)>0){
//							 break;
//						 }
//					 }
//					 if(drawMap[y][x] == null){
//					 drawMap[y][x] = map[orgY+y][orgX+x].getDisplayObject();
//					 }
//				}
//			}
//		}
//		return drawMap;
		return PlayerSessionUtil.getPlayerSession().getPlayer().getCharacterVision();
	}

	@Override
	public String getOutputText() {
		String ret = actionMessage;
		actionMessage = null;
		return ret;
	}

	@Override
	public AbstractEngine takeStep() {
		LevelInputState state = doInput();
		AbstractEngine ret = this;
		int curY = PlayerSessionUtil.getPlayerSession().getPlayer().getY();
		int curX = PlayerSessionUtil.getPlayerSession().getPlayer().getX();
		Player p = PlayerSessionUtil.getPlayerSession().getPlayer();
		AbstractAction action;
		AbstractMapObject target;
		switch(state){
		case QUIT:
			ret = new QuitEngine(this);
			break;
		case UP:
			action = new MoveAction();
			target = PlayerSessionUtil.getPlayerSession().getMapObjectAtCord(curX, curY-1);
			actionMessage = action.doAction(PlayerSessionUtil.getPlayerSession().getPlayer(), target);
			break;
		case DOWN:
			action = new MoveAction();
			target = PlayerSessionUtil.getPlayerSession().getMapObjectAtCord(curX, curY+1);
			actionMessage = action.doAction(PlayerSessionUtil.getPlayerSession().getPlayer(), target);
			break;
		case LEFT:
			action = new MoveAction();
			target = PlayerSessionUtil.getPlayerSession().getMapObjectAtCord(curX-1, curY);
			actionMessage = action.doAction(PlayerSessionUtil.getPlayerSession().getPlayer(), target);
			break;
		case RIGHT:
			action = new MoveAction();
			target = PlayerSessionUtil.getPlayerSession().getMapObjectAtCord(curX+1, curY);
			actionMessage = action.doAction(PlayerSessionUtil.getPlayerSession().getPlayer(), target);
			break;
		case LOOK:
			ret = new TargetingEngine(this, new LookAction(p.getVisionSqr(), p), p.getVisionSqr(), p);
			break;
		case INVENTORY:
			ret = new InventoryEngine(this);
			break;
		case PICKUP:
			action = new PickupAction();
			target = PlayerSessionUtil.getPlayerSession().getMapObjectAtCord(curX, curY);
			actionMessage = action.doAction(PlayerSessionUtil.getPlayerSession().getPlayer(), target);
			if(actionMessage == null){
				ret = new SelectItemEngine(this, target);
			}
			break;
		case USE:
			ret = new UseInventoryEngine(this);
			break;
		case STATUS:
			ret = new StatusEngine(this);
			break;
		case ATTACK:
			ret = new TargetingEngine(this, new AttackAction(PlayerSessionUtil.getPlayerSession().getPlayer()), p.getVisionSqr(), p);
			break;
		case HELP:
			ret = new HelpEngine(this);
			break;
		}

		
		return ret;
	}
	
	private LevelInputState doInput(){
		int ch = getInput();
		LevelInputState state = LevelInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = LevelInputState.QUIT;
         	break;
         case BlackenKeys.KEY_UP:
        	 state = LevelInputState.UP;
         	break;
         case BlackenKeys.KEY_DOWN:
        	 state = LevelInputState.DOWN;
         	break;
         case BlackenKeys.KEY_LEFT:
        	 state = LevelInputState.LEFT;
         	break;
         case BlackenKeys.KEY_RIGHT:
        	 state = LevelInputState.RIGHT;
         	break;
         case 'l':
        	 state = LevelInputState.LOOK;
        	break;
         case 'i':
        	 state = LevelInputState.INVENTORY;
        	break;
         case 'g':
        	 state = LevelInputState.PICKUP;
        	break;
         case 'u':
        	 state = LevelInputState.USE;
        	break;
         case 's':
        	 state = LevelInputState.STATUS;
        	 break;
         case 'a':
        	 state = LevelInputState.ATTACK;
        	 break;
         case 'H':
        	 state = LevelInputState.HELP;
        	 break;
         case 'h':
        	 state = LevelInputState.HELP;
        	 break;
         }
		 
		 return state;
	}


}
