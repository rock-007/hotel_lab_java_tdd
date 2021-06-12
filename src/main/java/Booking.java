import rooms.BedRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Booking {
    //HashMap is having RoomNo as Key and Arraylist of two items capacity and no of nights booked
    //ArrayList<Integer> will be {capacityleft, no of days booked,total_revenue_from_room, last_paid_price}
    private HashMap<Integer, ArrayList<Integer>> bookedRooms;

    public HashMap<Integer, ArrayList<Integer>> getBookedRooms() {
        return bookedRooms;
    }

    public Booking() {

        this.bookedRooms = new HashMap<>();
    }


    //Booking_the_bedrooms
    public HashMap<Integer, ArrayList<Integer>> setBookedRooms(BedRoom bedroom, int noOfdaysBooked) {

        if (bedRoomExist(bedroom) && bookedBedRoomCapacity(bedroom.getRoomNo()) > 0) {
            updateCapacity(bedroom.getRoomNo(), -1, noOfdaysBooked, bedroom.getPrice(noOfdaysBooked));

        } else if (bedRoomExist(bedroom) && bookedBedRoomCapacity(bedroom.getRoomNo()) == 0) {
            System.out.println("No capacity left");

        } else {
            bookedRooms.put(bedroom.getRoomNo(), new ArrayList<Integer>(Arrays.asList(bedroom.getCapacity() - 1, noOfdaysBooked, bedroom.getPrice(noOfdaysBooked), bedroom.getPrice(noOfdaysBooked))));


        }

        return bookedRooms;
    }

    // Upodating_capacity_in_a_room
    private void updateCapacity(int roomNo, int capacityChange, int noOfdaysBooked, int totalPrice) {

        bookedRooms.put(roomNo, new ArrayList<Integer>(Arrays.asList(bookedBedRoomCapacity(roomNo) + capacityChange, noOfdaysBooked, totalRoomRevenue(roomNo) + totalPrice, totalPrice)));
    }

    public int totalRoomRevenue(int roomNo) {
        return bookedRooms.get(roomNo).get(2);
    }

    //Checking_left_capacity_in_a_room
    private int bookedBedRoomCapacity(Integer roomNo) {
        System.out.println("bookingxx" + bookedRooms.get(roomNo));
        return bookedRooms.get(roomNo).get(0);


    }
    //Checking_if_bedroom_already_added

    private boolean bedRoomExist(BedRoom bedroom) {
        System.out.println("ss" + bookedRooms.containsKey(bedroom.getRoomNo()));
        return bookedRooms.containsKey(bedroom.getRoomNo());

    }
}
