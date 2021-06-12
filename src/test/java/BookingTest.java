import org.junit.Before;

import rooms.BedRoom;
import rooms.RoomType;

public class BookingTest {

    private BedRoom bedroom;
    private Booking booking;
    private Hotel hotel;

    @Before
    public void before() {
        bedroom = new BedRoom(4, 5, RoomType.FAMILY, 50);
        booking = new Booking();
        hotel = new Hotel("Hilton-Hotel", booking);
    }


}
