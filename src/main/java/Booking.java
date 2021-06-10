import rooms.BedRoom;

public class Booking {

    private BedRoom bedRoom;
    private int numberOfNightsBooked;

    public Booking(BedRoom bedRoom, int numberOfNightsBooked){
        this.bedRoom = bedRoom;
        this.numberOfNightsBooked = numberOfNightsBooked;
    }

    public BedRoom getBedRoom() {
        return bedRoom;
    }

    public int getNumberOfNightsBooked() {
        return numberOfNightsBooked;
    }

}
