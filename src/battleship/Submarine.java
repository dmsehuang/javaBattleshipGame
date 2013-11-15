package battleship;

public class Submarine extends Ship{

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
 // shadowing
    int length = 1;

    @Override
    public int getLength(){
        return this.length;
    }

    @Override
    /* get the type */
    public String getShipType(){
        return "submarine";
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
