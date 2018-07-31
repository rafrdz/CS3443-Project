package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Model for the EnemyGroup objects
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class EnemyGroup {
    
    private ArrayList<Enemy> enemies;
    
    public EnemyGroup() {
        this.enemies = new ArrayList<Enemy>();
    }
    
    public ArrayList<Enemy> loadEnemies(String difficulty, int roomNum) {
        Scanner scan = null;
        String fileName = "./rooms/" + difficulty.toLowerCase() + "/" + "room" + roomNum + ".csv";
        Enemy enemy = null;
        ArrayList<Enemy> tempEnemies = new ArrayList<Enemy>();
        try {
            scan = new Scanner(new File(fileName));
            
            while(scan.hasNextLine()) {
                String enemyData = scan.nextLine();
                String[] tokens = enemyData.split(",");
                enemy = new Enemy(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
                tempEnemies.add(enemy);
            }
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } finally {
            if(scan != null) {
                scan.close();
            }
        }
        return tempEnemies;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

}
