package incMU;

import java.sql.*;
import java.net.Socket;
import java.net.ServerSocket;

public class Main {
	
	private void Parse() {
		//partial match logic, compare noun to start of string or after each space
	}
	
	public static void main (String[] args) {
		ServerSocket ear = new ServerSocket(23);
		Connection database = DriveManager.getConnection(/*magic goes here*/);
		//TODO: voodoo
	}
	
	//TODO: gameloop
	//TODO: SQL magicks
	
}
