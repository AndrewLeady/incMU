package incMU;

import java.util.ArrayList;
import java.sql.*;
import java.net.ServerSocket;

class Ear extends Thread throws IOException {
	
	public void run() {
	
		boolean continueRunning = true;
		ServerSocket ear = new ServerSocket(23);
		while(continueRunning) {
			new SocketBuffer ( ear.accept() );
		}
		ear.close();
	}
}

public class Main {
	
	static boolean continueRunning = true;
	static int openEntityID = -1;
	static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	private void Parse() {
		//partial match logic, compare noun to start of string or after each space
	}
	
	public static void main (String[] args) {
		Connection database = DriveManager.getConnection(/*magic goes here*/);
		while (true) {
			
			//game goes here
			//TODO: voodoo
		}
	}
	
	public static int openEntityID () {
		openEntityID++;
		return openEntityID;
	}
	
	//TODO: SQL magicks
	
}