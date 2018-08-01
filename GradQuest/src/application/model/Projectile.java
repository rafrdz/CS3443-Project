package application.model;

public class Projectile extends Entity implements IEntity{

	boolean isPlayers = false;
	
	public Projectile(int hp, boolean isPlayers, double currentX, double currentY) {
		this.hp = hp;
		this.isPlayers = isPlayers;
		this.currentX = currentX;
		this.currentY = currentY;
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

}
