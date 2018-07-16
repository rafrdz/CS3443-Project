package application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
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
        // TODO Return the user to the main menu
    }
    
    public void exitGame() {
        // TODO Exit game
    }

}
