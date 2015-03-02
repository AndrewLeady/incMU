package incMU;

import java.util.*;

public class Entity {
	int[][] stats = new int[3][2]; //[A,B,C][max, current]
	int[][] skills = new int[5][2]; //[A,B,C,D,E][ID, XP]
	LinkedList<Integer> contains = new LinkedList<Integer>(); //what is located here
	LinkedList<Integer> behaves = new LinkedList<Integer>(); //attached behaviors
	int brainID, locationID, entityID; //AI, where is this, how to find it
	String desc; //description
	String name; //name

	//TODO: methods
}
