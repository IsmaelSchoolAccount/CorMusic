import java.util.ArrayList;

public class User {

    private String username;
    private String password;

    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private ArrayList<Music> likedMusic = new ArrayList<Music>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return password == this.password;
    }

    public String toString()
    {
        return this.username;
    }

    public void comment(Comment comment) {
        comments.add(comment);
    }

    public void like(Music activeMusic) {
        if (!likedMusic.contains(activeMusic))
        {
            likedMusic.add(activeMusic);
            activeMusic.like();
        }
    }

    public void unLike(Music activeMusic) {
        if (likedMusic.contains(activeMusic))
        {
            likedMusic.remove(activeMusic);
            activeMusic.unLike();
        }
    }

    public ArrayList<Comment> getComments()
    {
        return comments;
    }

    public ArrayList<Music> getLikedMusic()
    {
        return likedMusic;
    }
}
