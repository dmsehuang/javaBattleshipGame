package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
    Ocean ocean = new Ocean();
    Ship ship = new Ship();

    @Before
    public void setUp() throws Exception {
        ship.setBowRow(5);
        ship.setBowColumn(7);
        ship.setHorizontal(true);
    }
//
//    @Test
//    public void testGetBowRow() {
//        assertEquals(5, ship.getBowRow());
//    }
//
//    @Test
//    public void testGetBowColumn() {
//        assertEquals(7, ship.getBowColumn());
//    }
//
//    @Test
//    public void testIsHorizontal() {
//        assertEquals(true, ship.isHorizontal());
//    }
//
//    @Test
//    public void testOkToPlaceShipAt() {
//        Battleship battleship = new Battleship();
//        Cruiser cruiser = new Cruiser();
//        Destroyer destroyer = new Destroyer();
//        Submarine submarine = new Submarine();
//        battleship.placeShipAt(6, 9, false, ocean);
//        cruiser.placeShipAt(1, 1, true, ocean);
//        destroyer.placeShipAt(1, 6, false,ocean);
//        submarine.placeShipAt(9, 0, false,ocean);
//        Battleship testBattleship = new Battleship();
//        assertEquals(false, testBattleship.okToPlaceShipAt(6, 9, false, ocean));//battleship overlaps with bow of other ships, horizonally and vertically
//        assertEquals(false, testBattleship.okToPlaceShipAt(6, 9, true, ocean));
//        assertEquals(false, testBattleship.okToPlaceShipAt(1, 1, false, ocean));
//        assertEquals(false, testBattleship.okToPlaceShipAt(1, 1, true, ocean));
//        assertEquals(false, testBattleship.okToPlaceShipAt(0, 2, false, ocean));//body of battleship overlaps with body of other ships vertically
//        assertEquals(false, testBattleship.okToPlaceShipAt(0, 2, true, ocean));//body of battleship lies adjacent to other ships
//        assertEquals(false, testBattleship.okToPlaceShipAt(9, 9, false, ocean));//body of battleship lies out of bounds
//        assertEquals(false, testBattleship.okToPlaceShipAt(9, 9, true, ocean));//body of battleship lies out of bounds
//        assertEquals(false, testBattleship.okToPlaceShipAt(8, 1, true, ocean));//bow of battleship is diagonally adjacent to submarine        
//    }
////
////
//    @Test
//    public void testShootAt() {
//    	Battleship battleship = new Battleship();
//        Cruiser cruiser = new Cruiser();
//        Destroyer destroyer = new Destroyer();
//        Submarine submarine = new Submarine();
//        battleship.placeShipAt(6, 9, false, ocean);
//        cruiser.placeShipAt(1, 1, true, ocean);
//        destroyer.placeShipAt(1, 6, false,ocean);
//        submarine.placeShipAt(9, 0, false,ocean);
//        assertEquals(true , battleship.shootAt(6,9));//shoot at the bow
//        assertEquals(true , cruiser.shootAt(1,1));
//        assertEquals(true , destroyer.shootAt(1,6));
//        assertEquals(true , submarine.shootAt(9,0));
//        assertEquals(true , battleship.shootAt(9,9));//shoot at the end of the ship
//        assertEquals(true , cruiser.shootAt(1,3));
//        assertEquals(true , destroyer.shootAt(2,6));
//        assertEquals(false , battleship.shootAt(5,9));//shoot at the adjacent cells around ship
//        assertEquals(false , cruiser.shootAt(0,1));
//        assertEquals(false , cruiser.shootAt(0,9));//shoot nowhere near the ships
//    }

    @Test
    public void testIsSunk() {
    	Battleship battleship = new Battleship();
    	battleship.placeShipAt(6, 9, false, ocean);
    	battleship.shootAt(6, 9);
    	assertEquals(false , battleship.isSunk());
    	assertEquals("S", battleship.toString());
    	battleship.shootAt(9, 9);
    	assertEquals(false , battleship.isSunk());
    	assertEquals("S", battleship.toString());
    	battleship.shootAt(5, 9);
    	assertEquals(false , battleship.isSunk());
    	assertEquals("S", battleship.toString());
    	battleship.shootAt(0, 0);
    	assertEquals(false , battleship.isSunk());
    	assertEquals("S", battleship.toString());
    	battleship.shootAt(8, 9);
    	assertEquals(false , battleship.isSunk());
    	assertEquals("S", battleship.toString());
    	battleship.shootAt(7, 9);
    	assertEquals(true , battleship.isSunk());
    	assertEquals("x", battleship.toString());
    }

//    @Test
//    public void testToString() {
//        fail("Not yet implemented");
//    }

}
