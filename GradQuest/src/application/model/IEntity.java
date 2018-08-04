package application.model;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * @author David Brenner - iqc287
 *
 */
public interface IEntity {

    /**
     * 
     */
    public void move();

    /**
     * @param direction
     */
    public void updateImageView(String direction);

    /**
     * @return
     */
    public IEntity fireProjectile();

    /**
     * @return
     */
    public Node getImageView();

    /**
     * @param imageView
     */
    public void setImageView(ImageView imageView);

    /**
     * @return
     */
    public boolean needToRemove();

    /**
     * @param entity2
     * @return
     */
    public boolean checkColision(IEntity entity2);

    /**
     * @param iEntity
     * @return
     */
    public boolean checkForDeath(IEntity iEntity);
}
