package com.example.java;

/**
 * The ShipsGameBase class, it contains user board fields, player marker fields, individual
 * hit counters and methods responsible for populating the boards.
 */
public class ShipsGameBase {

    /**
     * class fields
     */

    protected String[] user1Board;
    protected String[] user2Board;

    protected String user1Marker;
    protected String user2Marker;
    protected int winner =20;
    protected String currentMarker;

    protected int user1HitCounter=0;
    protected int user2HitCounter=0;



    public ShipsGameBase(){}

    /**
     * constructor of the class, the constructor takes two player names and populates two arrays of strings size 300 with
     * values from A1 to J10
     */

    public ShipsGameBase(String player1Token, String player2Token) {

        this.user1Board = userBoardSetUp();
        this.user2Board = userBoardSetUp();
        this.user1Marker = player1Token;
        this.user2Marker = player2Token;
        this.currentMarker = user1Marker;
    }

    /**
     * method responsible for populating 2 x user boards of size 300, with A1 to J10 values via internal method
     * @return returns array of strings
     */
    public String[] userBoardSetUp() {
       String [] userBoard =  new String[300];
        createTheGameUserBoard(userBoard);


        return userBoard;
    }

    /**method used to populate user boards, the arrays are populated with a new value every 3 fields, index 0 field is used
     * for the field name reference, index 1 is used for the user ships and the index 2 is used for the user shots at
     * the opponents ships.
     *
     * @param userBoard
     */
    public void createTheGameUserBoard(String[] userBoard) {

        String[] verticalValues = Helper.verticalValues;
        int numberOfBoards =0;

        while (numberOfBoards <3) {
            int counter = 0;


            for ( int i = numberOfBoards; i < userBoard.length; i += 30) {
                int innerCounter = 0;

                for (int j = 0; j < verticalValues.length; j++) {
                    String temp;
                    temp = verticalValues[counter] + Integer.toString(j + 1);
                    ;
                    userBoard[i + innerCounter] = temp;
                    innerCounter += 3;
                }
                counter++;
            }
            numberOfBoards++;
        }
    }

    /**
     * method responsible for determining if the game has a winner, it is achieved by hit counter check
     * @return the winner's name
     */

     public boolean isThereAwinner(){
            boolean isThereAvinner = false;
        if ((user1HitCounter == this.winner)|| (user2HitCounter == this.winner) ) {
            String result = "Well done " + this.currentMarker + " you are the winner! ";
            System.out.println();
            System.out.println(result);
            isThereAvinner = true;
        }
         return isThereAvinner;
     }



}
