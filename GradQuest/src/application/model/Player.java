package application.model;

import java.util.ArrayList;

import application.Main;
import application.animations.SpriteAnimation;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import application.model.Enemy;

/**
 * Model for the Player object
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 *
 */
public class Player extends Entity implements IEntity {

    private String keyPressed = "";
    private String fireKeyPressed = "";
    private String directionFacing = "";
    private double projectileHp = 2;

    private ArrayList<String> movements = new ArrayList<String>();

    /**
     * Constructor for a player object
     * 
     * @param x
     *            - The starting x coordinate of the player
     * @param y
     *            - The starting y coordinate of the player
     * @param imageView
     *            - The imageview of the player
     * @param anchorPane
     *            - The pane that the player will be on
     */
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

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#move()
     */
    @Override
    public void move() {
        if (!movements.isEmpty()) {
            String temp = movements.get(movements.size() - 1);
            boolean validMove = this.determineMove(temp);
            if (validMove) {
                updateImageView(temp);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#updateImageView(java.lang.String)
     */
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
            if (this.animation != null) {
                this.animation.stop();
            }
            this.animation = new SpriteAnimation(this.imageView, Duration.millis(1000), this.spriteFrameCount,
                    this.spriteColumnsCount, this.spriteAnimationStartOffsetX, this.spriteAnimationStartoffsetY,
                    this.spriteWidth, this.spriteHeight);
            animation.play();
        }
        for (int i = 0; this.moveSize > i; i++) {
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
                this.imageView.setLayoutX(this.currentX += 1);
                break;
            }
        }
        System.out.println("New X: " + this.currentX + " New Y: " + this.currentY);
    }

    /**
     * @return - A string representation of the key that was pressed
     */
    public String getKeyPressed() {
        return keyPressed;
    }

    /**
     * @param keyPressed
     *            - The key that was pressed to be set
     */
    public void setKeyPressed(String keyPressed) {
        this.keyPressed = keyPressed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#fireProjectile()
     */
    @Override
    public IEntity fireProjectile() {
        IEntity temp = null;
        if (!this.fireKeyPressed.equals("")) {
            switch (this.fireKeyPressed) {
            case "UP":
                temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY, new Point2D(0, 1));
                break;
            case "LEFT":
                temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY, new Point2D(-1, 0));
                break;
            case "DOWN":
                temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY, new Point2D(0, -1));
                break;
            case "RIGHT":
                temp = new Projectile(this.projectileHp, true, this.currentX, this.currentY, new Point2D(1, 0));
                break;
            default:
                break;
            }
        }
        return temp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.Entity#setImageView(javafx.scene.image.ImageView)
     */
    @Override
    public void setImageView(ImageView imageView) {
        super.setImageView(imageView);
    };

    /**
     * @return - The direction that the player is facing
     */
    public String getDirectionFacing() {
        return directionFacing;
    }

    /**
     * @param directionFacing
     *            - The direction to be set
     */
    public void setDirectionFacing(String directionFacing) {
        this.directionFacing = directionFacing;
    }

    /**
     * @return - The HP of the projectile fired by the player
     */
    public double getProjectileHp() {
        return projectileHp;
    }

    /**
     * @param projectileHp
     *            - The HP of the projectile to be set
     */
    public void setProjectileHp(double projectileHp) {
        this.projectileHp = projectileHp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#needToRemove()
     */
    @Override
    public boolean needToRemove() {
        return false;
    }

    /**
     * @return - The direction that the projectile will be fired in
     */
    public String getFireKeyPressed() {
        return fireKeyPressed;
    }

    /**
     * @param fireKeyPressed
     *            - The direction of the projectile to be set
     */
    public void setFireKeyPressed(String fireKeyPressed) {
        this.fireKeyPressed = fireKeyPressed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#checkColision(application.model.IEntity)
     */
    @Override
    public boolean checkCollision(IEntity entity2) {
        Enemy e = (Enemy) entity2;

        boolean xOverlap = this.currentX + this.getSpriteWidth() - 40 > e.currentX
                && this.currentX + 40 < e.currentX + e.spriteWidth;
        boolean yOverlap = this.currentY + 40 < e.currentY + e.spriteHeight
                && this.currentY + this.getSpriteHeight() > e.currentY;
        if (yOverlap && xOverlap) {
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#checkForDeath(application.model.IEntity)
     */
    @Override
    public boolean checkForDeath(IEntity iEntity) {
        if (this.currentX == 40)
            System.out.println("ah");
        return false;
    }

    /**
     * @return - A list of movement directions
     */
    public ArrayList<String> getMovements() {
        return movements;
    }

    /**
     * @param movements
     *            - A list of movement directions to be set
     */
    public void setMovements(ArrayList<String> movements) {
        this.movements = movements;
    }

}
