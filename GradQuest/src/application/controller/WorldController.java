package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public class WorldController implements EventHandler<ActionEvent>, Initializable{
    
    @FXML
    private Pane worldPane;
    
    @FXML
    private ImageView playerImage;
    
    @FXML
    private Label roomLabel, debtLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void handle(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }

}
