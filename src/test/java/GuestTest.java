import guests.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before() {
        guest = new Guest("John");
    }

    @Test
    public void guestHasName(){
        assertEquals("John", guest.getName());
    }

}
