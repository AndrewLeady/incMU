package incMU;

import java.util.LinkedList;

public class Entity {
	int[][] stats = { {20, 20, 20}, {10, 10, 10} }; //[A,B,C][max, current]
	int[][] skills = new int[5][2]; //[A,B,C,D,E][ID, XP]
	LinkedList<Integer> contains = new LinkedList<Integer>();
	LinkedList<Integer> behaves = new LinkedList<Integer>();
	int brainID, locationID, entityID = Main.openEntityID();
	boolean imobile;
	String name, desc;
	
	public Entity (String desiredName, String desiredDesc, int location) {
		name = desiredName;
		desc = desiredDesc;
		entityID = Main.openEntityID;
		Main.entities.add( this );
		enter(locationID);
	}
	
	public int setStat (int attribute, int type, int value) {
		int temp = value - stats[attribute][type];
		stats[attribute][type] = value;
		return temp;
	}
	
	public boolean enter (int containerID) {
		if (/*containerID exists and can pick this up*/) {
			locationID = containerID;
			Main.entities.get(containerID).contains.add(entityID);
			return 1;
		} else { return 0; }
	}
	
	public String getDescription() {
		return desc;
	}
	
	public int getID() {
		return entityID;
	}
	
	//TODO: behavior methods
	//TODO: brain methods
}
