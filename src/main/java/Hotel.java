import rooms.*;

import java.util.ArrayList;
import java.util.HashMap;

import guests.Guest;

public class Hotel {

    private ArrayList<BedRoom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    //private HashMap<BedRoom, Integer> bookedRooms;
    private Booking booking;
    private String name;

    public Hotel(String name) {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.name = name;
        this.bookedRooms = new HashMap<>();
        this.booking = new Booking();
    }

    public ArrayList<BedRoom> getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(BedRoom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void setConferenceRooms(ArrayList<ConferenceRoom> conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }

    public String getName() {
        return name;
    }

    public int searchIndexInBedrooms(BedRoom bedroom, Guest guest) {
        int index = 0;
        if (bedroom.getCapacity() > 0) {
            for (int i = 0; i < bedrooms.size(); i++) {

                if (bedroom.getRoomNo() == bedrooms.get(i).getRoomNo()) {
                    index = i;
                }
            }
        }
        return index;

    }


    public void addGuestToBedroom(BedRoom bedroom, Guest guest) {

        int index = searchIndexInBedrooms(bedroom, guest);

        if (bedroom.getRoomNo() == bedrooms.get(index).getRoomNo()) {
            bedrooms.get(index).addGuest(guest);
        }

        bedroom.decreaseCapacity();
    }


    public void removeGuestFromBedroom(BedRoom bedroom, Guest guest) {

        int index = searchIndexInBedrooms(bedroom, guest);


        if (bedroom.getRoomNo() == bedrooms.get(index).getRoomNo() && bedrooms.get(index).getGuests().contains(guest)) {
            bedrooms.get(index).remove(guest);
        }


    }


    public boolean searchGuest(BedRoom bedroom, Guest guest1) {
        boolean result = false;
        for (int i = 0; i < bedrooms.size(); i++) {
            System.out.println(bedrooms.get(i));

            if (bedroom.getRoomNo() == bedrooms.get(i).getRoomNo() && bedrooms.get(i).getGuests().contains(guest1)) {

                result = true;
                break;
            }
        }
        return result;
    }

    public void createBooking(BedRoom bedroom, int numberOfNights) {
        if (!searchBookedBedroom(bedroom)) {
            bookedRooms.put(bedroom, numberOfNights);
        }
    }

    public boolean searchBookedBedroom(BedRoom bedroom) {

        return bookedRooms.containsKey(bedroom);
    }
}
