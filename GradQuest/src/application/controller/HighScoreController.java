package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Leaderboard;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Handles the data between the view and the controller
 * @author Rafael Rodriguez - mat574
 *
 */
public class HighScoreController implements EventHandler<ActionEvent>, Initializable {

    @FXML
    Label highScoresLabel;

    @FXML
    Button homeButton, exitButton;

    @FXML
    TableView<User> scoresTable;

    @FXML
    TableColumn<User, String> playerColumn;

    @FXML
    TableColumn<User, Integer> scoreColumn;

    public Leaderboard board;

    /*
     * (non-Javadoc)
     * 
     * @see javafx.fxml.Initializable#initialize(java.net.URL,
     * java.util.ResourceBundle)
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        board = new Leaderboard();
        board.loadUsers();
        buildScoreboard();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javafx.event.EventHandler#handle(javafx.event.Event)
     */
    @Override
    public void handle(ActionEvent event) {
        Main.moveToNextView("../application/views/Main.fxml");
    }

    /**
     * Exits the application
     */
    public void exitGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Pulls user data from the highScores.csv file and builds the table
     */
    private void buildScoreboard() {
        playerColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("highScore"));
        scoresTable.getItems().addAll(board.getUsers());
    }
}
