import rooms.BedRoom;

import java.util.HashMap;

public class Booking {

    private HashMap<BedRoom, Integer> bookedRooms;

    public Booking() {

        this.bookedRooms = new HashMap<>();
    }

    public HashMap<BedRoom, Integer> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(BedRoom bedroom, int noOfdaysBooked) {

        if (bedRoomExist(bedroom) && bedRoomCapacity(bedroom) > 0) {

        } else if (bedRoomExist(bedroom) && bedRoomCapacity(bedroom) <= 0) {

        } else {
            bookedRooms.put(bedroom, noOfdaysBooked);


        }


    }

    private boolean bedRoomExist(BedRoom bedroom) {
        for (room : bookedRooms){
            if (room == bedroom){

            }
        }

    }
}
