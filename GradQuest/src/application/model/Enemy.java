package application.model;

import java.util.Random;

import application.Main;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Model for the Enemy object
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 *
 */
public class Enemy extends Entity implements IEntity {

    /** Constructor
     * @param x
     * @param y
     * @param imageView
     * @param roomNum
     */
    public Enemy(double x, double y, ImageView imageView, int roomNum, AnchorPane anchorPane) {
        this.currentX = x;
        this.currentY = y;
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        this.backgroundPane = anchorPane;
        try {
            switch (roomNum) {
            case 1:
                this.hp = 5;
                this.moveSize = 5;
                imageView.setImage(Main.ENEMY_ROOM_1);
                this.spriteWidth = 50;
                this.spriteHeight = 50;
                break;
            case 2:
                this.hp = 7;
                this.moveSize = 5;
                imageView.setImage(Main.ENEMY_ROOM_2);
                this.spriteWidth = 50;
                this.spriteHeight = 50;
                break;
            case 3:
                this.hp = 10;
                this.moveSize = 5;
                imageView.setImage(Main.ENEMY_ROOM_3);
                this.spriteWidth = 50;
                this.spriteHeight = 50;
                break;
            }
        } catch (Exception e) {

        }
        this.imageView = imageView;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#move()
     */
    @Override
    public void move() {
        final String moveDirection = "WASD";
        final int length = moveDirection.length();
        Random rand = new Random();
        String randomDirection = String.valueOf(moveDirection.charAt(rand.nextInt(length)));
        boolean validMove = this.determineMove(randomDirection);
        if(validMove) {
            updateImageView(randomDirection);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#updateImageView(java.lang.String)
     */
    @Override
    public void updateImageView(String direction) {
        switch (direction) {
        case "W":
            this.imageView.setLayoutY(this.currentY -= this.moveSize);
            break;
        case "A":
            this.imageView.setLayoutX(this.currentX -= this.moveSize);
            break;
        case "S":
            this.imageView.setLayoutY(this.currentY += this.moveSize);
            break;
        case "D":
            this.imageView.setLayoutX(this.currentX += this.moveSize);
            break;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#fireProjectile()
     */
    @Override
    public IEntity fireProjectile() {
        IEntity temp = null;
        return temp;
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

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#checkColision(application.model.IEntity)
     */
    @Override
    public boolean checkCollision(IEntity entity2) {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#checkForDeath(application.model.IEntity)
     */
    @Override
    public boolean checkForDeath(IEntity iEntity) {
        Projectile projectile = (Projectile) iEntity;
        boolean death = false;
        double damageDone = projectile.getHp();
        if (this.hp - damageDone <= 0) {
            death = true;
        } else {
            this.hp -= damageDone;
        }
        return death;
    }

}