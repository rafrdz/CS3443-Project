package application.model;

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
        if("right".equals(direction)) {
            if(curX + 50 < 459) {
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
