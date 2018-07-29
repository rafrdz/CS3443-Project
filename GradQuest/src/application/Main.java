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
    
    public static Stage mainStage;
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        moveToNextView("../Main.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void moveToNextView(String fxmlString) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(fxmlString));
            AnchorPane layout = (AnchorPane) loader.load();
            Scene scene = new Scene(layout);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
