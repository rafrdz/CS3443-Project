package application.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.animations.SpriteAnimation;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Model for the Player object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Player extends Entity implements IEntity {

	private String keyPressed = "";

	public Player(double x, double y, ImageView imageView) {
		this.currentX = x;
		this.currentY = y;
		imageView.setLayoutX(x);
		imageView.setLayoutY(y);
		this.hp = 10;
		this.moveSize = 10;

		this.spriteColumnsCount = 9;
		this.spriteFrameCount = 5;
		this.spriteHeight = 64;
		this.spriteWidth = 64;

		try {
			imageView.setImage(new Image(new FileInputStream("images/sprite/player.png")));
			imageView.setViewport(new Rectangle2D(0, 0, 64, 64));
			this.imageView = imageView;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void move() {
		boolean validMove = this.determineMove(this.keyPressed);
		if(validMove){
			updateImageView(this.keyPressed);
		}
	}
	
	@Override
	public void updateImageView(String direction) {
        switch(direction) {
        case "W":
        	this.spriteAnimationStartoffsetY = 0 * this.spriteHeight;
        	this.currentY -= this.moveSize;
            break;
        case "A":
        	this.spriteAnimationStartoffsetY = 1 * this.spriteHeight;
        	this.currentX -= this.moveSize;
            break;
        case "S":
        	this.spriteAnimationStartoffsetY = 2 * this.spriteHeight;
        	this.currentY += this.moveSize; 
            break;
        case "D":
        	this.spriteAnimationStartoffsetY = 3 * this.spriteHeight;
        	this.currentX += moveSize;
            break;
        }
        
        
    	this.animation = new SpriteAnimation(this.imageView, 
    			Duration.millis(500), 
    			this.spriteFrameCount, this.spriteColumnsCount, 
    			this.spriteAnimationStartOffsetX, this.spriteAnimationStartoffsetY,
    			this.spriteWidth, this.spriteHeight);
    	animation.play();
	
    	this.imageView.setLayoutX(this.currentX);
    	this.imageView.setLayoutY(this.currentY);
    	
        System.out.println("New X: " + this.currentX + " New Y: " + this.currentY);
    }

	public String getKeyPressed() {
		return keyPressed;
	}

	public void setKeyPressed(String keyPressed) {
		this.keyPressed = keyPressed;
	}

}
