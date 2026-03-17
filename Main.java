import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    // 1. write 3 instance variables for class: private type variableName;
    private static ArrayList<Music> upcomingMusic = new ArrayList<Music>();
    private static ArrayList<User> allUsers = new ArrayList<User>();
    private static User activeUser = null;
    private static Music activeMusic = null;
    private static Scanner scanner = new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    private static String[] menuOptions = {"Exit", "Register User", "Login", "Logout", "Add Music", "View Next Music", "Comment", "Like", "View Comments"};

    public static void main(String args[])
    {
        registerUser("charles", "1234");
        registerUser("Kyle636", "GeorgeSux");
        registerUser("george_not_found", "Kylesbadatmath");
        registerUser("Corvallis Youth Symphony", "au*(y.T?#8Jk_");

        login("Corvallis Youth Symphony", "au*(y.T?#8Jk_");
        addMusic("CYS Winter Concert", "December 7th @ 4pm", 8.00, "LaSells Steward Center", "Concert");
        addMusic("CYS Spring Concert", "March 21st @ 4pm", 8.00, "LaSells Steward Center", "Concert");
        addMusic("CYS cabaret", "January 30th", 35.00, "Ashbrook Elementary School", "Concert");

        logout();

        login("Kyle636", "GeorgeSux");
        addMusic("Busking at the farmers market", "Every Saturday from 8-12", "Farmers Market");

        logout();

        login("george_not_found", "Kylesbadatmath");
        viewNextMusic(false);
        viewNextMusic(false);
        viewNextMusic(false);
        viewNextMusic(false);

        comment("This guy is great you should def check him out");
        like();
        
        activeMusic = null;
        logout();
        
        executeMenu();
    }

    public static void executeMenu() {
        printMenu();
        //Instead of an Enum im using a switch cause I like it better and I have no clue how an enum would work here
        String username = null;
        String password = null;
        switch (getNextIntFromUser()) {
            case 0:
                exit();
                break;
            case 1:
                System.out.println("Please enter your desired username and password");
                System.out.println("(0 to go back)");
                System.out.println("Username: ");
                username = getNextStringLineFromUser();
                System.out.println("Entered username: " + username);
                System.out.println("Password: ");
                password = getNextOneStringLineFromUser();
                System.out.println("Entered password: " + password);
                System.out.println("---------------");
                if (password != "0" && username != "0")
                {
                    if (registerUser(username, password))
                    {
                        System.out.println("Registration succesful");
                    }
                    else
                    {
                        System.out.println("Registration failed, likely username was not available, please try again");
                    }
                }
                else
                {   
                    System.out.println("Registration cancelled");
                }
                executeMenu();
                System.out.print("press enter to continue");
                getNextStringLineFromUser();
                break;
            case 2:
                System.out.println("Enter your username and password");
                System.out.println("(0 to go back)");
                System.out.println("Username: ");
                username = getNextStringLineFromUser();
                System.out.println("Entered username: " + username);
                System.out.println("Passoword: ");
                password = getNextOneStringLineFromUser();
                System.out.println("Entered password: " + password);
                System.out.println("---------------");
                if (password != "0" && username != "0")
                {
                    if (login(username, password))
                    {
                        System.out.println("Login succesful");
                    }
                    else
                    {
                        System.out.println("Login failed, please try again");
                    }
                }
                else
                {   
                    System.out.println("login cancelled");
                }
                executeMenu();
                break;
            case 3:
                logout();
                System.out.println("Logout Succesful");
                executeMenu();
                break;
            case 4:
                System.out.println("Add an event to the platform to be shared all around corvallis?");
                System.out.print("enter 1 to continue 0 to cancel: ");
                if (getNextIntFromUser() == 1)
                {
                    System.out.println("Name of the event: ");
                    String name = getNextStringLineFromUser();
                    System.out.println("Time and date: ");
                    String time = getNextOneStringLineFromUser();
                    System.out.println("Price of tickets (if free put 0): ");
                    double cost = Double.parseDouble(getNextOneStringLineFromUser());
                    System.out.println("Location: ");
                    String location = getNextOneStringLineFromUser();
                    if (cost == 0)
                    {
                        addMusic(name, time, location);
                    }
                    else
                    {
                        addMusic(name, time, cost, location, "Concert");
                    }
                }
                else
                {
                    System.out.println("canceling music post");
                }
                executeMenu();
                break;
            case 5:
                viewNextMusic(true);
                System.out.print("press enter to continue");
                getNextStringLineFromUser();
                executeMenu();
                break;
            case 6:
                System.out.println("Enter your comment");
                System.out.println("(0 to go back)");
                String comments = getNextStringLineFromUser();
                if (comments != "0")
                {
                    if (comment(comments))
                    {
                        viewComments();
                    }
                    else
                    {
                        System.out.println("Comment failed, make sure you have selected a music and are logged in");
                    }
                }
                else
                {   
                    System.out.println("Comment cancelled");
                }
                System.out.print("press enter to continue");
                executeMenu();
                break;
            case 7:
                if (like())
                {
                    System.out.println("total likes: " + activeMusic.likes);
                }
                else
                {
                    System.out.println("Like failed, make sure you have selected a music and are logged in");
                }
                System.out.print("press enter to continue");
                getNextStringLineFromUser();
                executeMenu();
                break;
            case 8:
                viewComments();
                System.out.print("press enter to continue");
                getNextStringLineFromUser();
                executeMenu();
                break;
            default:
                break;
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }

    private static void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private static int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private static String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    private static String getNextOneStringLineFromUser() {
        return scanner.nextLine();
    }

    public static void viewNextMusic(boolean print)
    {
        if (activeMusic == null)
        {
            activeMusic = upcomingMusic.get(0);
        } 
        else
        {
            int idx = upcomingMusic.indexOf(activeMusic);
            if (idx >= upcomingMusic.size())
            {
                activeMusic = upcomingMusic.get(0);
            }
            else 
            {
                activeMusic = upcomingMusic.get(idx+1);
            }
        }
        if (print)
        {
            System.out.println();
            System.out.println(activeMusic);
        }
    }

    public static boolean comment(String text)
    {
        if (activeMusic != null && activeUser != null)
        {
            Comment comment = new Comment(text, activeMusic, activeUser);
            activeUser.comment(comment);
            activeMusic.comment(comment);
            return true;
        }
        return false;
    }

    public static void viewComments()
    {
        viewComments(activeMusic);
    }

    public static void viewComments(Music music)
    {
        System.out.println();
        for (Comment c: music.getComments())
        {
            System.out.println(c);
        }
    }

    public static void viewComments(User user)
    {
        System.out.println();
        for (Comment c: user.getComments())
        {
            System.out.println(c);
        }
    }

    public static boolean like()
    {
        if (activeMusic != null && activeUser != null)
        {
            activeUser.like(activeMusic);
            return true;
        }
        return false;
    }

    public static void unLike()
    {
        if (activeMusic != null && activeUser != null)
        {
            activeUser.unLike(activeMusic);
        }
    }

    // 3. Write a print() method that uses System.out.println to print out all the instance variables.
    public static void print()
    {
        for (Music music: upcomingMusic)
        {
            System.out.println(music);
        }
    }

    // 4. Create accessor (get) methods for each of the instance variables.
    public static ArrayList<Music> getUpcomingMusic()
    {
        return upcomingMusic;
    }

    public static ArrayList<User> getUsers()
    {
        return allUsers;
    }

    public static User getActiveUser()
    {
        return activeUser;
    }

    // 5. Create mutator (set) methods for each of the instance variables.
    public static void setUpcomingMusic(ArrayList<Music> musics)
    {
        upcomingMusic = musics;
    }

    public static void setusers(ArrayList<User> users)
    {
        allUsers = users;
    }

    public static void setActiveUser(User user)
    {
        activeUser = user;
    }

    // 6. Create a toString() method that returns all the information in the instance variables.
    public String toString()
    {
        String musics = "";
        for (Music music: upcomingMusic)
        {
            musics += music;
        }
        return activeUser + musics;
    }

    // 7. Write an additional method for your class that takes a parameter.
    public static boolean login(String username, String password)
    {
        User user = getUser(username);
        if (user == null)
        {
            System.out.println("user is null");
            return false;
        }
        if (user.checkPassword(password))
        {
            activeUser = user;
            return true;
        }
        System.out.println("password is wrong");
        return false;
    }

    public static void logout()
    {
        activeUser = null;
    }

    public static User getUser(String username)
    {
        for (User user: allUsers)
        {
            if (user.getUsername().equals(username))
            {
                return user;
            }
        }
        return null;
    }

    public static boolean registerUser(String username, String password)
    {
        User user = getUser(username);
        if (user == null)
        {
            allUsers.add(new User(username, password));
            return true;
        }
        return false;
    }

    public static void addMusic(Music music)
    {
        upcomingMusic.add(music);
    }

    public static boolean addMusic(String name, String time, Double price, String location, String type)
    {

        if (activeUser == null)
        {
            return false;
        }
        if (type == "Busking")
        {
            addMusic(new Busking(activeUser, name, time, location));
        }
        else if (type == "Concert")
        {
            addMusic(new Concert(activeUser, name, time, price, location));
        }
        else
        {
            addMusic(new Music(activeUser, name, time, price, location));
        }
        return true;
    }

    public static boolean addMusic(String name, String time, String location)
    {

        if (activeUser == null)
        {
            return false;
        }
        addMusic(new Busking(activeUser, name, time, location));
        return true;
    }
}
