package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rafael Rodriguez - mat574
 *
 */
public class Leaderboard {

    private List<User> users;

    /**
     * 
     */
    public Leaderboard() {
        this.users = new ArrayList<User>();
    }

    /**
     * 
     */
    public void loadUsers() {
        List<User> users = new ArrayList<User>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./highScores.csv"));

            while (scan.hasNextLine()) {
                String userData = scan.nextLine();
                String[] tokens = userData.split(",");
                users.add(new User(tokens[0], Integer.parseInt(tokens[1])));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        Collections.sort(users, User.UserComparator);
        this.getUsers().addAll(users);
    }

    /**
     * @param name
     * @return
     */
    public boolean checkForUser(String name) {
        boolean exists = false;
        for (User tempUser : this.getUsers()) {
            if (name.equals(tempUser.getName())) {
                exists = true;
            }
        }
        return exists;
    }

    /**
     * @param name
     * @return
     */
    public User getUserByName(String name) {
        User temp = null;
        for (User current : this.getUsers()) {
            if (name.equals(current.getName())) {
                temp = current;
            }
        }
        return temp;
    }

    /**
     * @param user
     */
    public void createNewUser(User user) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        File file = null;

        try {
            String dataToWrite = user.getName() + "," + user.getHighScore();
            file = new File("./highScores.csv");

            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(dataToWrite);
            bufferedWriter.newLine();

            System.out.println("The data " + dataToWrite + " was successfully written to the file!");
        } catch (IOException ioe) {
            System.out.println("Error writing data to file");
            ioe.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error closing the file");
                ex.printStackTrace();
            }
        }
        this.getUsers().add(user);
    }

    /**
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
