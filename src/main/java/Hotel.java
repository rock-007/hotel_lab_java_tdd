import rooms.*;

import java.util.ArrayList;
import java.util.HashMap;

import guests.Guest;

public class Hotel {

    private ArrayList<BedRoom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    //private HashMap<BedRoom, Integer> bookedRooms;
    private Booking hotelBooking;
    private String name;

    public Hotel(String name, Booking hotelBooking) {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.name = name;
        this.hotelBooking = hotelBooking;
    }

    public Booking getHotelBooking() {
        return hotelBooking;
    }

    public void setHotelBooking(Booking hotelBooking) {
        this.hotelBooking = hotelBooking;
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

    public void addBooking(BedRoom bedroom, int numberOfNights) {
        hotelBooking.setBookedRooms(bedroom, numberOfNights);

    }


}
