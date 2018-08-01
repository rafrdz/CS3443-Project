package application.model;

/**
 * Model for the Enemy object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Enemy extends Entity{
    
    public Enemy(double x, double y) {
        this.currentX = x;
        this.currentY = y;
        this.hp = 5;
        this.moveSize = 5;
    }
    
}