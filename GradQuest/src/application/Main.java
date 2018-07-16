package application;

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
    
    public static Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Main.stage = primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../Main.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();
            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
