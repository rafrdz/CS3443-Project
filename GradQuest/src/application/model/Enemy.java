package application.model;

import application.Main;
import javafx.scene.image.ImageView;

/**
 * Model for the Enemy object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class Enemy extends Entity implements IEntity{
    
    public Enemy(double x, double y, ImageView imageView, int roomNum) {
		this.currentX = x;
        this.currentY = y;
        
        try{
	        switch(roomNum){
	        case 1:
	        	this.hp = 5;
	            this.moveSize = 5;
	            imageView.setImage(Main.ENEMY_ROOM_1);
	        	break;
	        case 2:
	        	//TODO room 2 numbers
	        	break;
	        case 3:
	        	//TODO room 3 numbers
	        	break;
	        }
        } catch (Exception e){
        	
        }
        this.imageView = imageView;
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