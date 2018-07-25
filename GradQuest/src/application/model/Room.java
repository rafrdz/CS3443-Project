package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    
    private int roomNumber;
    private String difficulty;
    private ArrayList<Enemy> enemies;
    
    public Room() {
        
    }
    
    public Room(int roomNumber, String difficulty) {
        this.roomNumber = roomNumber;
        this.difficulty = difficulty;
        this.enemies = new ArrayList<Enemy>();
    }
    
    public Room getRoomData(String difficulty, int roomNum) {
        boolean roomDataLoaded = loadRoomData(difficulty, roomNum);
        
        if(roomDataLoaded) {
            
        }
        return null;
    }
    
    private boolean loadRoomData(String difficulty, int roomNum) {
        Scanner scan = null;
        String directoryName = "../" + difficulty;
        String fileName = "room" + String.valueOf(roomNum) + ".csv";
        boolean roomLoaded = false;
        
        try {
            scan = new Scanner(new File(directoryName + fileName));
            
            while(scan.hasNextLine()) {
                String roomData = scan.nextLine();
                String[] tokens = roomData.split(",");
                System.out.println("Enemy name: " + tokens[0]);
                System.out.println("X Location: " + tokens[1]);
                System.out.println("Y Location: " + tokens[2]);
            }
            roomLoaded = true;
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            roomLoaded = false;
        } finally {
            scan.close();
        }
        return roomLoaded;
    }

}
