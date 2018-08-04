package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public class MainController implements EventHandler<ActionEvent> {
    
    @FXML
    private Pane mainPane;
    
    @FXML
    private Label mainTitle;
    
    @FXML
    private Button newGame, highScores, exit;

    @Override
    public void handle(ActionEvent event) {
        Main.moveToNextView("../application/views/Intro.fxml");
    }
    
    public void toHighScores() {
        Main.moveToNextView("../application/views/HighScore.fxml");
    }
    
    public void exitGame() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

}
