package application.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.EnemyGroup;
import application.model.IEntity;
import application.model.Player;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Displays the first room to the user and handles user inputs via keyboard
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 *
 */
public class Room1Controller implements Initializable{
    
    @FXML
    AnchorPane mainPane, topPane, bottomPane;
    
    @FXML
    SplitPane splitPane;
    
    @FXML
    Label roomLabel, playerLabel, debtValue, debtLabel;
    
    @FXML
    Button exitButton;
    
    /*@FXML
    ImageView playerImage, enemy1Image;*/
    
    public Player player;
    
    public ArrayList<IEntity> enities = new ArrayList<IEntity>();
    
    public EnemyGroup enemies;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ImageView playerImage = new ImageView();
        player = new Player(0, 394, playerImage);
        enities.add(player);
    	/*Enemy enemy = new Enemy(0, 0);
    	ImageView e = new ImageView();*/
    	mainPane.getChildren().add(playerImage);
        /*enities.add(player);
        enemies = new EnemyGroup();*/
        getUserInfo();
        //initializeEnemies(enemies.loadEnemies(IntroController.difficulty, 1));
        playerImage.setFocusTraversable(true);
        /*try {
			playerImage.setImage(new Image(new FileInputStream("images/sprite/player.png")));
			playerImage.setViewport(new Rectangle2D(0, 0, 64,64));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        new AnimationTimer() {
			int frames = 0;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(frames % 12 == 0){
					update();
				}
				frames++;
			}
		}.start(); 
    }
    
    
    protected void update() {
    	for(IEntity entity : enities){
    		entity.move();
    	}
    }

    public void handleKeyRelease(KeyEvent event){
    	//String keyPressed = event.getCode().toString();
        //System.out.println(keyPressed);
        player.setKeyPressed("");
    }
    
	public void handleKeyPressed(KeyEvent event) {
        String keyPressed = event.getCode().toString();
        //System.out.println(keyPressed);
        player.setKeyPressed(keyPressed);
    }
    
    /*private void updateImageView(double newX, double newY, String keyPressed) {
        
    	int count = 9;
        int columns = 9;
        int offsetX = 0;
        int offsetY = 0;
        int height = 64;
        int width = 64;
        switch(keyPressed) {
        case "W":
            break;
        case "A":
            offsetY = 64;
            break;
        case "S":
            offsetY = 128;
            break;
        case "D":
            offsetY = 196;
            break;
        }
        
        
    	SpriteAnimation animation = new SpriteAnimation(playerImage, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
    	animation.play();
    	playerImage.setLayoutX(newX);
        playerImage.setLayoutY(newY);
        player.setCurX(newX);
        player.setCurY(newY);
        System.out.println("New X: " + newX + " New Y: " + newY);
    }*/
    
    private void getUserInfo() {
        playerLabel.setText(IntroController.currentUser.getName());
    }
    
    /*private void initializeEnemies(ArrayList<Enemy> enemies) {
        for(Enemy e : enemies) {
            enemy1Image.setLayoutX(e.getCurX());
            enemy1Image.setLayoutY(e.getCurY());
        }
    }*/
    
    public void exitGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
