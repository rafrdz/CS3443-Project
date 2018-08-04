package application.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * User object model for storing user data, sorting users, and updating users
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class User {

    private String name;
    private int highScore;

    /**
     * Constructor for the User object
     * 
     * @param name
     *            - Name of the new user
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Constructor for the User object
     * 
     * @param name
     *            - Name of the new user
     * @param highScore
     *            - High score of the new user
     */
    public User(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    /**
     * Sorts a collection of User objects by highScore
     */
    public static Comparator<User> UserComparator = new Comparator<User>() {
        public int compare(User user1, User user2) {
            Integer score1 = user1.getHighScore();
            Integer score2 = user2.getHighScore();
            return score1.compareTo(score2);
        }
    };

    /**
     * Writes a new user to the highScores.csv file
     * 
     * @param user
     *            - The new user to be added
     * @throws IOException
     *             - Error in reading or writing from the file
     */
    public void updateStudentDebt(User user) throws IOException {
        Path path = Paths.get("./highScores.csv");
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            String currentLine = fileContent.get(i);
            String[] tokens = currentLine.split(",");
            String userName = tokens[0];
            if (userName.equals(user.getName())) {
                String newLine = userName + "," + user.getHighScore();
                fileContent.set(i, newLine);
                break;
            }
        }
        Files.write(path, fileContent, StandardCharsets.UTF_8);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String retString = "";
        retString += "Name: " + this.getName() + ", High Score: " + this.getHighScore();
        return retString;
    }

    /**
     * @return - Name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            - The name of the user to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return - High score of the user
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * @param highScore
     *            - High score of the user to be set
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

}
