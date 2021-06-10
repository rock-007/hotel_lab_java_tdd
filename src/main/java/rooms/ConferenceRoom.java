package rooms;

public class ConferenceRoom extends Room {

    private int roomNo;
    private String name;

    public ConferenceRoom(int capacity, int roomNo, String name) {
        super(capacity);
        this.roomNo = roomNo;
        this.name = name;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
