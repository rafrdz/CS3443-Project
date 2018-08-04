package application.model;

import java.util.Comparator;

/**
 * Model for the user object
 * 
 * @author Rafael Rodriguez - mat574
 *
 */
public class User {
    
    private String name;
    private int highScore;
    
    public User(String name) {
        this.name = name;
    }
    
    public User(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
    }
    
    public static Comparator<User> UserComparator = new Comparator<User>() {
        public int compare(User user1, User user2) {
            Integer score1 = user1.getHighScore();
            Integer score2 = user2.getHighScore();
            return score1.compareTo(score2);
        }
    };
    
    public String toString() {
        String retString = "";
        retString += "Name: " + this.getName() + ", High Score: " + this.getHighScore();
        return retString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

}
