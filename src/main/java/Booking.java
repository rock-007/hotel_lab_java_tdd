import rooms.BedRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Booking {
    //HashMap is having RoomNo as Key and Arraylist of two items capacity and no of nights booked
    private HashMap<Integer, ArrayList<Integer>> bookedRooms;

    public HashMap<Integer, ArrayList<Integer>> getBookedRooms() {
        return bookedRooms;
    }

    public Booking() {

        this.bookedRooms = new HashMap<>();
    }

//    public HashMap<BedRoom, Integer> getBookedRooms() {
//        return bookedRooms;
//    }

    public void setBookedRooms(BedRoom bedroom, int noOfdaysBooked) {

        if (bedRoomExist(bedroom) && bookedBedRoomCapacity(bedroom.getRoomNo()) > 0) {
            updateCapacity(bedroom.getRoomNo(), -1, noOfdaysBooked);

        } else if (bedRoomExist(bedroom) && bookedBedRoomCapacity(bedroom.getRoomNo()) == 0) {
            System.out.println("No capacity left");

        } else {
            bookedRooms.put(bedroom.getRoomNo(), new ArrayList<Integer>(Arrays.asList(bedroom.getCapacity() - 1, noOfdaysBooked)));


        }


    }

    private void updateCapacity(int roomNo, int capacityChange, int noOfdaysBooked) {

        bookedRooms.put(roomNo, new ArrayList<Integer>(Arrays.asList(bookedBedRoomCapacity(roomNo) + capacityChange, noOfdaysBooked)));
    }

    private int bookedBedRoomCapacity(Integer roomNo) {
        System.out.println("bookingxx"+roomNo);
        return bookedRooms.get(roomNo).get(0);


    }

    private boolean bedRoomExist(BedRoom bedroom) {
        System.out.println("ss"+ bookedRooms.containsKey(bedroom.getRoomNo()));
        return bookedRooms.containsKey(bedroom.getRoomNo());

    }
}
