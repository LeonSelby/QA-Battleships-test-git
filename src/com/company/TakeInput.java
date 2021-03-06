package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {

    static public Scanner sc = new Scanner(System.in);

    //Input
    static public String takeNextLine() {
        return sc.nextLine();
    }

    static public int takeNextInt() {
        boolean badInput = true;
        int tmp = 0;
        while (badInput) {
            try {
                tmp = Integer.parseInt(sc.nextLine());
                badInput = false;
            } catch (InputMismatchException var3) {
                needIntPlease();
            } catch (NumberFormatException var4) {
                needIntPlease();
            }
        }
        return tmp;
    }

    static public int takeNextIntInRange(int min, int max) {
        boolean badInput = true;
        int tmp = 0;

        while (badInput) {
            try {
                tmp = Integer.parseInt(sc.nextLine());

                if (tmp > max || tmp < min) {
                    needIntInRange(min, max);
                    tmp = Integer.parseInt(sc.nextLine());
                } else
                    badInput = false;
            } catch (InputMismatchException var3) {
                needIntInRange(min, max);
            } catch (NumberFormatException var4) {
                needIntInRange(min, max);
            }
        }
        return tmp;
    }


    static public int requestInput(String question) {
        System.out.println(question);
        int ans = takeNextInt();
        return ans;
    }

    static public int requestInputInRange(String question, int min, int max) {
        System.out.println(question);
        int ans = takeNextIntInRange(min, max);
        return ans;
    }

    static public int requestInputInRange(String question, int max) {
        System.out.println(question);
        int ans = takeNextIntInRange(0, max);
        return ans;
    }

    static public boolean requestYesOrNo(String question) {
        System.out.println(question);
        boolean isYes = false;
        boolean answerNotGiven = true;
        while (answerNotGiven) {
            switch (TakeInput.takeNextLine().toLowerCase()) {
                case "yes":
                case "y":
                    isYes = true;
                    answerNotGiven = false;
                    break;
                case "no":
                case "n":
                    isYes = false;
                    answerNotGiven = false;
                    break;
                default:
                    TakeInput.needYesOrNo();
                    System.out.println(question);
                    break;
            }
        }
        return isYes;
    }


    //Questions

    static public String askIfAiGame() {
        return "Do you want to play vs the AI?";
    }

    static public String askIfSoloAiGame(){
        return "Do you want to try shoot only mode?";
    }

    static public String askForBoardSize() {
        return "How many rows and columns would you like the board to have?\n Please enter a number.";
    }

    static public String askForGuess(String colOrRow) {
        return "Which " + colOrRow + " do you want to try?";
    }

    static public String askForShipAmount() {
        return "How many ships do you want each player to have?";
    }

    static public String askForShipSize(boolean isFirst) {
        String tmp;
        if (isFirst) {
            tmp = "What size ship would you like first?";
        } else {
            tmp = "What size ship would you like next?";
        }
        return tmp;
    }

    static public String askForShipSizeLast() {
        return "What size ship would you like last?";
    }

    //Statements
    static public String welcomeMessage() {
        return "Welcome to QA Battleships!";
    }

    static public String guessResponse(String hitOrMiss) {
        return "That was a " + hitOrMiss + "!";
    }

    static public String youSunk(Ship ship) {
        return "You sunk " + ship.getName() + "!";
    }

    /**1 or 2 or AI*/
    static public String resultString(String p12orAI) {
        String tmp;
        if (p12orAI.equalsIgnoreCase("1")) {
            tmp = "Player one wins!";
        } else if (p12orAI.equalsIgnoreCase("2")) {
            tmp = "Player two wins!";
        } else {
            tmp = "The computer wins, better luck next time!";
        }
        return tmp;
    }

    static public String stateGrade(Grade grade) {
        String tmp;
        if (grade == Grade.S) {
            tmp = "You earned an " + grade + " ranking! That's a perfect score!";
        } else if (grade == Grade.A) {
            tmp = "You earned an " + grade + " ranking!";
        } else {
            tmp = "You earned a " + grade + " ranking!";
        }
        return tmp;
    }

    //Errors
    static private void needIntPlease() {
        System.out.println("We're sorry! Please input a number!");
    }

    static public void intToHigh(int cap) {
        System.out.println("We're sorry that number is too high! Please give a number below "+cap+".");
    }

    static public void needIntInRange(int min, int max) {
        System.out.printf("We're sorry! Please input a number between " + min + " and " + max + ".");
    }

    static public void needYesOrNo() {
        System.out.println("We're sorry! Please enter yes or no, y or n is accepted also.");
    }
}
