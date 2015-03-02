package incMU;

import java.util.ArrayList;
import java.util.LinkedList;
import java.sql.*;
import java.io.IOException;
import java.net.ServerSocket;


public class Main {
	
	class EarThread implements Runnable {
		public void run() {
		
			boolean continueRunning = true;
			ServerSocket ear;
			ear = new ServerSocket(23);
			while(continueRunning) { new SocketBuffer ( ear.accept() ); }
			ear.close();
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
	
	static int freshEntityID = -1, startingLocationID;
	static LinkedList<Integer> recycledEntityIDs = new LinkedList<Integer>();
	static ArrayList<Entity> entities = new ArrayList<Entity>();
	Connection database = DriveManager.getConnection(/*magic goes here*/);
	
	public static void main (String[] args) {
		
	}
	
	public static void loadEntity (int dbEntityID) {
		//TODO: load from db
	}
	
	public static int availableEntityID () {
		if (recycledEntityIDs.getFirst() != null){
			return recycledEntityIDs.removeLast();
		} else {
			freshEntityID++;
			return freshEntityID;
		}
	}
	
	//TODO: SQL magicks
	
}