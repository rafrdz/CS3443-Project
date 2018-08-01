package application.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.Enemy;
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
    Button homeButton, exitButton;
    
    /*@FXML
    ImageView playerImage, enemy1Image;*/
    
    public Player player;
    
    public ArrayList<IEntity> entities = new ArrayList<IEntity>();
    
    public EnemyGroup enemies;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        /*enities.add(player);
        enemies = new EnemyGroup();*/
        getUserInfo();
        //initializeEnemies(enemies.loadEnemies(IntroController.difficulty, 1));
        //playerImage.setFocusTraversable(true);
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
				if(frames == 0){
					ImageView playerImage = new ImageView();
			        player = new Player(0, bottomPane.getHeight() - 64, playerImage,bottomPane);
			        entities.add(player);
			        
			    	bottomPane.getChildren().add(playerImage);
				}
				
				if(frames % 2 == 0){
					update();
				}
				//update();
				frames++;
			}
		}.start(); 
    }
    
    public void returnHome() {
        Main.moveToNextView("../application/views/Main.fxml");
    }
    
    
    protected void update() {
    	for(IEntity entity : entities){
    		entity.move();
    	}
    	ArrayList<IEntity> newProjectiles = new ArrayList<IEntity>(); 
    	for(IEntity entity : entities){
    		IEntity newEnitity = entity.fireProjectile();
    		if(newEnitity != null){
    			newProjectiles.add(newEnitity);
    		}
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
        player.setKeyPressed("");
        player.setKeyPressed(keyPressed);
    }
    
    private void getUserInfo() {
        playerLabel.setText("Player: " + IntroController.currentUser.getName());
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
