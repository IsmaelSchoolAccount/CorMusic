public class Busking extends Music {

    public Busking(User activeUser, String name, String time, String location) {
        super(activeUser, name, time, 0.0, location);
    }
    
    @Override
    public String toString()
    {
        return "Post by: " + user + "\n" + name + "\n" + location + " --- " + time;
    }
}
