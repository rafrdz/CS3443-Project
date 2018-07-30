package application.model;

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
    
    public String toString() {
        String retString = "";
        retString += "Name: " + this.getName() + " High Score: " + this.getHighScore();
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
