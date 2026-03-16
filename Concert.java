public class Concert extends Music {

    public Concert(User activeUser, String name, String time, double price, String location) {
        super(activeUser, name, time, price, location);
    }
    
    @Override
    public String toString()
    {
        return "Concert Post by: " + user + "\n" + name + "\n" + location + " --- " + time + "\nprice: " + price + "$";
    }
}
