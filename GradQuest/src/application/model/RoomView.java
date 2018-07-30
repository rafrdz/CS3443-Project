package application.model;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Model for the roomview object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class RoomView extends GridPane {
    
    private Room room;
    private int imageSize;
    
    public RoomView(Room room) {
        this.room = room;
        this.imageSize = 62;
        
        this.initializeView();
    }
    
    private void initializeView() {
        for(int r = 0; r < room.getNumRows(); r++) {
            for (int c = 0; c < room.getNumCols(); c++) {
                char letter = room.getRoomLocation(r, c);
                ImageView image = chooseImage(letter);
                this.add(image, c, r);
            }
        }
    }
    
    public ImageView chooseImage(char letter) {
        switch(letter) {
        case 'w':
            return getWallImage();
        case 'p':
            return getPlayerImage();
        case 'e':
            return getEnemyImage();
        case 'b':
            return getBossImage();
        default:
            return getBackgroundImage();
        }
    }
    
    public ImageView getWallImage() {
        ImageView img = new ImageView("File:images/roomWall.png");
        img.setFitHeight(imageSize);
        img.setFitWidth(imageSize);
        return img;
    }
    
    public ImageView getPlayerImage() {
        ImageView img = new ImageView("File:images/down0.png");
        img.setFitHeight(imageSize);
        img.setFitWidth(imageSize);
        return img;
    }
    
    public ImageView getEnemyImage() {
        ImageView img = new ImageView("File:images/evilFace.png");
        img.setFitHeight(imageSize);
        img.setFitWidth(imageSize);
        return img;
    }
    
    public ImageView getBossImage() {
        ImageView img = new ImageView("File:images/moneyBag.png");
        img.setFitHeight(imageSize);
        img.setFitWidth(imageSize);
        return img;
    }
    
    public ImageView getBackgroundImage() {
        ImageView img = new ImageView("File:images/roomBackground.png");
        img.setFitHeight(imageSize);
        img.setFitWidth(imageSize);
        return img;
    }

}
