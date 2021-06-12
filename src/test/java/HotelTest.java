import org.junit.Before;
import org.junit.Test;
import rooms.BedRoom;
import rooms.ConferenceRoom;
import rooms.RoomType;
import guests.Guest;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private BedRoom bedRoom;
    private BedRoom bedRoom1;
    private BedRoom bedRoom2;

    private ConferenceRoom conferenceRoom;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;


    @Before
    public void before() {
        hotel = new Hotel("Hilton-Hotel", new Booking());
        bedRoom = new BedRoom(3, 4, RoomType.TRIPLE, 50);
        bedRoom1 = new BedRoom(1, 5, RoomType.SINGLE, 50);
        bedRoom2 = new BedRoom(1, 6, RoomType.SINGLE, 50);

        guest1 = new Guest("Umair");
        guest2 = new Guest("John");
        guest3 = new Guest("Adam");
    }

    @Test
    public void canAddRoomToHotel() {
        hotel.setBedrooms(bedRoom);
        assertEquals(1, hotel.getBedrooms().size());
    }

    @Test
    public void addGuest() {
        hotel.setBedrooms(bedRoom);
        hotel.addGuestToBedroom(bedRoom, guest1);
        assertEquals(true, hotel.searchGuest(bedRoom, guest1));
    }

    @Test
    public void removeGuest() {
        hotel.setBedrooms(bedRoom);
        hotel.addGuestToBedroom(bedRoom, guest1);
        hotel.addGuestToBedroom(bedRoom, guest2);
        hotel.addGuestToBedroom(bedRoom, guest3);

        hotel.removeGuestFromBedroom(bedRoom, guest3);
        assertEquals(false, hotel.searchGuest(bedRoom, guest3));

    }

    @Test
    public void bookRoom() {
        hotel.setBedrooms(bedRoom);
        hotel.addGuestToBedroom(bedRoom, guest1);
        hotel.addGuestToBedroom(bedRoom, guest2);
        hotel.addGuestToBedroom(bedRoom, guest3);
        hotel.addBooking(bedRoom, 5);
        assertEquals(true, hotel.getHotelBooking().getBookedRooms().containsKey((4)));
    }

    @Test
    public void totalRoomRevenue() {
        hotel.setBedrooms(bedRoom);
        hotel.addGuestToBedroom(bedRoom, guest1);
        hotel.addGuestToBedroom(bedRoom, guest2);
        hotel.addGuestToBedroom(bedRoom, guest3);
        hotel.addBooking(bedRoom, 5);
        //  hotel.addBooking(bedRoom, 5); add this in test and refactor

        assertEquals(250, hotel.getHotelBooking().totalRoomRevenue(4));
    }

    @Test
    public void getVacentRooms() {
        hotel.setBedrooms(bedRoom);
        hotel.setBedrooms(bedRoom1);
        hotel.setBedrooms(bedRoom2);

        hotel.addGuestToBedroom(bedRoom, guest1);
        hotel.addGuestToBedroom(bedRoom1, guest2);
//        hotel.addGuestToBedroom(bedRoom2, guest3);

        hotel.addBooking(bedRoom, 5);
        hotel.addBooking(bedRoom1, 2);
//        hotel.addBooking(bedRoom2, 2);

        //  hotel.addBooking(bedRoom, 5); add this in test and refactor
        assertEquals(2, hotel.getVacentRooms().size());
    }

}
