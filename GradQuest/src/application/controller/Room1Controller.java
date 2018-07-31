package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Enemy;
import application.model.EnemyGroup;
import application.model.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Displays the first room to the user and handles user inputs via keyboard
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Room1Controller implements EventHandler<KeyEvent>, Initializable{
    
    @FXML
    AnchorPane mainPane, topPane, bottomPane;
    
    @FXML
    SplitPane splitPane;
    
    @FXML
    Label roomLabel, playerLabel, debtValue, debtLabel;
    
    @FXML
    Button exitButton;
    
    @FXML
    ImageView playerImage, enemy1Image;
    
    public Player player;
    
    public EnemyGroup enemies;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enemies = new EnemyGroup();
        getUserInfo();
        initializePlayer();
        initializeEnemies(enemies.loadEnemies(IntroController.difficulty, 1));
        playerImage.setFocusTraversable(true);
    }
    
    @Override
    public void handle(KeyEvent event) {

    }
    
    public void handleKeyPressed(KeyEvent event) {
        String keyPressed = event.getCode().toString();
        System.out.println(keyPressed);
        double curX = player.getCurX();
        double curY = player.getCurY();
        switch(keyPressed) {
        case "W":
            if(player.isLegalMove(curX, curY, "up")) {
                updateImageView(curX, curY - Player.moveSize);
            }
            break;
        case "A":
            if(player.isLegalMove(curX, curY, "left")) {
                updateImageView(curX - Player.moveSize, curY);
            }
            break;
        case "S":
            if(player.isLegalMove(curX, curY, "down")) {
                updateImageView(curX, curY + Player.moveSize);
            }
            break;
        case "D":
            if(player.isLegalMove(curX, curY, "right")) {
                updateImageView(curX + Player.moveSize, curY);
            }
            break;
        }
    }
    
    private void updateImageView(double newX, double newY) {
        playerImage.setLayoutX(newX);
        playerImage.setLayoutY(newY);
        player.setCurX(newX);
        player.setCurY(newY);
        System.out.println("New X: " + newX + " New Y: " + newY);
    }
    
    private void getUserInfo() {
        playerLabel.setText(IntroController.currentUser.getName());
    }
    
    private void initializePlayer() {
        double curX = playerImage.getLayoutX();
        double curY = playerImage.getLayoutY();
        player = new Player(curX, curY);
    }
    
    private void initializeEnemies(ArrayList<Enemy> enemies) {
        for(Enemy e : enemies) {
            enemy1Image.setLayoutX(e.getCurX());
            enemy1Image.setLayoutY(e.getCurY());
        }
    }
    
    public void exitGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
