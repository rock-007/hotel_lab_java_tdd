package rooms;

import java.util.ArrayList;

import guests.Guest;


public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);

    }

    public void decreaseCapacity() {
        capacity--;
    }

    public void remove(Guest guest) {
        int guestIndex = getGuestIndex(guest);
        this.guests.remove(guestIndex);
        capacity++;
    }

    private int getGuestIndex(Guest guest) {
        return this.guests.indexOf(guest);
    }
}
