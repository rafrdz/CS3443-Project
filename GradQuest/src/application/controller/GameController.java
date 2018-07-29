package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public class GameController implements Initializable{
    
    @FXML
    AnchorPane mainPane;
    
    @FXML
    SplitPane splitPane;
    
    @FXML
    GridPane gridPane;
    
    @FXML
    Label roomLabel, playerLabel, debtValue, debtLabel;
    
    @FXML
    ImageView playerImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: Load the room based on room number and difficulty
        
        // TODO: Start the debt clock
    }
    
    public static void catchKey(KeyCode key) {
        System.out.println(key.toString() + " has been pressed");
    }

}
