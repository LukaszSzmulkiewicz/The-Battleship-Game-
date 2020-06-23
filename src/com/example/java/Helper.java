package com.example.java;

import java.util.Scanner;

/**
 * a Helper class with methods used to print all user boards
 */

public class Helper {

    /**
     *  Static string array used to store the row values
     */

    public static String[] verticalValues = {"A", "B", "C", "D", "E","F", "G", "H", "I", "J"};


    public static String stringScanner(String message){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String result = sc.next().toUpperCase();
         return result;
    }

    public static int intScanner(String message){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        int result = sc.nextInt();
        return result;
    }

    public static void printTheStandardBoard(){
        String[] user2toUser1Board = new String[300];
        String[] verticalValues = Helper.verticalValues;


        int counter = 0;
        for (int i = 0; i < user2toUser1Board.length; i += 30) {
            int innerCounter = 0;

            for (int j = 0; j < verticalValues.length; j++) {
                String temp;
                temp = verticalValues[counter] + Integer.toString(j + 1);
                ;
                user2toUser1Board[i + innerCounter] = temp;
                innerCounter += 3;
            }
            counter++;
        }

        System.out.println();
        for (int i = 0; i < user2toUser1Board.length; i += 3) {
            if (i % 30 == 0 && i != 0) {
                System.out.println();
                System.out.println("----------------------------------------------------");
            }
            System.out.print(" | " + user2toUser1Board[i]);
        }
        System.out.println();

    }
    public static void printTheUserMiddleBoard(String [] userBoard){
        System.out.println();
        for (int i = 1; i < userBoard.length; i+=3) {
            if ((i-1) % 30 == 0 && i != 0) {
                System.out.println();
                System.out.println("----------------------------------------------------");
            }
            System.out.print(" | " + userBoard[i]);
        }
        System.out.println();

    }

    public static void printTheUserBackBoard(String [] userBoard){

        for (int i = 2; i < userBoard.length; i+=3) {
            if ((i-2) % 30 == 0 && i != 0) {
                System.out.println();
                System.out.println("----------------------------------------------------");
            }
            System.out.print(" | " + userBoard[i]);
        }
        System.out.println();

    }

}
