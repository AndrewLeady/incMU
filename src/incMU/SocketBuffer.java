package incMU;

import java.util.*;
import java.net.Socket;

public class SocketBuffer {

	Socket socket;
	LinkedList<Character> buffer = new LinkedList<Character>();
	int rotation = 0, entityID, socketID;
	boolean vowel;
	
	//TODO: take inputs
	
	public SocketBuffer (Socket purpose) {
		new Entity( /*TODO*/ );
		socket = purpose;
		int temp = Main.openEntityID();
		entityID = Main.entities.get( temp ).getID();
		
	}
	
	public LinkedList<Character> rotate () {
		LinkedList<Character> rotated = new LinkedList<Character>();
		int temp;
		while (buffer.size() > 0) {
			temp = (int) buffer.poll();
			if ( (temp > 96) && (temp < 122) ) { temp -= 97; } //lower case
			else if ( (temp > 64) && (temp < 91)) { temp -= 65; } //upper case
			else { continue; } //not a letter
			if ( (temp == 0) || temp == 4 || temp == 8 || temp == 14 || temp == 20) { vowel = true; }
			else { vowel = false; }
			temp = ( (temp + rotation ) % 26) + 65;
			rotated.add((char)temp);
		}
		return rotated;
	}
	
}

