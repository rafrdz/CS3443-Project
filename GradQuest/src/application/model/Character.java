package application.model;

import javafx.scene.shape.Rectangle;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public abstract class Character {
    
    // Character position
    private float xPos, yPos;
    
    // Character dimensions
    public static int width = 50;
    public static int height = 50;
    
    // Character hitbox
    private Rectangle hitbox;
    
    public Character(float x, float y) {
        this.xPos = x;
        this.yPos = y;
        this.hitbox = new Rectangle(0, 0, width, height);
    }
    
    public abstract void update();
    public abstract void display();

}
