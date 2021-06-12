package rooms;


import java.util.ArrayList;

public class DiningRoom extends Room {
    private String name;
    private ArrayList<String> guestCollection;

    public DiningRoom(String name, int capacity) {
        super(capacity);
        this.name = name;
        this.guestCollection = new ArrayList<>();
    }

    public ArrayList<String> getGuestCollection() {
        return guestCollection;
    }

    public void setGuestCollection(String guestName) {
        this.guestCollection.add(guestName);
    }

    public String getName() {
        return name;
    }
}
