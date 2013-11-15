package battleship;

import java.io.*;
import java.util.Scanner;

public class BattleshipGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
//        String cmd = s.next();
//        while(!cmd.equals("q")){
//            
//            
//            cmd = s.next();
//        }
        System.out.println("Welcome to battleship!");
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        ocean.print();
        while(!ocean.isGameOver()){
            System.out.println("Fire at the ocean, input row:");
            int row = s.nextInt();
            System.out.println("Fire at the ocean, input column:");
            int col = s.nextInt();
            if(ocean.shootAt(row, col)){
                System.out.println("You hit a ship at (" + row + " , " + col + ")!");
            }else{
                System.out.println("You missed.");
            }
            ocean.print();
        }
        System.out.println("Game is over");
        System.out.println("Your final score is " + ocean.getShotsFired());
            
        
    }

}
