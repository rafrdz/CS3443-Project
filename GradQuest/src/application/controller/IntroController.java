package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Displays story information, introduces the user to the controls, prompts the
 * user to enter their name, and starts the game.
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner = iqc287
 */
public class IntroController implements EventHandler<ActionEvent>, Initializable {

    @FXML
    private Pane introPane;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button homeButton, exitButton, startButton;

    @FXML
    private Label descriptionLabel, controlsLabel, wText, aText, sText, dText, spaceText, wLabel, aLabel, sLabel,
            dLabel, spaceLabel, usernameLabel, difficultyLabel, upLabel, downLabel, leftLabel, rightLabel, errorMessage;

    @FXML
    private Rectangle wShape, sShape, dShape, aShape, spaceShape, downShape, leftShape, rightShape, upShape;

    @FXML
    private TextField usernameInput;
    
    @FXML
    private ChoiceBox<String> difficultyPicker;

    public static User currentUser;
    
    public static String difficulty;

    /*
     * (non-Javadoc)
     * 
     * @see javafx.fxml.Initializable#initialize(java.net.URL,
     * java.util.ResourceBundle)
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        errorMessage.setVisible(false);
        descriptionTextArea.setEditable(false);
        buildDifficultyOptions();
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
     * Non-grid view implementation
     */
    public void startGame() {
        if (validateUserInput(usernameInput.getText())) {
            errorMessage.setVisible(false);
            currentUser = new User(usernameInput.getText());
        } else {
            errorMessage.setVisible(true);
            return;
        }
        difficulty = difficultyPicker.getValue().toString();
        Main.moveToNextView("../application/views/Room1.fxml");
    }

    /**
     * Validates the user input
     * 
     * @param name
     *            - The user input
     * @return - Whether or not the input is valid
     */
    private boolean validateUserInput(String name) {
        if (!(name.isEmpty())) {
            return true;
        }
        return false;
    }
    
    private void buildDifficultyOptions() {
        difficultyPicker.getItems().removeAll(difficultyPicker.getItems());
        difficultyPicker.getItems().addAll("Easy", "Medium", "Hard");
        difficultyPicker.getSelectionModel().select("Easy");
    }

}
