package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GameController implements EventHandler<KeyEvent>, Initializable{
    
    @FXML
    SplitPane splitPane;
    
    @FXML
    AnchorPane topPane, bottomPane;
    
    @FXML
    GridPane gridPane;
    
    @FXML
    Label roomLabel, playerLabel, debtValue, debtLabel;
    
    @FXML
    ImageView playerImage;

    @Override
    public void handle(KeyEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gridPane.getStyleClass().add("gridLines");
    }

}
