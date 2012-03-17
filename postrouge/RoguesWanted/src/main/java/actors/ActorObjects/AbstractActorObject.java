package main.java.actors.ActorObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Model.Items.AbstractItem;
import main.java.actors.DisplayObject;
import main.java.actors.LevelObjects.AbstractMapObject;
import main.java.util.PlayerSessionUtil;
import main.java.util.PlayerSessionUtil.Property;

public class AbstractActorObject {

	protected int x;
	protected int y;
	protected DisplayObject token;
	protected AbstractMapObject environment;
	protected int id;
	protected Map<Property, Integer> properties;
	protected String discription;
	protected List<AbstractItem> inventory;
	protected String name;
	protected int defaultForegroundColor;

	public int getDefaultForegroundColor() {
		return defaultForegroundColor;
	}


	public AbstractActorObject(){
		id = PlayerSessionUtil.getNextActorId();
		properties = new HashMap<PlayerSessionUtil.Property, Integer>();
		inventory = new ArrayList<AbstractItem>();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AbstractMapObject getEnvironment() {
		return environment;
	}
	public void setEnvironment(AbstractMapObject environment) {
		this.environment = environment;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public DisplayObject getToken() {
		return token;
	}
	public void setToken(DisplayObject token) {
		this.token = token;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj){
		       return true;
		}
	    if (obj == null){
	        return false;
	    }
	    if (getClass() != obj.getClass()){
	        return false;
	    }
	    final AbstractActorObject other = (AbstractActorObject)obj;
	    if(other.getId() == id){
	    	return true;
	    }
		return false;
	}
	
	@Override
	public int hashCode() {
	    return id;
	}
	
	public Map<Property, Integer> getProperties() {
		return properties;
	}
	
	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	public List<AbstractItem> getInventory() {
		return inventory;
	}

	public void addInventoryItem(AbstractItem item){
		inventory.add(item);
	}
	public void removeInventoryItem(AbstractItem item){
		inventory.remove(item);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
