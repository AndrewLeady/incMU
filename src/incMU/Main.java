package incMU;

import java.util.ArrayList;
import java.sql.*;
import java.io.IOException;
import java.net.ServerSocket;


public class Main {
	
	class EarThread implements Runnable {
		public void run() {
		
			boolean continueRunning = true;
			ServerSocket ear;
			try {
				ear = new ServerSocket(23);
				while(continueRunning) {
					new SocketBuffer ( ear.accept() );
				}
				ear.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class GameLoopThread implements Runnable {
		public void run() {
			
			int cursor = -1;
			
			while (true) {
				cursor = (cursor + 1) % Main.entities.size();
				Main.entities.get( cursor ).dance();
			}
			
		}
	}
	
	static int openEntityID = -1;
	static ArrayList<Entity> entities = new ArrayList<Entity>();
	
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