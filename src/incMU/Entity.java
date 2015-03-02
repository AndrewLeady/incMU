package incMU;

import java.util.*;

public class Entity {
	int[][] stats = new int[3][2]; //[A,B,C][max, current]
	int[][] skills = new int[5][2]; //[A,B,C,D,E][ID, XP]
	LinkedList<Integer> contains = new LinkedList<Integer>();
	LinkedList<Integer> behaves = new LinkedList<Integer>();
	int brainID, locationID, entityID;
	String desc;
	String name;
	
	public int fromDatabase (int entityID) { //spawn Entity
		//TODO
		return entityID;
	}
	
	public int setStat (int attribute, int type, int value) {
		int temp = value - stats[attribute][type];
		stats[attribute][type] = value;
		return temp;
	}
	
	public boolean enter (int containerID) {
		if (/*containerID exists and can pick this up*/) {
			locationID = containerID;
			/*containerID*/.add(entityID);
			return 1;
		} else { return 0; }
	}
	
	public String readDescription() {
		return desc;
	}
	
	//TODO: behavior methods
	//TODO: brain methods
}
