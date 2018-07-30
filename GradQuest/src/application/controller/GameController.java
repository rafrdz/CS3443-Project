package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.constants.PlayerAnimationConstants;
import application.model.Room;
import application.model.RoomView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * Class that handles displaying all of the game information and acting on user input
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 */

public class GameController implements EventHandler<KeyEvent>, Initializable{
    
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
    
    public static Room room;
    
    public static RoomView roomView;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getUserInfo();
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
    
    @Override
    public void handle(KeyEvent event) {
        String keyPressed = event.getCode().toString();
        System.out.println(keyPressed);
    }
    
    public void moveToRoom2(String difficulty) {
        // TODO: Allow user to move to room 2
        room = Room.loadRoomData(difficulty, 2);
        roomView = new RoomView(room);
    }
    
    public void moveToRoom3(String difficulty) {
        // TODO: Allow user to move to room 3
        room = Room.loadRoomData(difficulty, 2);
        roomView = new RoomView(room);
    }
    
    private void getUserInfo() {
        playerLabel.setText(IntroController.currentUser.getName());
    }

}