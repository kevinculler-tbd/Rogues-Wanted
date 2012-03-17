package main.java.util;

import java.util.ArrayList;
import java.util.List;

import main.java.Model.ActorClasses.AbstractActorClass;
import main.java.Model.ActorClasses.HumanCivActorClass;

public class ActorClassUtil {
	private static List<AbstractActorClass> actorClasses;
	
	static {
		actorClasses = new ArrayList<AbstractActorClass>();
		actorClasses.add(new HumanCivActorClass());
	}
	
	public static List<AbstractActorClass> getActorClasses()
	{
		return actorClasses;
	}

}
