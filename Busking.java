public class Busking extends Music {

    private String type;

    public Busking(User activeUser, String name, String time, String location) {
        super(activeUser, name, time, 0.0, location);
        type = "busking";
    }

    public Busking()
    {
        super();
        type = "incomplete";
    }

    public void Comment(Comment comment)
    {
        //Overriden because comments not allowed on busking posts
    }
    
    @Override
    public String toString()
    {
        return "Post by: " + user + "\n" + name + "\n" + location + " --- " + time + "\n" + type;
    }
}
