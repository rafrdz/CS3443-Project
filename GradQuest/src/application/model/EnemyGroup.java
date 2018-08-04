package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    
    public static ArrayList<IEntity> loadEnemies(String difficulty, int roomNum, AnchorPane anchorPane) {
        Scanner scan = null;
        String fileName = "./rooms/" + difficulty.toLowerCase() + "/" + "room" + roomNum + ".csv";
        ArrayList<IEntity> tempEnemies = new ArrayList<IEntity>();
        try {
            scan = new Scanner(new File(fileName));
            
            while(scan.hasNextLine()) {
                String enemyData = scan.nextLine();
                String[] tokens = enemyData.split(",");
                ImageView imageView = new ImageView();
                anchorPane.getChildren().add(imageView);
                IEntity iEntity = new Enemy(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]),imageView,roomNum);
                tempEnemies.add(iEntity);
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
