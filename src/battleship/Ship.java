package battleship;

public class Ship {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal;
    boolean [] hit = new boolean[4]; // different type use different array length
    String name = "ship";
    
    /* getter */
    /* return the row of the bow*/
    int getBowRow(){ 
        return this.bowRow;
    }    
    /* return the column of the bow*/
    int getBowColumn(){ 
        return this.bowColumn;
    }  
    /* return if the ship is horizontal or not */
    boolean isHorizontal(){ 
        return this.horizontal;
    }
    
    /* setter */
    /* set the bow row */
    void setBowRow(int row){ 
        this.bowRow = row;
    }
    /* set the bow column */
    void setBowColumn(int column){ 
        this.bowColumn = column;
    }
    /* set the horizontal */
    void setHorizontal(boolean horizontal){ 
        this.horizontal = horizontal;
    }  

    
    /* to be overwritten */
    /* get the length */
    public int getLength(){ 
        return 1;
    }
    /* get the type */
    String getShipType(){ 
        return "Ship"; 
    }
    
    /* if it's okay to place ship at this location */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
//        System.out.println("check ok to place");
        // check if the bow is out of bound
        if((row < 0 || row > 10) || (column < 0 || column > 10)){
            return false;
        }
        int horiUpperBound;
        int vertUpperBound;
        if(horizontal){
            horiUpperBound = this.getLength() + 1;
            vertUpperBound = 2;
        }
        else{
            horiUpperBound = 2;
            vertUpperBound = this.getLength() + 1;
        }
        for(int i = -1; i < horiUpperBound; i++){
            for(int j = -1; j < vertUpperBound; j++){
                int currRow = row + j;
                int currCol = column + i;
                if((currRow < -1 || currRow > 10)||(currCol < -1 || currCol > 10)){
                    // check if out of bound
                    return false;
                }else{
                    if((currRow >=0 && currRow < 10) && (currCol >=0 && currCol < 10)){
                        // valid index
//                        System.out.println("(" + currRow + " , " + currCol + ")");
                        if(ocean.isOccupied(currRow, currCol)){
                            // check if overlap and adjacency
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /* place ship at */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
        int horiUpperBound;
        int vertUpperBound;
        if(horizontal){
            horiUpperBound = this.getLength();
            vertUpperBound = 1;
        }
        else{
            horiUpperBound = 1;
            vertUpperBound = this.getLength();
        }
        for(int i = 0; i < horiUpperBound; i++){
            for(int j = 0; j < vertUpperBound; j++){
                int currRow = row + j;
                int currCol = column + i;
                if(currRow < 0 || currCol < 0){
                	System.out.println("out of bounds");
                }
                // should use the getter
                ocean.getShipArray()[currRow][currCol] = this;
                this.setBowRow(row);
                this.setBowColumn(column);
                this.setHorizontal(horizontal);
            }
        }
    }
    
    /* whether the ship is hit or not */
    boolean shootAt(int row, int column){
        if(this.isSunk()){
            return false;
        }
        if(this.isHorizontal()){
            for(int j = 0; j < this.getLength(); j++){
//            	System.out.println(this.bowRow + "," + this.bowColumn + j);
//            	System.out.println(row + "," + column);
                if(this.bowRow == row && column == j + this.bowColumn){
                    hit[j] = true;
                    return true;
                }
            }
        }
        else{
            for(int i = 0; i < this.getLength(); i++){
//            	System.out.println(i + this.bowRow + "," + this.bowColumn);
//            	System.out.println(row + "," + column);
                if(this.bowColumn == column && row == i + this.bowRow){
                    hit[i] = true;
                    return true;
                }
            }
        }
        System.out.println("none of the conditions work");
        return false;
    }
    
    /* whether the ship is sunk or not */
    boolean isSunk(){
        for(int i = 0; i < this.getLength(); i++){
            if(!hit[i]){
//                System.out.println("hit[" + i + "]=" + hit[0]);
                return false;
            }
        	System.out.println("You just sank a " + this.getShipType());
        }
        
        return true;
    }
    
    @Override
    public String toString(){
    	return super.toString();
//        if(this.isSunk()){
//            return "x";
//        }else{
//            // shoot at ?
//            return "S";
//        }
    }
}
