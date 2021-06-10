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
    private ConferenceRoom conferenceRoom;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;


    @Before
    public void before() {
        hotel = new Hotel("Hilton-Hotel");
        bedRoom = new BedRoom(3, 4, RoomType.TRIPLE);
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
        hotel.createBooking(bedRoom, 5);
        assertEquals(true, hotel.searchBookedBedroom(bedRoom));
    }
}
