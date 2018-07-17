package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public class IntroController implements EventHandler<ActionEvent>{

    
    @FXML
    private Pane introPane;
    
    @FXML
    private TextArea introTextArea;
    
    @FXML
    private MenuButton introMenu;
    
    @FXML
    private MenuItem menuItemMain, menuItem;
    
    @Override
    public void handle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../Main.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();
            Scene scene = new Scene(layout);
            Main.stage.setScene(scene);
            Main.stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void exitGame() {
        // TODO Exit game
    }

}
