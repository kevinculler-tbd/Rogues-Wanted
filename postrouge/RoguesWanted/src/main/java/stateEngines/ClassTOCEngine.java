package main.java.stateEngines;

import main.java.Model.ActorClasses.AbstractActorClass;
import main.java.actors.DisplayObject;
import main.java.actors.ActorObjects.Player;
import main.java.util.ActorClassUtil;
import main.java.util.PlayerSessionUtil;

import com.googlecode.blacken.terminal.BlackenKeys;

public class ClassTOCEngine extends AbstractEngine {

	enum ClassTOCInputState{QUIT, NONE, CLASS};
	int classChosen;
	
	public ClassTOCEngine(AbstractEngine lstEng) {
		super(lstEng);
		
	}

	@Override
	public DisplayObject[][]getDisplayMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOutputText() {
		String output = "";
		for (int i=0; i<ActorClassUtil.getActorClasses().size(); ++i){
			AbstractActorClass ac = ActorClassUtil.getActorClasses().get(i);
			char classChar = (char)(i+65);
			output = output+classChar+". "+ac.getClassDisplayName()+"\n";
		}
		return output;
	}

	@Override
	public AbstractEngine takeStep() {
	
		ClassTOCInputState state = doInput();
		AbstractEngine ret = this;
		switch(state){
		case QUIT:
			ret = new QuitEngine(this);
			break;
		case CLASS:
			AbstractActorClass actorClass = ActorClassUtil.getActorClasses().get(classChosen);
			if(actorClass!=null){
				PlayerSessionUtil.getPlayerSession().setPlayer(new Player(ActorClassUtil.getActorClasses().get(classChosen)));
				ret = new LevelEngine(this);
			}
			break;
		}
		
		return ret;
	}
	
	private ClassTOCInputState doInput(){
		int ch = getInput();
		ClassTOCInputState state = ClassTOCInputState.NONE;
		 switch(ch) {
         case BlackenKeys.KEY_F01:
        	 state = ClassTOCInputState.QUIT;
         	break;
         }
		 
		 if(ch > 64&& ch<=(ActorClassUtil.getActorClasses().size()+64))
		 {
			 state = ClassTOCInputState.CLASS;
			 classChosen = ch-65;
		 }
		 
		 return state;
	}
}
