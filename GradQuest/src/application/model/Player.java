package application.model;

import application.Main;
import application.animations.SpriteAnimation;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
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
	private String fireKeyPressed = "";
	private String directionFacing = "";
	private double projectileHp = 2;

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

		imageView.setImage(Main.PLAYER_IMAGE);
		imageView.setViewport(new Rectangle2D(0, 0, 64, 64));
		this.imageView = imageView;
		
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
		this.directionFacing = direction;
		switch (direction) {
		case "W":
			this.spriteAnimationStartoffsetY = 0 * this.spriteHeight;
			break;
		case "A":
			this.spriteAnimationStartoffsetY = 1 * this.spriteHeight;
			break;
		case "S":
			this.spriteAnimationStartoffsetY = 2 * this.spriteHeight;
			break;
		case "D":
			this.spriteAnimationStartoffsetY = 3 * this.spriteHeight;
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
				break;
			case "A":
				this.imageView.setLayoutX(this.currentX -= 1);
				break;
			case "S":
				this.imageView.setLayoutY(this.currentY += 1);
				break;
			case "D":
				this.imageView.setLayoutX(this.currentX += 1 );
				break;
				
			}
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
		if(!this.fireKeyPressed.equals("")){
			switch (this.fireKeyPressed) {
			case "UP":
				temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY,new Point2D(0, 1));
				break;
			case "LEFT":
				temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY,new Point2D(-1, 0));
				break;
			case "DOWN":
				temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY,new Point2D(0, -1));
				break;
			case "RIGHT":
				temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY,new Point2D(1, 0));
				break;
				default:
					break;
			}
		}
		return temp;
	}

	@Override
	public void setImageView(ImageView imageView) {
		super.setImageView(imageView);
	};
	
	public String getDirectionFacing() {
		return directionFacing;
	}

	public void setDirectionFacing(String directionFacing) {
		this.directionFacing = directionFacing;
	}

	public double getProjectileHp() {
		return projectileHp;
	}

	public void setProjectileHp(double projectileHp) {
		this.projectileHp = projectileHp;
	}

	@Override
	public boolean needToRemove() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getFireKeyPressed() {
		return fireKeyPressed;
	}

	public void setFireKeyPressed(String fireKeyPressed) {
		this.fireKeyPressed = fireKeyPressed;
	}

	@Override
	public boolean checkColision(IEntity entity2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForDeath(IEntity iEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
	
}
