package incMU;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketBuffer {
	Socket socket;
	BufferedReader inputs;
	PrintWriter outputs;
	int rotation = 0, entityID, socketID;
	boolean vowel;
	
	public SocketBuffer (Socket purpose) throws IOException {
		int temp = Main.availableEntityID();
		new Entity( "Guest", "An unregistered character.", temp, Main.startingLocationID ); 
		socket = purpose;
		inputs = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
		outputs = new PrintWriter ( socket.getOutputStream(), true);
		entityID = Main.entities.get( temp ).getID();
		
	}
	
	public LinkedList<Character> rotate () throws IOException {
		LinkedList<Character> rotated = new LinkedList<Character>();
		int temp;
		while ( inputs.ready() ) {
			temp = (int) inputs.read();
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
	
	public void sendOutput (LinkedList<Character> message) {
		while (message.getFirst() != null) {
			outputs.write( message.getFirst() );
		}
	}
	
}

