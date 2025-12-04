import java.util.ArrayList;

public class Music {

    private User user;
    private String name;
    private String time;
    private double price;
    private String location;
    private ArrayList<String> comments;
    private int likes = 0;

    public Music(User activeUser, String name, String time, double price, String location) {
        this.user = activeUser;
        this.name = name;
        this.time = time;
        this.price = price;
        this.location = location;
    }
    
    public String toString()
    {
        return "Post by: " + user + "\n" + name + "\ncome to " + location + " --- " + time + "\nprice: " + price + "$";
    }
}
