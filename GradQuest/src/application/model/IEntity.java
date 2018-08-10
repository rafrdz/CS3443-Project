package application.model;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * @author David Brenner - iqc287
 *
 */
public interface IEntity {

    /**
     * Checks if the object can moves and moves it on the veiw port
     */
    public void move();

    /**
     * Updates the view port
     * @param direction
     */
    public void updateImageView(String direction);

    /**
     * Check for a new projectile and creates on to be put on the scene
     * @return
     */
    public IEntity fireProjectile();

    /**
     * Returns the Imageview for entity
     * @return
     */
    public Node getImageView();

    /**
     * @param imageView
     */
    public void setImageView(ImageView imageView);

    /**
     * Checks if the entity needs to be removed from the scene
     * @return
     */
    public boolean needToRemove();

    /**
     * Checks if an entity calling this method collides with the entity passed in.
     * @param entity2
     * @return
     */
    public boolean checkCollision(IEntity entity2);

    /**
     * Checks if the entity dies
     * @param iEntity
     * @return
     */
    public boolean checkForDeath(IEntity iEntity);
}
