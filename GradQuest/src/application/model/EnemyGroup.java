package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Model for the EnemyGroup objects which holds a collection of Enemies
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 *
 */
public class EnemyGroup {

    private ArrayList<Enemy> enemies;

    /**
     * Constructor for the EnemyGroup object
     */
    public EnemyGroup() {
        this.enemies = new ArrayList<Enemy>();
    }

    /**
     * Loads the enemies (entities) from the appropriate csv file
     * 
     * @param difficulty
     *            - The difficulty that the user selected
     * @param roomNum
     *            - The room number to be loaded
     * @param anchorPane
     *            - The pane that the enemies will be displayed on
     * @return - A list of entities to place on the view
     */
    public static ArrayList<IEntity> loadEnemies(String difficulty, int roomNum, AnchorPane anchorPane) {
        Scanner scan = null;
        String fileName = "./rooms/" + difficulty.toLowerCase() + "/" + "room" + roomNum + ".csv";
        ArrayList<IEntity> tempEnemies = new ArrayList<IEntity>();
        try {
            scan = new Scanner(new File(fileName));

            while (scan.hasNextLine()) {
                String enemyData = scan.nextLine();
                String[] tokens = enemyData.split(",");
                ImageView imageView = new ImageView();
                anchorPane.getChildren().add(imageView);
                IEntity iEntity = new Enemy(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]), imageView,
                        roomNum, anchorPane);
                tempEnemies.add(iEntity);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return tempEnemies;
    }

    /**
     * @return - A list of enemies
     */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * @param enemies
     *            - A list of enemies to be set
     */
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

}
