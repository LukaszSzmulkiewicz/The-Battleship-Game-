package com.example.java;

/**
 * mirror of the User1 class
 */

public class User2  {

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

    protected boolean user2Hit;

    public void allocateUser2Ships(ShipsGameBase player2) {

        Helper.printTheUserMiddleBoard(player2.user2Board);
        System.out.println();
        System.out.println(player2.user2Marker + ", it is time to allocate your ships on your board!");
        // allocation of the ship size 4
        chooseLocationForTheShip(player2.user2Board, 4, this.fourLengthShipId);
     // allocation for the ship size 3
       System.out.println();
      System.out.println("Now is time to allocate two ships of size 3");
       chooseLocationForTheShip(player2.user2Board, 3, this.threeLenghtShipID1);
          chooseLocationForTheShip(player2.user2Board, 3, this.threeLenghtShipID2);
        System.out.println();
        System.out.println("Now is time to allocate three ships of size 2");
        // allocation for the ship size 2
        chooseLocationForTheShip(player2.user2Board, 2, this.twoLengthShipId1);
        chooseLocationForTheShip(player2.user2Board, 2, this.twoLengthShipId2);
        chooseLocationForTheShip(player2.user2Board, 2, this.twoLengthShipId3);
        System.out.println("Now is time to allocate four ships of size 1");
        // allocation for the ship size 1
        chooseLocationForTheShip(player2.user2Board, 1, this.oneLengthShipID);
        chooseLocationForTheShip(player2.user2Board, 1, this.oneLengthShipID);
        chooseLocationForTheShip(player2.user2Board, 1, this.oneLengthShipID);
        chooseLocationForTheShip(player2.user2Board, 1, this.oneLengthShipID);

        System.out.println();
        System.out.println("Well done " + player2.user2Marker + ", you have successfully allocated all ships on the board ");

    }

    public void chooseLocationForTheShip(String[] userBoard, int theShipLength, String shipID) {
        boolean theFieldIsAvailable = false;
        if (theShipLength > 1){
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
        }else {
            allocateShipSizeOne( userBoard, theShipLength, shipID);
        }
    }
    private void allocateShipSizeOne(String[] userBoard, int theShipLength, String shipID) {
        boolean theFieldIsAvailable = false;
        while (theFieldIsAvailable != true) {
            String fieldChoice = Helper.stringScanner("Please pick the field for your size " + theShipLength + " ship, \n remember the ships can not connect to each other. ");
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

    private String charFieldNumberCheck(String fieldChoice) {
        String fieldChoiceChar = String.valueOf(fieldChoice.charAt(0));
        return fieldChoiceChar;
    }
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

    public void saveTheVerticalChoice(String[] userBoard, String fieldChoice, int theShipLength, String shipID) {

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


    public void user2Shoot (ShipsGameBase game, String shootingAtField){

        if(this.user2Hit=false){
            Helper.printTheUserBackBoard(game.user2Board);

        }else {

        }

        for (int i = 0; i < game.user1Board.length; i += 3) {
            String temp = game.user1Board[i];
            String temp2 = String.valueOf(game.user1Board[i + 1].charAt(0));

            final boolean b = temp.equalsIgnoreCase(shootingAtField) && (temp2.matches("[1234]"));
            if (b) {


                   System.out.println("It's a hit!");
                boolean isTheShipDown = isTheShipDown(game.user1Board, i);
                if (!isTheShipDown) {
                    System.out.println("But, the ship is still swimming!");
                } else {
                    System.out.println("The ship is destroyed");
                }

                    game.user2Board[i + 2] ="@ ";
                game.user1Board[i + 1]= " - " ;
                    game.user2HitCounter++;
                    game.currentMarker = game.user2Marker;
                    Helper.printTheUserBackBoard(game.user2Board);

                 this.user2Hit = true;
                    break;
                } else if (temp.equalsIgnoreCase(shootingAtField) && (!temp2.equalsIgnoreCase("[1234]"))) {

                    game.user2Board[i + 2] = "-";
                    game.currentMarker = game.user1Marker;
                    Helper.printTheUserBackBoard(game.user2Board);
                    System.out.println();
                    System.out.println("You missed!");
                this.user2Hit = false;
                    break;
                }
            }

        }
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
