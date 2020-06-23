package com.example.java;



import javax.jws.soap.SOAPBinding;
import java.util.Scanner;
import java.util.SortedMap;

/**
 * Program - the ships game for two players, each one has 10 ships of 4 different sizes.
 */

public class Main {
    /**
     * The main method, it contains the ShipsGameBase object, two player objects and while loop responsible for running
     * the game and assigning the player turn based on the hit or miss.
     * @param args
     */

    public static void main(String[] args) {

        String a = Helper.stringScanner("Please provide the Player1 name: ");
        String b = Helper.stringScanner("Please provide the Player2 name: ");
        ShipsGameBase theGame = new ShipsGameBase(a,b);

           User1 player1 = new User1();
             player1.allocateUser1Ships(theGame);

             User2 player2 = new User2();
             player2.allocateUser2Ships(theGame);


          while (!theGame.isThereAwinner()) {
               if (theGame.currentMarker == theGame.user1Marker) {
                   if(!player1.user1Hit){

                       Helper.printTheUserBackBoard(theGame.user1Board);
                   }

                   String haveAshot = Helper.stringScanner(theGame.currentMarker + " It's your turn, shoot!");

                   player1.user1Shoot(theGame, haveAshot);


               } else {
                   if(!player2.user2Hit){

                       Helper.printTheUserBackBoard(theGame.user2Board);
                   }

                   String haveAshot = Helper.stringScanner(theGame.user2Marker + " It's your turn, shoot!");

                   player2.user2Shoot(theGame, haveAshot);


               }
           }


    }
}
