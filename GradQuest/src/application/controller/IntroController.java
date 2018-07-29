package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public class IntroController implements EventHandler<ActionEvent>, Initializable {

    
    @FXML
    private Pane introPane;
    
    @FXML
    private TextArea descriptionTextArea;
    
    @FXML
    private Button homeButton, exitButton, startButton;

    @FXML
    private Label descriptionLabel, controlsLabel, wText, aText, sText, dText, spaceText, wLabel, aLabel, sLabel, dLabel, spaceLabel;

    @FXML
    private Rectangle wShape, sShape, dShape, aShape, spaceShape;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        descriptionTextArea.setEditable(false);
    }
    
    @Override
    public void handle(ActionEvent event) {
        Main.moveToNextView("../Main.fxml");
    }
    
    public void exitGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    public void startGame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../Game.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();
            Scene scene = new Scene(layout);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {
                    KeyCode keyCode = event.getCode();
                    GameController.catchKey(keyCode);
                }
            });
            Main.mainStage.setScene(scene);
            Main.mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
