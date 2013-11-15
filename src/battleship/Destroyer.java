package battleship;

public class Destroyer extends Ship{

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
 // shadowing
    int length = 2;

    @Override
    public int getLength(){
        return this.length;
    }
    
    @Override
    /* get the type */
    public String getShipType(){
        return "destroyer";
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
