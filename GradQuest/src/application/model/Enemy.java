package application.model;

/**
 * Model for the Enemy object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Enemy extends Entity implements IEntity{
    
    public Enemy(double x, double y) {
        this.currentX = x;
        this.currentY = y;
        this.hp = 5;
        this.moveSize = 5;
    }

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImageView(String direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IEntity fireProjectile() {
		IEntity temp = null;
		
		return temp;
		
	}

	@Override
	public boolean needToRemove() {
		// TODO Auto-generated method stub
		return false;
	}
    
}