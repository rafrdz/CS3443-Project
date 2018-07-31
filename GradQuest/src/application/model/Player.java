package application.model;

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

}
