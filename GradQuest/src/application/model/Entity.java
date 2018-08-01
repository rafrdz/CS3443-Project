package application.model;

import application.animations.SpriteAnimation;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public abstract class Entity {

	double currentX;
	double currentY;
	double hp;
	double moveSize;
	Point2D velocity;
	
	int spriteFrameCount;
    int spriteColumnsCount;
    int spriteAnimationStartOffsetX;
    int spriteAnimationStartoffsetY;
    int spriteHeight;
    int spriteWidth;
    
    SpriteAnimation animation;
    ImageView imageView;
    AnchorPane backgroundPane;
    
    public boolean isLegalMove(double curX, double curY, String direction) {
        boolean ret = false;
        if ("up".equals(direction)) {
            if (this.currentY - this.moveSize > 0) {
                ret = true;
            }
        }
        if ("down".equals(direction)) {
            if (this.currentY + this.moveSize < this.backgroundPane.getHeight() - this.spriteHeight ) {
                ret = true;
            }
        }
        if ("left".equals(direction)) {
            if(this.currentX - this.moveSize > 0) {
                ret = true;
            }
        }
        if ("right".equals(direction)) {
            if (this.currentX + this.moveSize < this.backgroundPane.getWidth() - this.spriteWidth) {
                ret = true;
            }
        }
        return ret;
    }
    
    public boolean determineMove(String direction){
    	boolean validMove = false;
    	switch(direction) {
        case "W":
            if(this.isLegalMove(currentX, currentY, "up")) {
            	validMove = true;
            }
            break;
        case "A":
            if(this.isLegalMove(currentX, currentY, "left")) {
            	validMove = true;
        	}
            break;
        case "S":
            if(this.isLegalMove(currentX, currentY, "down")) {
            	validMove = true;
        	}
            break;
        case "D":
            if(this.isLegalMove(currentX, currentY, "right")) {
            	validMove = true;
            }
            break;
        }
    	return validMove;
    }
    

    
	public Point2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Point2D velocity) {
		this.velocity = velocity;
	}

	public SpriteAnimation getAnimation() {
		return animation;
	}

	public void setAnimation(SpriteAnimation animation) {
		this.animation = animation;
	}

	public double getMoveSize() {
		return moveSize;
	}

	public void setMoveSize(double moveSize) {
		this.moveSize = moveSize;
	}

	public void setCurrentX(double currentX) {
		this.currentX = currentX;
	}

	public void setCurrentY(double currentY) {
		this.currentY = currentY;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getCurrentX() {
		return currentX;
	}

	public double getCurrentY() {
		return currentY;
	}

	public double getHp() {
		return hp;
	}

	public int getSpriteFrameCount() {
		return spriteFrameCount;
	}

	public void setSpriteFrameCount(int spriteFrameCount) {
		this.spriteFrameCount = spriteFrameCount;
	}

	public int getSpriteColumnsCount() {
		return spriteColumnsCount;
	}

	public void setSpriteColumnsCount(int spriteColumnsCount) {
		this.spriteColumnsCount = spriteColumnsCount;
	}

	public int getSpriteAnimationStartOffsetX() {
		return spriteAnimationStartOffsetX;
	}

	public void setSpriteAnimationStartOffsetX(int spriteAnimationStartOffsetX) {
		this.spriteAnimationStartOffsetX = spriteAnimationStartOffsetX;
	}

	public int getSpriteAnimationStartoffsetY() {
		return spriteAnimationStartoffsetY;
	}

	public void setSpriteAnimationStartoffsetY(int spriteAnimationStartoffsetY) {
		this.spriteAnimationStartoffsetY = spriteAnimationStartoffsetY;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public AnchorPane getBackgroundPane() {
		return backgroundPane;
	}

	public void setBackgroundPane(AnchorPane backgroundPane) {
		this.backgroundPane = backgroundPane;
	}
}
