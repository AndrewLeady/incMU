package incMU;

import java.sql.*;
import java.net.ServerSocket;

class Ear extends Thread throws IOException {
	
	public void run() {
	
		boolean continueRunning = true;
		ServerSocket ear = new ServerSocket(23);
		while(continueRunning) {
			SocketBuffer ( ear.accept() );
		}
		ear.close();
	}
}

public class Main {
	
	boolean continueRunning = true;
	int openID = -1;
	
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
	
	public int openID () {
		openID++;
		return openID;
	}
	
	//TODO: SQL magicks
	
}