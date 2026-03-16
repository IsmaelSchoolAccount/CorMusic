import java.util.ArrayList;

public class Music {

    protected User user;
    protected String name;
    protected String time;
    protected double price;
    protected String location;
    protected ArrayList<Comment> comments = new ArrayList<Comment>();
    protected int likes = 0;

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
