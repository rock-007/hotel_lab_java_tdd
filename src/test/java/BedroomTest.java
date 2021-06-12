import org.junit.Before;
import org.junit.Test;

import rooms.BedRoom;
import rooms.Room;
import rooms.RoomType;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private BedRoom bedroom;

    @Before

    public void before() {
        bedroom = new BedRoom(3, 1, RoomType.DOUBLE, 50);
    }


    @Test
    public void roomHasType() {
        assertEquals(RoomType.DOUBLE, bedroom.getRoomtype());
        assertEquals(2, bedroom.getRoomSize());
    }

    @Test
    public void checkCapacity() {
        assertEquals(3, bedroom.getCapacity());
    }

}
