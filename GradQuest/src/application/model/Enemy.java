package application.model;

/**
 * Model for the Enemy object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Enemy {

    private double curX;
    private double curY;
    public static final int moveSize = 5;
    
    public Enemy(double x, double y) {
        this.curX = x;
        this.curY = y;
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

}
