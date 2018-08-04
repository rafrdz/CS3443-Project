package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 *
 */
public class Main extends Application {

    public static Image PLAYER_IMAGE = null;
    public static Image EXPLOSION = null;
    public static Image ENEMY_ROOM_1 = null;
    public static Image ENEMY_ROOM_2 = null;
    public static Image ENEMY_ROOM_3 = null;
    public static Stage mainStage;

    /*
     * (non-Javadoc)
     * 
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        try {
            PLAYER_IMAGE = new Image(new FileInputStream("images/sprite/player.png"));
            EXPLOSION = new Image(new FileInputStream("images/sprite/explosion01_64.png"));
            ENEMY_ROOM_1 = new Image(new FileInputStream("images/alarmClock.png"));
            ENEMY_ROOM_2 = new Image(new FileInputStream("images/fGrade.png"));
            ENEMY_ROOM_3 = new Image(new FileInputStream("images/debt.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        moveToNextView("../application/views/Main.fxml");
    }

    /**
     * Main method of the application
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Moves the user to the next view
     * 
     * @param fxmlString
     *            - The location of the next view that the user will move to
     */
    public static void moveToNextView(String fxmlString) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(fxmlString));
            AnchorPane layout = (AnchorPane) loader.load();
            Scene scene = new Scene(layout);
            Main.mainStage.setTitle("Grad Quest");
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
