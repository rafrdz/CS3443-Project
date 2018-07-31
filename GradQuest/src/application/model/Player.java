package application.model;

import application.animations.SpriteAnimation;
import javafx.scene.image.ImageView;

/**
 * Model for the Player object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Player {

    private double curX;
    private double curY;
    public static final int moveSize = 10;
    
    private ImageView imageView;
    private String keyPressed = "";
    
    
    SpriteAnimation animation;
    
     public Player(double x, double y) {
        this.curX = x;
        this.curY = y;
        
    }

    public boolean isLegalMove(double curX, double curY, String direction) {
        boolean ret = false;
        if ("up".equals(direction)) {
            if (curY - Player.moveSize > 0) {
                ret = true;
            }
        }
        if ("down".equals(direction)) {
            if (curY + Player.moveSize < 394 ) {
                ret = true;
            }
        }
        if ("left".equals(direction)) {
            if(curX - Player.moveSize > 0) {
                ret = true;
            }
        }
        if ("right".equals(direction)) {
            if (curX + Player.moveSize < 444) {
                ret = true;
            }
        }
        return ret;
    }

    public double getCurX() {
        return curX;
    }

    public void setCurX(double curX) {
        this.curX = curX;
    }

    public double getCurY() {
        return curY;
    }

    public void setCurY(double curY) {
        this.curY = curY;
    }

	public String getKeyPressed() {
		return keyPressed;
	}

	public void setKeyPressed(String keyPressed) {
		this.keyPressed = keyPressed;
	}

	/*public void setAnimation(ImageView playerImage) {
		
		this.imageView = playerImage;
		this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(playerImage, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
	}*/

}
