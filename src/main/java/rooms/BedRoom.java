package rooms;

public class BedRoom extends Room {

    private int roomNo;
    private RoomType roomtype;

    public BedRoom(int capacity, int roomNo, RoomType roomtype) {
        super(capacity);
        this.roomNo = roomNo;
        this.roomtype = roomtype;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public RoomType getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(RoomType roomtype) {
        this.roomtype = roomtype;
    }

    public int getRoomSize() {
        return this.roomtype.getValue();
    }

    public int getCapacity() {
        return super.getCapacity();
    }

    public void decreaseCapacity() {
        super.decreaseCapacity();
    }
}
