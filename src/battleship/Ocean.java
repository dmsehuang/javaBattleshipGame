package battleship;

import java.util.Random;

public class Ocean {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    Ship[][] ships = new Ship[10][10]; // array of ship
    int shotsFired; // total number of shots
    int hitCount; // count the hit even if hit the same part of the ship
    int shipsSunk; // number of sunk ships

    
    /* Constructor */
    public Ocean(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.ships[i][j] = new EmptySea();
                this.ships[i][j].setBowRow(i);
                this.ships[i][j].setBowColumn(j);
            }
        }
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
    }

    /* Place the ships randomly and legally */
    void placeAllShipsRandomly(){
        Random generator = new Random();
        int randomRow = generator.nextInt(10);
        int randomCol = generator.nextInt(10);
        boolean isHorizontal = generator.nextBoolean();
        // place the battle ship
        Battleship battleship = new Battleship();
        battleship.setBowRow(randomRow);
        battleship.setBowColumn(randomCol);
        battleship.setHorizontal(isHorizontal);
        while(!battleship.okToPlaceShipAt(randomRow, randomCol, isHorizontal, this)){
            randomRow = generator.nextInt(10);
            randomCol = generator.nextInt(10);
            isHorizontal = generator.nextBoolean();
        }
//        System.out.println("battleship random row: " + randomRow + "column: " + randomCol);
        battleship.placeShipAt(randomRow, randomCol, isHorizontal, this);
        // place two cruisers
        for(int i = 0; i < 2; i++){
            Cruiser cruiser = new Cruiser();
            cruiser.setBowRow(randomRow);
            cruiser.setBowColumn(randomCol);
            cruiser.setHorizontal(isHorizontal);
            while(!cruiser.okToPlaceShipAt(randomRow, randomCol, isHorizontal, this)){
                randomRow = generator.nextInt(10);
                randomCol = generator.nextInt(10);
                isHorizontal = generator.nextBoolean();
            }
//            System.out.println("cruiser random row: " + randomRow + "column: " + randomCol);
            cruiser.placeShipAt(randomRow, randomCol, isHorizontal, this);
        }
        // place three destroyers
        for(int i = 0; i < 3; i++){
            Destroyer destroyer = new Destroyer();
            destroyer.setBowRow(randomRow);
            destroyer.setBowColumn(randomCol);
            destroyer.setHorizontal(isHorizontal);
            while(!destroyer.okToPlaceShipAt(randomRow, randomCol, isHorizontal, this)){
                randomRow = generator.nextInt(10);
                randomCol = generator.nextInt(10);
                isHorizontal = generator.nextBoolean();
            }
//            System.out.println("destroyer random row: " + randomRow + "column: " + randomCol);
            destroyer.placeShipAt(randomRow, randomCol, isHorizontal, this);
        }
        // place four submarine
        for(int i = 0; i < 4; i++){
            Submarine submarine = new Submarine();
            submarine.setBowRow(randomRow);
            submarine.setBowColumn(randomCol);
            submarine.setHorizontal(isHorizontal);
            while(!submarine.okToPlaceShipAt(randomRow, randomCol, isHorizontal, this)){
                randomRow = generator.nextInt(10);
                randomCol = generator.nextInt(10);
                isHorizontal = generator.nextBoolean();
            }
//            System.out.println("submarine random row: " + randomRow + "column: " + randomCol);
            submarine.placeShipAt(randomRow, randomCol, isHorizontal, this);
        }  
    }
    
    /* if a given location is occupied with a ship */
    boolean isOccupied(int row, int column){
        // check if the ship is empty sea
//        System.out.println("row: " + row + "col: " + column);
        if(this.ships[row][column].getShipType().equals("empty sea")){
            return false;
        }else{
            return true;
        }
    }
    
    /* if shooting at at real ship */
    boolean shootAt(int row, int column){
        this.shotsFired ++;
        if(this.ships[row][column].getShipType().equals("empty sea")){
            return this.ships[row][column].shootAt(row, column);
        }else{
            // when a ship sinks, makes corresponding ships[i][j] a type of "empty sea"
            this.hitCount ++;
            if(this.ships[row][column].isSunk()){
                this.ships[row][column] = new EmptySea();
            }
            return true;
        }
    }
    
    /* return the number of shots */
    int getShotsFired(){
        return this.shotsFired;
    }
    
    /* return the number of hits */
    int getHitCount(){
        return this.hitCount;
    }
    
    /* return the number of sunk ships */
    int getShipsSunk(){
        return this.shipsSunk;
    }
    
    /* check whether the game is over */
    boolean isGameOver(){
        if(this.shipsSunk == 10){
            return true;
        }else{
            return false;
        }
    }
    
    /* return the ship array */
    Ship[][] getShipArray(){
        return this.ships;
    }
    
    /* print the ocean */
    void print(){
        // print column index
        for(int l = 0; l < 10; l++){
            System.out.print("\t" + l);
        }
        System.out.print('\n');
        // print row index and status of the game
        for(int i = 0; i < 10; i++){
            System.out.print(i);
            for(int j = 0; j < 10; j++){
                // have already override the toString() method
//                if(this.shootAt(i, j)){
//                    System.out.print('\t' +  this.ships[i][j].toString());
//                }
//                else{
//                    System.out.print('\t');
//                }
//            	if(this.shootAt(i,j)){
            		System.out.print("\t" +  this.ships[i][j].toString());
//            	}
//            	else{
//            		System.out.println("\t" + ((EmptySea)this.ships[i][j]).toString());
//            	}
            }
            System.out.print('\n');
        }
    }
    
}
