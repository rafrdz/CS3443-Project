package application.model;

import application.animations.SpriteAnimation;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * @author David Brenner - iqc287
 * @author Rafael Rodriguez - mat574
 *
 */
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

    /**
     * @param curX
     * @param curY
     * @param direction
     * @return
     */
    public boolean isLegalMove(double curX, double curY, String direction) {
        boolean ret = false;
        if ("up".equals(direction)) {
            if (this.currentY - this.moveSize > 0) {
                ret = true;
            }
        }
        if ("down".equals(direction)) {
            if (this.currentY + this.moveSize < this.backgroundPane.getHeight() - this.spriteHeight) {
                ret = true;
            }
        }
        if ("left".equals(direction)) {
            if (this.currentX - this.moveSize > 0) {
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

    /**
     * @param direction
     * @return
     */
    public boolean determineMove(String direction) {
        boolean validMove = false;
        switch (direction) {
        case "W":
            if (this.isLegalMove(currentX, currentY, "up")) {
                validMove = true;
            }
            break;
        case "A":
            if (this.isLegalMove(currentX, currentY, "left")) {
                validMove = true;
            }
            break;
        case "S":
            if (this.isLegalMove(currentX, currentY, "down")) {
                validMove = true;
            }
            break;
        case "D":
            if (this.isLegalMove(currentX, currentY, "right")) {
                validMove = true;
            }
            break;
        }
        return validMove;
    }

    /**
     * @return
     */
    public Point2D getVelocity() {
        return velocity;
    }

    /**
     * @param velocity
     */
    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    /**
     * @return
     */
    public SpriteAnimation getAnimation() {
        return animation;
    }

    /**
     * @param animation
     */
    public void setAnimation(SpriteAnimation animation) {
        this.animation = animation;
    }

    /**
     * @return
     */
    public double getMoveSize() {
        return moveSize;
    }

    /**
     * @param moveSize
     */
    public void setMoveSize(double moveSize) {
        this.moveSize = moveSize;
    }

    /**
     * @param currentX
     */
    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    /**
     * @param currentY
     */
    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    /**
     * @param hp
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * @return
     */
    public double getCurrentX() {
        return currentX;
    }

    /**
     * @return
     */
    public double getCurrentY() {
        return currentY;
    }

    /**
     * @return
     */
    public double getHp() {
        return hp;
    }

    /**
     * @return
     */
    public int getSpriteFrameCount() {
        return spriteFrameCount;
    }

    /**
     * @param spriteFrameCount
     */
    public void setSpriteFrameCount(int spriteFrameCount) {
        this.spriteFrameCount = spriteFrameCount;
    }

    /**
     * @return
     */
    public int getSpriteColumnsCount() {
        return spriteColumnsCount;
    }

    /**
     * @param spriteColumnsCount
     */
    public void setSpriteColumnsCount(int spriteColumnsCount) {
        this.spriteColumnsCount = spriteColumnsCount;
    }

    /**
     * @return
     */
    public int getSpriteAnimationStartOffsetX() {
        return spriteAnimationStartOffsetX;
    }

    /**
     * @param spriteAnimationStartOffsetX
     */
    public void setSpriteAnimationStartOffsetX(int spriteAnimationStartOffsetX) {
        this.spriteAnimationStartOffsetX = spriteAnimationStartOffsetX;
    }

    /**
     * @return
     */
    public int getSpriteAnimationStartoffsetY() {
        return spriteAnimationStartoffsetY;
    }

    /**
     * @param spriteAnimationStartoffsetY
     */
    public void setSpriteAnimationStartoffsetY(int spriteAnimationStartoffsetY) {
        this.spriteAnimationStartoffsetY = spriteAnimationStartoffsetY;
    }

    /**
     * @return
     */
    public int getSpriteHeight() {
        return spriteHeight;
    }

    /**
     * @param spriteHeight
     */
    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    /**
     * @return
     */
    public int getSpriteWidth() {
        return spriteWidth;
    }

    /**
     * @param spriteWidth
     */
    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    /**
     * @return
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * @param imageView
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * @return
     */
    public AnchorPane getBackgroundPane() {
        return backgroundPane;
    }

    /**
     * @param backgroundPane
     */
    public void setBackgroundPane(AnchorPane backgroundPane) {
        this.backgroundPane = backgroundPane;
    }
}
