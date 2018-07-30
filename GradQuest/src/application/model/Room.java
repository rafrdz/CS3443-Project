package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Model for the room object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Room {
    
    private int roomNum, numRows, numCols, curRow, curCol, prevRow, prevCol;
    private String difficulty;
    private char [][] room;

    public Room(int roomNumber, String difficulty) {
        this.setRoomNum(roomNumber);
        this.setDifficulty(difficulty);
    }
    
    public Room(int rows, int cols, int num) {
        this.numRows = rows;
        this.numCols = cols;
        this.setRoomNum(num);
        
        this.room = new char[rows][cols];
    }
    
    public static Room loadRoomData(String difficulty, int roomNum) {
        Scanner scan = null;
        String fileName = "./rooms/" + difficulty.toLowerCase() + "/" + "room" + roomNum + ".csv";
        Room temp = null;
        ArrayList<String> roomData = new ArrayList<String>();
        try {
            scan = new Scanner(new File(fileName));
            
            while(scan.hasNextLine()) {
                roomData.add(scan.nextLine());
            }
            
            int numOfRows = roomData.size();
            int numOfCols = roomData.get(0).length();
            
            temp = new Room(numOfRows, numOfCols, roomNum);
            
            for(int r = 0; r < numOfRows; r++) {
                for(int c = 0; c < numOfCols; c++) {
                    char letter = roomData.get(r).charAt(c);
                    temp.room[r][c] = letter;
                    if(letter == 'c') {
                        temp.updateCurrentLocation(r,c);
                    }
                }
            }
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } finally {
            if(scan != null) {
                scan.close();
            }
        }
        return temp;
    }
    
    public void move(char letter) {
        switch(letter) {
        case 'W':
            moveUp();
            break;
        case 'A':
            moveLeft();
            break;
        case 'S':
            moveDown();
            break;
        case 'D':
            moveRight();
            break;
        }
    }
    
    public void moveUp() {
        if(this.room[this.curRow - 1][this.curCol] != 'w') {
            this.updateCurrentLocation(this.curRow - 1, this.curCol);
        }
    }
    
    public void moveLeft() {
        if(this.room[this.curRow][this.curCol - 1] != 'w') {
            this.updateCurrentLocation(this.curRow - 1, this.curCol);
        }
    }
    
    public void moveDown() {
        if(this.room[this.curRow + 1][this.curCol] != 'w') {
            this.updateCurrentLocation(this.curRow - 1, this.curCol);
        }
    }
    
    public void moveRight() {
        if(this.room[this.curRow][this.curCol - 1] != 'w') {
            this.updateCurrentLocation(this.curRow - 1, this.curCol);
        }
    }
    
    public void updateCurrentLocation(int row, int col) {
        this.prevRow = this.curRow;
        this.prevCol = this.curCol;
        
        this.curRow = row;
        this.curCol = col;
    }
    
    public char getRoomLocation(int row, int col) {
        return this.room[row][col];
    }
    
    public int getPrevRow() {
        return this.prevRow;
    }
    
    public int getPrevCol() {
        return this.prevCol;
    }
    
    public int getCurRow() {
        return this.curRow;
    }
    
    public int getCurCol() {
        return this.curCol;
    }
    
    public int getNumRows() {
        return this.numRows;
    }
    
    public int getNumCols() {
        return this.numCols;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

}
