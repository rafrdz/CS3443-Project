package application.model;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public class Projectile extends Entity implements IEntity {

	boolean isPlayers = false;

	public Projectile(double hp, boolean isPlayers, double currentX, double currentY, Point2D velocity) {
		this.hp = hp;
		this.isPlayers = isPlayers;
		this.currentX = currentX;
		this.currentY = currentY;
		this.moveSize = 6;
		this.velocity = velocity;

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
		// TODO Auto-generated method stub

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
		Enemy enemy = (Enemy) entity2;
	
		boolean isCollision = false;
		double thisRightEdge = this.currentX + this.spriteWidth;
		double thisBottomEdge = this.currentY + this.spriteHeight;
		double thatRightEdge = enemy.currentX + this.spriteWidth;
		double thatBottomEdge = enemy.currentY + this.spriteHeight;
		
		if(thisBottomEdge <= enemy.getCurrentY() ||
				thisRightEdge >= enemy.getCurrentY() ||
				thatRightEdge >= this.currentX ||
				thatBottomEdge <= this.currentY){
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
