package incMU;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketBuffer {
	
	try {
		Socket socket;
		BufferedReader buffer =
				new BufferedReader( new InputStreamReader( socket.getInputStream() ));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int rotation = 0, entityID, socketID;
	boolean vowel;
	
	//TODO: take inputs
	
	public SocketBuffer (Socket purpose) {
		int temp = Main.availableEntityID();
		new Entity( "Guest", "An unregistered character.", temp, Main.startingLocationID ); 
		socket = purpose;
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

