package application.model;

import application.Main;
import javafx.scene.image.ImageView;

/**
 * Model for the Enemy object
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 *
 */
public class Enemy extends Entity implements IEntity {

    /**
     * @param x
     * @param y
     * @param imageView
     * @param roomNum
     */
    public Enemy(double x, double y, ImageView imageView, int roomNum) {
        this.currentX = x;
        this.currentY = y;
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
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
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#updateImageView(java.lang.String)
     */
    @Override
    public void updateImageView(String direction) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see application.model.IEntity#checkColision(application.model.IEntity)
     */
    @Override
    public boolean checkColision(IEntity entity2) {
        // TODO Auto-generated method stub
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