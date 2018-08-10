package application.model;

import application.animations.SpriteAnimation;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Abstract class non static object on the viewing port
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
     * Determines whether or not a move being made by an entity is legal (will not
     * exit the pane)
     * 
     * @param curX
     *            - The current x coordinate of the entity
     * @param curY
     *            - The current y coordinate of the entity
     * @param direction
     *            - The direction that the entity plans on moving
     * @return - Whether or not the move is valid
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
     * Determines if a proposed move direction is valid
     * 
     * @param direction
     *            - The direction to be moved
     * @return - Whether a proposed move is valid
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
     * @return - The velocity of the entity
     */
    public Point2D getVelocity() {
        return velocity;
    }

    /**
     * @param velocity
     *            - A velocity to be set
     */
    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    /**
     * @return - A SpriteAnimation object
     */
    public SpriteAnimation getAnimation() {
        return animation;
    }

    /**
     * @param animation
     *            - The SpriteAnimation object to be set
     */
    public void setAnimation(SpriteAnimation animation) {
        this.animation = animation;
    }

    /**
     * @return - The move size of the entity
     */
    public double getMoveSize() {
        return moveSize;
    }

    /**
     * @param moveSize
     *            - The move size to be set
     */
    public void setMoveSize(double moveSize) {
        this.moveSize = moveSize;
    }

    /**
     * @param currentX
     *            - The current x coordinate to be set
     */
    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    /**
     * @param currentY
     *            - The current y coordinate to be set
     */
    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    /**
     * @param hp
     *            - The HP of the entity to be set
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * @return - The current x coordinate of the entity
     */
    public double getCurrentX() {
        return currentX;
    }

    /**
     * @return - The current y coordinate of the entity
     */
    public double getCurrentY() {
        return currentY;
    }

    /**
     * @return - The HP of the entity
     */
    public double getHp() {
        return hp;
    }

    /**
     * @return - The frame count of the sprite
     */
    public int getSpriteFrameCount() {
        return spriteFrameCount;
    }

    /**
     * @param spriteFrameCount
     *            - The frame count to be set
     */
    public void setSpriteFrameCount(int spriteFrameCount) {
        this.spriteFrameCount = spriteFrameCount;
    }

    /**
     * @return - The number of columns in the sprite sheet
     */
    public int getSpriteColumnsCount() {
        return spriteColumnsCount;
    }

    /**
     * @param spriteColumnsCount
     *            - The number of columns in the sprite sheet to be set
     */
    public void setSpriteColumnsCount(int spriteColumnsCount) {
        this.spriteColumnsCount = spriteColumnsCount;
    }

    /**
     * @return - The offset starting x position
     */
    public int getSpriteAnimationStartOffsetX() {
        return spriteAnimationStartOffsetX;
    }

    /**
     * @param spriteAnimationStartOffsetX
     *            - The offset starting x position to be set
     */
    public void setSpriteAnimationStartOffsetX(int spriteAnimationStartOffsetX) {
        this.spriteAnimationStartOffsetX = spriteAnimationStartOffsetX;
    }

    /**
     * @return - The offset starting y position
     */
    public int getSpriteAnimationStartoffsetY() {
        return spriteAnimationStartoffsetY;
    }

    /**
     * @param spriteAnimationStartoffsetY
     *            - The offset starting y position to be set
     */
    public void setSpriteAnimationStartoffsetY(int spriteAnimationStartoffsetY) {
        this.spriteAnimationStartoffsetY = spriteAnimationStartoffsetY;
    }

    /**
     * @return - The height of the sprite
     */
    public int getSpriteHeight() {
        return spriteHeight;
    }

    /**
     * @param spriteHeight
     *            - The height of the sprite to be set
     */
    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    /**
     * @return - The width of the sprite
     */
    public int getSpriteWidth() {
        return spriteWidth;
    }

    /**
     * @param spriteWidth
     *            - The width of the sprite to be set
     */
    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    /**
     * @return - The imageview of the entity
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * @param imageView
     *            - The imageview of the entity to be set
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * @return - The background pane that the entity is on
     */
    public AnchorPane getBackgroundPane() {
        return backgroundPane;
    }

    /**
     * @param backgroundPane
     *            - The background pane to be set
     */
    public void setBackgroundPane(AnchorPane backgroundPane) {
        this.backgroundPane = backgroundPane;
    }
}
