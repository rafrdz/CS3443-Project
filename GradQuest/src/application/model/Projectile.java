package application.model;

import application.animations.SpriteAnimation;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Projectile extends Entity implements IEntity {

	boolean isPlayers = false;

	public Projectile(double hp, boolean isPlayers, double currentX, double currentY, Point2D velocity) {
		this.hp = hp;
		this.isPlayers = isPlayers;
		this.currentX = currentX;
		this.currentY = currentY;
		this.moveSize = 6;
		this.velocity = velocity;
		this.spriteHeight = 64;
		this.spriteWidth = 64;

	}

	@Override
	public void move() {
		for(int i = 0; this.moveSize > i;i++){
			if(this.velocity.getX() > 0){
				this.imageView.setLayoutX(this.currentX += 1);
			} else if(this.velocity.getX() < 0){
				this.imageView.setLayoutX(this.currentX -= 1);
			} else if(this.velocity.getY() > 0){
				this.imageView.setLayoutY(this.currentY -= 1);
			} else if(this.velocity.getY() < 0){
				this.imageView.setLayoutY(this.currentY += 1);	
			}
		}		
	}

	@Override
	public void updateImageView(String direction) {
			this.animation = new SpriteAnimation(this.imageView, Duration.millis(50),50,
					10, this.spriteAnimationStartOffsetX, this.spriteAnimationStartoffsetY,
					this.spriteWidth, this.spriteHeight);
			animation.play();
	}

	@Override
	public IEntity fireProjectile() {
		IEntity temp = null;

		return temp;

	}

	@Override
	public ImageView getImageView() {
		return super.getImageView();
	}

	@Override
	public boolean needToRemove() {
		if (this.currentX < 0 || this.currentX > 500 || currentY < 0 || currentY > 500) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkColision(IEntity entity2) {
		Enemy that = (Enemy) entity2;
	
		boolean isCollision = false;
		
		if(this.currentX < that.currentX + that.spriteWidth &&
				this.currentX + this.spriteWidth - 15 > that.currentX &&
				this.currentY < that.currentY + that.spriteHeight &&
				this.spriteHeight -15 + this.currentY > that.currentY){
			isCollision = true;
		}
		return isCollision;
	}

	@Override
	public boolean checkForDeath(IEntity iEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
