package application.model;

public class User {
    
    private String name;
    private int highScore;
    
    public User(String name) {
        this.name = name;
    }
    
    public String toString() {
        StringBuilder ret = new StringBuilder();
        
        ret.append( name );
        return ret.toString();
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
