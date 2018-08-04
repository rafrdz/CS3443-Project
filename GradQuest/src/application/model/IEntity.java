package application.model;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public interface IEntity {

	public void move();
	public void updateImageView(String direction);
	public IEntity fireProjectile();
	public Node getImageView();
	public void setImageView(ImageView imageView);
	public boolean needToRemove();
	public boolean checkColision(IEntity entity2);
	public boolean checkForDeath(IEntity iEntity);
}
