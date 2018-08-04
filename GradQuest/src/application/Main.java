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
 *
 */
public class Main extends Application {
    
    public static Image PLAYER_IMAGE = null;
    public static Image EXPLOSION = null;
    public static Image ENEMY_ROOM_1 = null;
    public static Stage mainStage;
    public static ExecutorService app;
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        try {
			PLAYER_IMAGE = new Image(new FileInputStream("images/sprite/player.png"));
			EXPLOSION = new Image(new FileInputStream("images/sprite/explosion01_64.png"));
			ENEMY_ROOM_1 = new Image(new FileInputStream("images/alarmClock.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        moveToNextView("../application/views/Main.fxml");
    }

    public static void main(String[] args) {
        //app = Executors.newCachedThreadPool();
        launch(args);
    }
    
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
