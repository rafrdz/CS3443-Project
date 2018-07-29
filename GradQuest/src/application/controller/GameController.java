package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.constants.PlayerAnimationConstants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * @author Rafael Rodriguez - mat574
 * @author David Brenner
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
    ImageView playerImage,
    down0,down1,down2,
    up0,up1,up2,
    right0,right1,right2,
    left0,left1,left2;

    public static void catchKey(KeyCode key) {
        System.out.println(key.toString() + " has been pressed");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gridPane.getStyleClass().add("gridLines");
        down0.setImage(new Image(PlayerAnimationConstants.PLAYER_DOWN0));
        down1.setImage(new Image(PlayerAnimationConstants.PLAYER_DOWN1));
        down2.setImage(new Image(PlayerAnimationConstants.PLAYER_DOWN2));
        
        up0.setImage(new Image(PlayerAnimationConstants.PLAYER_UP0));
        up1.setImage(new Image(PlayerAnimationConstants.PLAYER_UP1));
        up2.setImage(new Image(PlayerAnimationConstants.PLAYER_UP2));
        
        right0.setImage(new Image(PlayerAnimationConstants.PLAYER_RIGHT0));
        right1.setImage(new Image(PlayerAnimationConstants.PLAYER_RIGHT1));
        right2.setImage(new Image(PlayerAnimationConstants.PLAYER_RIGHT2));
        
        left0.setImage(new Image(PlayerAnimationConstants.PLAYER_LEFT0));
        left1.setImage(new Image(PlayerAnimationConstants.PLAYER_LEFT1));
        left2.setImage(new Image(PlayerAnimationConstants.PLAYER_LEFT2));
        
    }

}
