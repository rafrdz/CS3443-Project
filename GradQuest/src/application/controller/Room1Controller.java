package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.Enemy;
import application.model.EnemyGroup;
import application.model.IEntity;
import application.model.Player;
import application.model.Projectile;
import application.model.User;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Displays the first room to the user and handles user inputs via keyboard
 * 
 * @author Rafael Rodriguez - mat574
 * @author David Brenner - iqc287
 * @author Max Renderos-Flores - nzt280
 */
public class Room1Controller implements Initializable {

    @FXML
    AnchorPane mainPane, topPane, bottomPane;

    @FXML
    SplitPane splitPane;

    @FXML
    Label roomLabel, difficultyLabel, playerLabel, debtValue, debtLabel;

    @FXML
    Button homeButton, exitButton;

    @FXML
    Rectangle doorShape;

    @FXML
    Circle doorKnob;

    public Player player;

    public ArrayList<IEntity> entities = new ArrayList<IEntity>();

    boolean leaveRoom = false;

    boolean gameOver = false;

    int roomNumber = 0;
    String difficulty = "";

    /*
     * (non-Javadoc)
     * 
     * @see javafx.fxml.Initializable#initialize(java.net.URL,
     * java.util.ResourceBundle)
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUserInfo();
        setDifficultyLabel();
        runDebtThread();
        new AnimationTimer() {
            int frames = 0;

            @Override
            public void handle(long now) {
                if (frames == 0) {
                    ImageView playerImage = new ImageView();
                    player = new Player(0, bottomPane.getHeight() - 64, playerImage, bottomPane);
                    entities.add(player);
                    bottomPane.getChildren().add(playerImage);
                    roomNumber = 1;
                    ArrayList<IEntity> arrayList = EnemyGroup.loadEnemies(IntroController.difficulty, roomNumber,
                            bottomPane);
                    entities.addAll(arrayList);
                }
                if (frames % 2 == 0) {
                    if (!gameOver) {
                        update();
                    } else {
                        this.stop();
                    }
                }
                if (frames % 10 == 0) {
                    fireProjectiles();
                }
                
                if (frames % 30 == 0) {
                    removeOffScreenProjectiles();
                }
                frames++;
            }
        }.start();
    }

    /**
     * Removes projectiles that have gone off the screen.
     */
    protected void removeOffScreenProjectiles() {
    	ArrayList<Integer> removedIndexes = new ArrayList<Integer>();
        for (int i = 0; entities.size() > i; i++) {
            if (entities.get(i) instanceof Projectile && entities.get(i).needToRemove()) {
                removedIndexes.add(i);
            }
        }
        for(int i = removedIndexes.size()-1;i > 0; i--){
        	bottomPane.getChildren().remove(entities.get(removedIndexes.get(i)).getImageView());
            entities.remove(entities.get(removedIndexes.get(i)));
        }
	}

	/**
     * Returns the user to the starting view
     */
    public void returnHome() {
        Main.moveToNextView("../application/views/Main.fxml");
    }

    /**
     * Fires projectiles from the player character
     */
    protected void fireProjectiles() {
        ArrayList<IEntity> newProjectiles = new ArrayList<IEntity>();
        IEntity newEnitity = checkForNewProjectile(player);
        if (newEnitity != null) {
            newProjectiles.add(newEnitity);
        }
        entities.addAll(newProjectiles);
    }

    /**
     * Check to see if a new projectile should be created and displayed on the screen
     * @param entity
     * @return
     */
    private IEntity checkForNewProjectile(IEntity entity) {
        IEntity newEnitity = entity.fireProjectile();
        if (newEnitity != null) {
            ImageView imageView = new ImageView(Main.EXPLOSION);
            imageView.setViewport(new Rectangle2D(256, 128, 64, 64));
            newEnitity.setImageView(imageView);
            imageView.setLayoutX(player.getCurrentX());
            imageView.setLayoutY(player.getCurrentY());
            bottomPane.getChildren().add(newEnitity.getImageView());
        }
        return newEnitity;
    }

    /**
     * Updates all of the entities on the current view
     */
    protected void update() {
        for (int i = 0; entities.size() > i; i++) {
            entities.get(i).move();
            if (entities.get(i) instanceof Player) {
                leaveRoom = checkLeaveRoom();
            }
        }
        checkForCollisions();
        boolean enemiesLeft = false;
        for (IEntity entity : entities) {
            if (entity instanceof Enemy) {
                enemiesLeft = true;
            }
        }
        if (!enemiesLeft && leaveRoom) {
            roomNumber++;
            if (roomNumber > 3) {
                endGame();
                return;
            }
            roomLabel.setText("Room " + roomNumber);
            player.getImageView().setLayoutY(bottomPane.getHeight() - 64);
            player.setCurrentY(bottomPane.getHeight() - 64);
            ArrayList<Integer> projectilesIndexs = new ArrayList<Integer>();
            ArrayList<IEntity> projectiles = new ArrayList<IEntity>();
            for (int i = 0; entities.size() > i; i++) {
                if ((entities.get(i) instanceof Projectile)) {
                    projectiles.add(entities.get(i));
                    projectilesIndexs.add(i);
                }
            }
            for(int i = projectilesIndexs.size()-1;i > 0; i--){
            	bottomPane.getChildren().remove(entities.get(projectilesIndexs.get(i)).getImageView());
                entities.remove(entities.get(projectilesIndexs.get(i)));
            }

            ArrayList<IEntity> arrayList = EnemyGroup.loadEnemies(IntroController.difficulty, roomNumber, bottomPane);
            entities.addAll(arrayList);
        }
    }

    /**
     * Calculates the final score of the player, updates the final score, ends the
     * game, and sends the user to the HighScore view
     */
    private void endGame() {
        User currentUser = IntroController.currentUser;
        String difficulty = IntroController.difficulty;
        int newScore = Integer.parseInt(debtValue.getText());

        if ("Easy".equals(difficulty)) {
            newScore = newScore * 3;
        } else if ("Medium".equals(difficulty)) {
            newScore = newScore * 2;
        } else {
            newScore = newScore * 1;
        }
        currentUser.setHighScore(newScore);
        try {
            currentUser.updateStudentDebt(currentUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameOver = true;
        Main.moveToNextView("../application/views/HighScore.fxml");
    }

    /**
     * Determines if the player has "left" the current room
     * 
     * @return - Whether or not the player has left the room
     */
    private boolean checkLeaveRoom() {
        boolean isCollision = false;

        if (player.getCurrentX() < doorShape.getLayoutX() + 80
                && player.getCurrentX() + player.getSpriteWidth() > doorShape.getLayoutX()
                && player.getCurrentY() < doorShape.getLayoutY() + 30
                && player.getSpriteHeight() + player.getCurrentY() > doorShape.getLayoutY()) {
            isCollision = true;
        }
        return isCollision;
    }

    /**
     * Checks each entity in the view for a collision and responds with the
     * appropriate action
     */
    private void checkForCollisions() {
        ArrayList<IEntity> projectiles = new ArrayList<IEntity>();
        ArrayList<IEntity> enemies = new ArrayList<IEntity>();
        for (IEntity entity : entities) {
            if (!(entity instanceof Player)) {
                if (entity instanceof Projectile) {
                    projectiles.add(entity);
                } else if (entity instanceof Enemy) {
                    enemies.add(entity);
                }
            }
        }
        ArrayList<Integer> removeProjectileIndexs = new ArrayList<Integer>();
        ArrayList<Integer> removeEnemyIndexs = new ArrayList<Integer>();
        for (int i = 0; projectiles.size() > i; i++) {
            for (int j = 0; enemies.size() > j; j++) {
                boolean wasCollison = projectiles.get(i).checkCollision(enemies.get(j));
                if (wasCollison) {
                    projectiles.get(i).updateImageView("w");
                    removeProjectileIndexs.add(i);
                    boolean death = enemies.get(j).checkForDeath(projectiles.get(i));
                    if (death) {
                        removeEnemyIndexs.add(j);
                    }
                }
            }
        }
        if (!enemies.isEmpty()) {
            for (IEntity e : enemies) {
                boolean playerCollison = player.checkCollision(e);
                if (playerCollison)
                    endGame();
            }
        }
        for (Integer integer : removeProjectileIndexs) {
            System.out.println(integer);
            bottomPane.getChildren().remove(projectiles.get(integer).getImageView());
            entities.remove(projectiles.get(integer));
        }
        for (Integer integer : removeEnemyIndexs) {
            System.out.println(integer);
            bottomPane.getChildren().remove(enemies.get(integer).getImageView());
            entities.remove(enemies.get(integer));
        }
    }

    /**
     * Determines an action based on user key release
     * 
     * @param event
     *            - The input from the user
     */
    public void handleKeyRelease(KeyEvent event) {
        switch (event.getCode()) {
        case A:
        case W:
        case S:
        case D:
            if (player.getMovements().contains(event.getCode().toString())) {
                player.getMovements().remove(event.getCode().toString());
            }
            break;
        case UP:
        case DOWN:
        case RIGHT:
        case LEFT:
        	if (player.getFireKeys().contains(event.getCode().toString())) {
                player.getFireKeys().remove(event.getCode().toString());
            }
            break;
        default:
            break;
        }
    }

    /**
     * Determines an action based on user key press
     * 
     * @param event
     *            - The input from the user
     */
    public void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
        case A:
        case W:
        case S:
        case D:
            if (!player.getMovements().contains(event.getCode().toString())) {
                player.getMovements().add(event.getCode().toString());
            }
            break;
        case UP:
        case DOWN:
        case RIGHT:
        case LEFT:
        	if (!player.getFireKeys().contains(event.getCode().toString())) {
                player.getFireKeys().add(event.getCode().toString());
            }
            break;
        default:
            break;
        }
    }

    /**
     * Sets the user name in the information section of the game view
     */
    private void setUserInfo() {
        playerLabel.setText("Player: " + IntroController.currentUser.getName());
    }

    /**
     * Sets the difficulty level in the information section of the game view
     */
    private void setDifficultyLabel() {
        difficultyLabel.setText("-" + IntroController.difficulty);
    }

    /**
     * Starts and runs the debt counter in the information section of the game view
     */
    public void runDebtThread() {
        try {
            Thread th = new Thread(new Task<Object>() {
                @Override
                protected String call() throws Exception {
                    for (int i = 1000; i <= Integer.MAX_VALUE; i += 1000) {
                        final int debt = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                debtValue.setText(String.valueOf(debt));
                            }
                        });
                        Thread.sleep(1000);
                    }
                    return "Debt thread done!";
                }
            });
            th.setDaemon(true);
            th.start();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exits the game by clicking on the Exit Button or by pressing the "Escape" key
     * 
     * @param event
     *            - Keyboard input
     */
    public void exitGame(Event event) {
        if (event instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.getCode() == KeyCode.ESCAPE) {
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        } else if (event instanceof MouseEvent) {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        }
    }

}
