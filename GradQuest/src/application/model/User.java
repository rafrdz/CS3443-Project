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
 * Model for the user object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class User {

    private String name;
    private int highScore;

    /**
     * @param name
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * @param name
     * @param highScore
     */
    public User(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    /**
     * 
     */
    public static Comparator<User> UserComparator = new Comparator<User>() {
        public int compare(User user1, User user2) {
            Integer score1 = user1.getHighScore();
            Integer score2 = user2.getHighScore();
            return score1.compareTo(score2);
        }
    };

    /**
     * @param user
     * @throws IOException
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
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * @param highScore
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

}
