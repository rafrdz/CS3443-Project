package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Room1Controller implements EventHandler<KeyEvent>, Initializable{
    
    @FXML
    Label roomLabel, playerLabel, debtValue, debtLabel;
    
    @FXML
    Button exitButton;
    
    @FXML
    ImageView playerImage;
    
    @FXML
    Circle playerCircle;
    
    public static Player player;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getUserInfo();
        double curX = playerCircle.getCenterX();
        double curY = playerCircle.getCenterY();
        player = new Player(curX, curY);
    }
    
    @Override
    public void handle(KeyEvent event) {
        String keyPressed = event.getCode().toString();
        System.out.println(keyPressed);
        switch(keyPressed) {
        case "D":
            if(player.isLegalMove(player.getCurX(), player.getCurY(), "right")) {
                playerCircle.setLayoutX(player.getCurX() + Player.moveSize);
            }
            
        }
    }
    
    private void getUserInfo() {
        playerLabel.setText(IntroController.currentUser.getName());
    }
    
    public void exitGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
