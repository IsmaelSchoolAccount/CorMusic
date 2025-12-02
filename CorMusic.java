public class Main 
{
    // 1. write 3 instance variables for class: private type variableName;
    private Music[] upcomingMusic;
    private User[] allUsers;
    private User activeUser;

    // 2. Add a constructor with 3 parameters to set all of the instance variables to the given parameters.

    // 3. Write a print() method that uses System.out.println to print out all the instance variables.
    public void print()
    {
        for (Music music: upcomingMusic)
        {
            System.out.println(music);
        }
    }

    // 4. Create accessor (get) methods for each of the instance variables.
    public Music[] getUpcomingMusic()
    {
        return upcomingMusic;
    }

    public User[] getUsers()
    {
        return allUsers;
    }

    public User getActiveUser()
    {
        return activeUser;
    }

    // 5. Create mutator (set) methods for each of the instance variables.

    public void setUpcomingMusic(Music[] musics)
    {
        upcomingMusic = musics;
    }

    public void setusers(User[] users)
    {
        allUsers = users;
    }

    public void setActiveUser(User user)
    {
        activeUser = user;
    }

    // 6. Create a toString() method that returns all the information in the instance variables.

    // 7. Write an additional method for your class that takes a parameter.
    // For example, there could be a print method with arguments that indicate how you want to print out
    // the information, e.g. print(format) could print the data according to an argument that is "plain"
    // or "table" where the data is printed in a table drawn with dashes and lines (|).

    // 8. Write a main method that constructs at least 2 objects of your class
    // using the constructor and then calls all of the methods that you created above to test them.
    public static void main(String[] args)
    {
       // Construct 2 objects of your class using the constructor with different values


       // call all of the objects methods to test them

    }
}
