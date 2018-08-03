package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;

import application.model.Enemy;
import application.model.EnemyGroup;
import application.model.IEntity;
import application.model.Player;
import application.model.Projectile;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
        getUserInfo();
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
				if(frames % 30 == 0){
					fireProjectiles();
				}
				frames++;
			}
		}.start(); 
    }
    
    public void returnHome() {
        Main.moveToNextView("../application/views/Main.fxml");
    }

    
    
    protected void fireProjectiles() {
    	ArrayList<IEntity> newProjectiles = new ArrayList<IEntity>(); 
    	for(IEntity entity : entities){
    		IEntity newEnitity = entity.fireProjectile();
    		if(newEnitity != null){
    			ImageView imageView = new ImageView(Main.EXPLOSION);
    			imageView.setViewport(new Rectangle2D(256, 128, 64, 64));
    			newEnitity.setImageView(imageView);
    			imageView.setLayoutX(player.getCurrentX());
    			imageView.setLayoutY(player.getCurrentY());
    			bottomPane.getChildren().add(newEnitity.getImageView());
    			newProjectiles.add(newEnitity);
    		}
    	}
    	entities.addAll(newProjectiles);
	}


	protected void update() {
    	ArrayList<Integer> removedIndexes = new ArrayList<Integer>();
    	for(int i = 0; entities.size() > i; i++){
    		entities.get(i).move();
    		if(entities.get(i) instanceof Projectile && entities.get(i).needToRemove()){
    			System.out.println("Removing");
    			removedIndexes.add(i);
    		}
    	}
    	for(Integer integer : removedIndexes){
    		System.out.println(integer);
    		bottomPane.getChildren().remove(entities.get(integer).getImageView());
    		entities.remove(entities.get(integer));
    	}
    }

    public void handleKeyRelease(KeyEvent event){
    	player.setKeyPressed("");
    }
    
	public void handleKeyPressed(KeyEvent event) {
        String keyPressed = event.getCode().toString();
        player.setKeyPressed(keyPressed);
    }
    
    private void getUserInfo() {
        playerLabel.setText("Player: " + IntroController.currentUser.getName());
    }
    
    public void exitGame(Event event) {
        if(event instanceof KeyEvent){
        	KeyEvent keyEvent = (KeyEvent) event;
        	if(keyEvent.getCode() == KeyCode.ESCAPE){
        		Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
        	}
        } else if(event instanceof MouseEvent){
        	Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        }
    	
    }

}
