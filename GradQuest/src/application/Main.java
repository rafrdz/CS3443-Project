package application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public class Main extends Application {
    
    public static Stage mainStage;
    public static ExecutorService app;
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
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
