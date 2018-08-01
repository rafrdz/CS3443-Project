package application.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.animations.SpriteAnimation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * Model for the Player object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Player extends Entity implements IEntity {

	private String keyPressed = "";

	public Player(double x, double y, ImageView imageView, AnchorPane anchorPane) {
		this.currentX = x;
		this.currentY = y;
		imageView.setLayoutX(x);
		imageView.setLayoutY(y);
		this.hp = 10;
		this.moveSize = 4;

		this.spriteColumnsCount = 9;
		this.spriteFrameCount = 9;
		this.spriteHeight = 64;
		this.spriteWidth = 64;

		this.backgroundPane = anchorPane;

		try {
			imageView.setImage(new Image(new FileInputStream("images/sprite/player.png")));
			imageView.setViewport(new Rectangle2D(0, 0, 64, 64));
			this.imageView = imageView;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void move() {
		boolean validMove = this.determineMove(this.keyPressed);
		if (validMove) {
			updateImageView(this.keyPressed);
		}
	}

	@Override
	public void updateImageView(String direction) {
		double currentSpriteOffset = this.spriteAnimationStartoffsetY;
		switch (direction) {
		case "W":
			this.spriteAnimationStartoffsetY = 0 * this.spriteHeight;
			//this.currentY -= this.moveSize;
			break;
		case "A":
			this.spriteAnimationStartoffsetY = 1 * this.spriteHeight;
			//this.currentX -= this.moveSize;
			break;
		case "S":
			this.spriteAnimationStartoffsetY = 2 * this.spriteHeight;
			//this.currentY += this.moveSize;
			break;
		case "D":
			this.spriteAnimationStartoffsetY = 3 * this.spriteHeight;
			//this.currentX += moveSize;
			break;
		}

		if (this.animation == null || this.animation.getCurrentRate() == 0.0
				|| this.spriteAnimationStartoffsetY != currentSpriteOffset) {
			if(this.animation != null){
				this.animation.stop();
			}
			this.animation = new SpriteAnimation(this.imageView, Duration.millis(1000), this.spriteFrameCount,
					this.spriteColumnsCount, this.spriteAnimationStartOffsetX, this.spriteAnimationStartoffsetY,
					this.spriteWidth, this.spriteHeight);
			animation.play();
		}
		
		for(int i = 0; this.moveSize > i; i++){
			switch (direction) {
			case "W":
				this.imageView.setLayoutY(this.currentY -= 1);
				//this.currentY -= this.moveSize;
				break;
			case "A":
				this.imageView.setLayoutX(this.currentX -= 1);
				//this.currentX -= this.moveSize;
				break;
			case "S":
				this.imageView.setLayoutY(this.currentY += 1);
				//this.currentY += this.moveSize;
				break;
			case "D":
				this.imageView.setLayoutX(this.currentX += 1 );
				//this.currentX += moveSize;
				break;
				
			}
			/*try {
				wait(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/*this.imageView.setLayoutX(this.currentX);
			this.imageView.setLayoutY(this.currentY);*/
		}	

		System.out.println("New X: " + this.currentX + " New Y: " + this.currentY);
	}

	public String getKeyPressed() {
		return keyPressed;
	}

	public void setKeyPressed(String keyPressed) {
		this.keyPressed = keyPressed;
	}

	@Override
	public IEntity fireProjectile() {
		IEntity temp = null;
		if(this.keyPressed == KeyCode.SPACE.getName()){
			
		}
		return temp;
	}

}
