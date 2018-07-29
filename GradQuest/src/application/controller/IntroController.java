package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
        Main.moveToNextView("../Game.fxml");
    }

}
