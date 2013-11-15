package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptySeaTest {
    Ocean ocean = new Ocean();
    

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetShipType() {
        assertEquals("empty sea",ocean.ships[0][0].getShipType());
        assertEquals("empty sea",ocean.ships[9][9].getShipType());
    }

    @Test
    public void testIsSunk() {
        assertEquals(false,ocean.ships[0][0].isSunk());
    }

    @Test
    public void testToString() {
        ocean.ships[0][0].shootAt(0, 0);
        ocean.ships[1][0].shootAt(1, 0);
        assertEquals("-",ocean.ships[0][0].toString());
        assertEquals(".",ocean.ships[5][5].toString());
        assertEquals("-",ocean.ships[1][0].toString());
        assertEquals(".",ocean.ships[0][3].toString());
        ocean.ships[5][5].shootAt(5, 5);
        ocean.ships[0][3].shootAt(4, 3);
        assertEquals(".",ocean.ships[0][3].toString());
        assertEquals("-",ocean.ships[1][0].toString());
        assertEquals("-",ocean.ships[0][0].toString());
        assertEquals("-",ocean.ships[5][5].toString());
    }

}
