import java.util.ArrayList;

public class Main 
{
    // 1. write 3 instance variables for class: private type variableName;
    private static ArrayList<Music> upcomingMusic = new ArrayList<Music>();
    private static ArrayList<User> allUsers = new ArrayList<User>();
    private static User activeUser = null;
    private static Music activeMusic = null;

    // 2. Add a constructor with 3 parameters to set all of the instance variables to the given parameters.
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
        viewNextMusic();
        viewNextMusic();
        viewNextMusic();
        viewNextMusic();

        comment("This guy is great you should def check him out");
        like();

        viewComments();
        
    }

    public static void viewNextMusic()
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
        System.out.println();
        System.out.println(activeMusic);
    }

    public static void comment(String text)
    {
        if (activeMusic != null && activeUser != null)
        {
            Comment comment = new Comment(text, activeMusic, activeUser);
            activeUser.comment(comment);
            activeMusic.comment(comment);
        }
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

    public static void like()
    {
        if (activeMusic != null && activeUser != null)
        {
            activeUser.like(activeMusic);
        }
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
            return false;
        }
        if (user.checkPassword(password))
        {
            activeUser = user;
            return true;
        }
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
            if (user.getUsername() == username)
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
