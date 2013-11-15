package battleship;

public class Battleship extends Ship {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    // shadowing
    int length = 4;

    @Override
    public int getLength(){
        return this.length;
    }
    
    @Override
    /* get the type */
    public String getShipType(){
        return "battleship";
    }
    
    /* override toString() */
    @Override
    public String toString(){
        if(this.isSunk()){
            return "x";
        }
        return "S";
    }
}
