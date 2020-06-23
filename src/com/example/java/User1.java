package com.example.java;


/**
 * player 1 class, it contains the ship fields with the ship id's and their hit counters. It also contains the methods
 * that allow user to allocate the ships and shot at the opponent ships
 */

public class User1 extends ShipsGameBase {

    protected String fourLengthShipId = "4 ";
    protected  int fourLengthShipCount =0;

    protected String threeLenghtShipID1 = "31";
    protected  int threeLenghtShipID1Count =0;

    protected String threeLenghtShipID2 = "32";
    protected  int threeLenghtShipID2Count =0;

    protected String  twoLengthShipId1="21";
    protected  int twoLenghtShipID1Count =0;

    protected String  twoLengthShipId2="22";
    protected  int twoLenghtShipID2Count =0;

    protected String  twoLengthShipId3="23";
    protected  int twoLenghtShipID3Count = 0;

    protected String oneLengthShipID="1";
    protected boolean user1Hit;

    public User1() {

    }

    /**
     *  method used for the player 1 ship allocation, it accepts the ShipGameBase object as a parameter, the allocation is
     *  achieved through chooseLocationForTheShip method
     * @param player1
     */

    public void allocateUser1Ships(ShipsGameBase player1) {

        Helper.printTheUserMiddleBoard(player1.user1Board);
        System.out.println();
        System.out.println(player1.user1Marker + ", it is time to allocate your ships on your board!");
        // allocation of the ship size 4
        chooseLocationForTheShip(player1.user1Board, 4, this.fourLengthShipId);
       // allocation for the ship size 3
        System.out.println();
        System.out.println("Now is time to allocate two ships of size 3");
        chooseLocationForTheShip(player1.user1Board, 3, this.threeLenghtShipID1);
        chooseLocationForTheShip(player1.user1Board, 3, this.threeLenghtShipID2);
        System.out.println();
        System.out.println("Now is time to allocate three ships of size 2");
        // allocation for the ship size 2
        chooseLocationForTheShip(player1.user1Board, 2, this.twoLengthShipId1);
        chooseLocationForTheShip(player1.user1Board, 2, this.twoLengthShipId2);
        chooseLocationForTheShip(player1.user1Board, 2, this.twoLengthShipId3);
        System.out.println("Now is time to allocate four ships of size 1");
        // allocation for the ship size 1
        chooseLocationForTheShip(player1.user1Board, 1, this.oneLengthShipID);
        chooseLocationForTheShip(player1.user1Board, 1, this.oneLengthShipID);
        chooseLocationForTheShip(player1.user1Board, 1, this.oneLengthShipID);
        chooseLocationForTheShip(player1.user1Board, 1, this.oneLengthShipID);

        System.out.println();
        System.out.println("Well done " + player1.user1Marker + ", you have successfully allocated all ships on the board ");

    }

    /**
     * the method asks the user for a vertical or horizontal choice, then based on the ship size determines if the starting
     * field entered by the user is within the board range. Then the method saves the user's choice.
     * @param userBoard - array of strings
     * @param theShipLength - an integer ship size
     * @param shipID - string value
     */

    public void chooseLocationForTheShip(String[] userBoard, int theShipLength, String shipID) {
        boolean theFieldIsAvailable = false;
        if (theShipLength > 1) {
            while (theFieldIsAvailable != true) {
                String fieldChoice = Helper.stringScanner("Please pick the starting field for your size " + theShipLength + " ship! \n " +
                        "Remember! The ships can not connect to each other. ");
                int verOrHorChoice = Helper.intScanner("Type 1 for a vertical placement and 2 for a horizontal");
                if (verOrHorChoice == 1) {
                    theFieldIsAvailable = verticalFieldChoiceCheck(userBoard, fieldChoice, theShipLength);
                    if (theFieldIsAvailable) {
                        saveTheVerticalChoice(userBoard, fieldChoice, theShipLength, shipID);
                        theFieldIsAvailable = true;
                    } else {
                        System.out.println();
                        System.out.println("The field you entered is invalid, please try again!");
                        theFieldIsAvailable = false;
                    }
                } else if (verOrHorChoice == 2) {
                    theFieldIsAvailable = horizontalFieldChoiceCheck(userBoard, fieldChoice, theShipLength);
                    if (theFieldIsAvailable) {
                        saveTheHorizontalBoard(userBoard, fieldChoice, theShipLength, shipID);
                        theFieldIsAvailable = true;
                    } else {
                        System.out.println();
                        System.out.println("The field you entered is invalid, please try again!");
                        theFieldIsAvailable = false;
                    }
                }

            }
        } else {
            allocateShipSizeOne(userBoard, theShipLength, shipID);
        }
    }

    /**
     * the method is used for size one ships allocation
     * @param userBoard
     * @param theShipLength
     * @param shipID
     */

    private void allocateShipSizeOne(String[] userBoard, int theShipLength, String shipID) {
        boolean theFieldIsAvailable = false;
        while (!theFieldIsAvailable) {
            String fieldChoice = Helper.stringScanner("Please pick the field for your size " + theShipLength + " ship! \n Remember! " +
                    "The ships can not connect to each other. ");
            theFieldIsAvailable = verticalFieldChoiceCheck(userBoard, fieldChoice, theShipLength);
            if (theFieldIsAvailable) {
                saveTheVerticalChoice(userBoard, fieldChoice, theShipLength, shipID);
                theFieldIsAvailable = true;
            } else {
                System.out.println();
                System.out.println("The field you entered is invalid, please try again!");
                theFieldIsAvailable = false;
            }
        }
    }

    /**
     * the method determines if the user's choice is within the range
     * @param userBoard - array of strings
     * @param fieldChoice - string value entered through a scanner object
     * @param theShipLength - integer value
     * @return
     */

    public boolean verticalFieldChoiceCheck(String[] userBoard, String fieldChoice, int theShipLength) {
        boolean isValid = false;

        String charFieldChoice = charFieldNumberCheck(fieldChoice);
        int verticalIntFieldChoice = verticalIntFieldChoice(charFieldChoice);

        for (int i = 1; i < userBoard.length; i += 3) {
            String temp = userBoard[i];
            if (temp.equalsIgnoreCase(fieldChoice) && (verticalIntFieldChoice + (theShipLength - 1) <= 10)) {
                isValid = true;
                return isValid;
            }
        }
        return isValid;
    }

    /**
     * method returns a first character of the user's choice used for a user board row identification
     * @param fieldChoice
     * @return
     */

    private String charFieldNumberCheck(String fieldChoice) {
        String fieldChoiceChar = String.valueOf(fieldChoice.charAt(0));
        return fieldChoiceChar;
    }

    /**
     *  method used for the vertical placement validation, it assigns value to the row letter and returns an integer
     *  value that is used in the verticalFieldChoiceCheck to validate the field choice
     * @param charFieldChoice
     * @return integer value
     */

    private int verticalIntFieldChoice(String charFieldChoice) {
        int verticalIntFieldChoice = 0;
        switch (charFieldChoice) {
            case "G":
                verticalIntFieldChoice = 7;
                break;
            case "H":
                verticalIntFieldChoice = 8;
                break;
            case "I":
                verticalIntFieldChoice = 9;
                break;
            case "J":
                verticalIntFieldChoice = 10;
                break;
        }
        return verticalIntFieldChoice;
    }


    /**
     * method used to save the vertical choice
     * @param userBoard
     * @param fieldChoice
     * @param theShipLength
     * @param shipID
     */
    public void saveTheVerticalChoice(String[] userBoard, String fieldChoice, int theShipLength, String shipID) {
        System.out.println(theShipLength);
        for (int i = 1; i < userBoard.length; i += 3) {
            String temp = userBoard[i];
            if (temp.equalsIgnoreCase(fieldChoice)) {

                for (int j = i; j < userBoard.length; j += 30) {

                    theShipLength--;
                    userBoard[j] = shipID;

                    if (theShipLength == 0) {
                        Helper.printTheUserMiddleBoard(userBoard);
                        break;
                    }

                }

            }
        }
    }

    /**
     * method used to validate the horizontal choice
     * @param userBoard
     * @param fieldChoice
     * @param theShipLength
     * @return
     */

    public boolean horizontalFieldChoiceCheck(String[] userBoard, String fieldChoice, int theShipLength) {
        boolean isValid = false;

        char secondChar = fieldChoice.charAt(1);
        int fieldNumberCheck = Integer.parseInt(String.valueOf(secondChar));
        if (fieldChoice.length() == 3) {
            fieldNumberCheck = 10;
        }
        for (int i = 1; i < userBoard.length; i += 3) {
            String temp = userBoard[i];
            if (temp.equalsIgnoreCase(fieldChoice) && (fieldNumberCheck + theShipLength <= 11)) {
                isValid = true;
            }
        }

        return isValid;

    }

    /**
     * method used to save the horizontal choice
     * @param userBoard
     * @param fieldChoice
     * @param theShipLength
     * @param shipID
     */

    public void saveTheHorizontalBoard(String[] userBoard, String fieldChoice, int theShipLength, String shipID) {
        for (int i = 1; i < userBoard.length; i += 3) {
            String temp = userBoard[i];
            if (temp.equalsIgnoreCase(fieldChoice.toUpperCase())) {
                for (int j = i; j < userBoard.length; j += 3) {
                    theShipLength--;
                    userBoard[j] = shipID;
                    if (theShipLength == 0) {
                        Helper.printTheUserMiddleBoard(userBoard);
                        break;
                    }
                }
            }
        }
    }

    /**
     * the method is used for shooting, it checks the other player board and records the result on the user board
     * index 2. The method takes the ShipsGameBase object and string entered by the user into the scanner object
     * @param game - ShipsGameBase class object
     * @param shootingAtField - string value
     */

    public void user1Shoot(ShipsGameBase game, String shootingAtField) {

        if(this.user1Hit=false){
            Helper.printTheUserBackBoard(game.user1Board);
        }else {

        }

        for (int i = 0; i < game.user2Board.length; i += 3) {
            String temp = game.user2Board[i];
            String temp2 = String.valueOf(game.user2Board[i + 1].charAt(0));

            final boolean b = temp.equalsIgnoreCase(shootingAtField) && (temp2.matches("[1234]"));
            if (b) {

                System.out.println("It's a hit!");
                this.user1Hit=true;
                boolean isTheShipDown = isTheShipDown(game.user2Board, i);
                if (!isTheShipDown) {
                    System.out.println("But, the ship is still swimming!");
                } else {
                    System.out.println("The ship is destroyed");
                }

                game.user1Board[i + 2] = "@ ";
                game.user2Board[i + 1] = "- ";
                game.user1HitCounter++;
                game.currentMarker = game.user1Marker;
                Helper.printTheUserBackBoard(game.user1Board);

                break;
            } else if (temp.equalsIgnoreCase(shootingAtField) && (!temp2.equalsIgnoreCase("[1234]"))) {

                game.user1Board[i + 2] = "- ";
                game.currentMarker = game.user2Marker;
                Helper.printTheUserBackBoard(game.user1Board);
                System.out.println();
                System.out.println("You missed!");
                this.user1Hit = false;
                break;
            }
        }

    }

    /**
     * the method is used to check if the ship is destroyed, it checks the ship id on the opponent board and increments
     * the ship hit counter accordingly and returns a "is the ship down" boolean value.
     * @param userBoard
     * @param i - integer value, array index of the user's shot
     * @return - boolean value
     */

    public boolean isTheShipDown(String[] userBoard, int i) {
        boolean isTheShipDown = false;
        String shipIdCheck = userBoard[i+1];

        switch (shipIdCheck){
            case "4 ":
                this.fourLengthShipCount++;
                if(this.fourLengthShipCount==4){
                    isTheShipDown = true;

                }else {
                    isTheShipDown = false;
                }
                break;
            case "31":
                this.threeLenghtShipID1Count++;
                if(this.threeLenghtShipID1Count==3){
                    isTheShipDown = true;
                }else {
                    isTheShipDown = false;
                }
                break;
            case "32":
                this.threeLenghtShipID2Count++;
                if(this.threeLenghtShipID2Count==3){
                    isTheShipDown = true;
                }else {
                    isTheShipDown = false;
                }
                break;
            case "21":
                this.twoLenghtShipID1Count++;
                if(this.twoLenghtShipID1Count==2){
                    isTheShipDown = true;
                }else {
                    isTheShipDown = false;
                }
                break;
            case "22":
                this.twoLenghtShipID2Count++;
                if(this.twoLenghtShipID1Count==2){
                    isTheShipDown = true;
                }else {
                    isTheShipDown = false;
                }
                break;
            case "23":
                this.twoLenghtShipID3Count++;
                if(this.twoLenghtShipID3Count==2){
                    isTheShipDown = true;
                }else {
                    isTheShipDown = false;
                }
                break;
            case "1":
                isTheShipDown = true;
                break;

        }

        return isTheShipDown;
    }


}
