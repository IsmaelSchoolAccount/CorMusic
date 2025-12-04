import java.util.ArrayList;

public class Music {

    private User user;
    private String name;
    private String time;
    private double price;
    private String location;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
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
        return "Post by: " + user + "\n" + name + "\n" + location + " --- " + time + "\nprice: " + price + "$";
    }

    public void comment(Comment comment) {
        comments.add(comment);
    }

    public void like() {
        likes++;
    }

    public void unLike() {
        likes--;
    }

    public int getLikes()
    {
        return likes;
    }

    public ArrayList<Comment> getComments()
    {
        return comments;
    }

    public String getName()
    {
        return this.name;
    }
}
