package battleship;

public class EmptySea extends Ship{

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /* Constructor */
    public EmptySea(){
        super();
        this.length = 1;
    }
    
    
    /* get the type */
    @Override
    public String getShipType(){
        return "empty sea";
    }
    
    /* Override shootAt method */
    @Override
    boolean shootAt(int row, int column){
        if(this.bowRow == row && this.bowColumn == column){
            // update the hit array for empty sea
            this.hit[0] = true;
        }
        return false;
    }
    
    /* Override isSunk method */
    @Override
    boolean isSunk(){
        return false;
    }
    
    /* Override toString method used in Ocean */
    @Override
    public String toString(){
        if(hit[0]){
            return "-";
        }else{
            return ".";
        }
    }
}
