public class Comment {

    private String comment;
    private Music music;
    private User user;

    public Comment(String comment, Music music, User user) {
        this.comment = comment;
        this.music = music;
        this.user = user;
    }

    public String toString()
    {
        return this.comment + "\n" + this.music.getName() + "\nUser: " + user; 
    }
}
