import java.util.Random;
import java.util.Scanner;


public class Main {

    static Scanner scan = new Scanner(System.in);
    static boolean oneOrTwo = true;

    static int[] scoreThroughoutRounds = new int[2];
    static String playerOne;
    static String playerTwo;


    public static void plentySpace() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n\n\n\n\n\n");
        }
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min + 1) + 1);
    }

    public static boolean theGameMechanics(int playerOneInput, int playerTwoInput) {
        if (playerOneInput == 1 && playerTwoInput == 3 || playerOneInput == 2 && playerTwoInput == 1 || playerOneInput == 3 && playerTwoInput == 2) {
            scoreThroughoutRounds[0] += 1;
            return true;
        } else {
            scoreThroughoutRounds[1] += 1;
            return false;
        }
    }

    public static String whoWonTheRoundSin(boolean resultOfRound) {
        if (resultOfRound) {
            return playerOne;
        } else {
            return "I";
        }
    }

    public static String whoWonTheRoundMul(boolean resultOfRound) {
        if (resultOfRound) {
            return playerOne;
        } else {
            return playerTwo;
        }
    }

    public static void rpsPrompt(String player) {
        System.out.println("\n" + player + ": |----------------------------------------|");
        System.out.println("\t\t\tRock\t\t-\t\tPress 1");
        System.out.println("\t\t\tPaper\t\t-\t\tPress 2");
        System.out.println("\t\t\tScissor\t\t-\t\tPress 3\n");
    }


    public static void coreGameSetup() {
        System.out.println("It works like this. The core game consists of three rounds.");
        System.out.println("Out of these three rounds, you're able to either win, lose or draw.");
    }

    public static void singleplayerPrompt() {

        System.out.print("\nType in name of player: ");
        playerOne = scan.nextLine();
    }

    public static void multiplayerPrompt() {

        System.out.print("\nType in the name of player 1: ");
        playerOne = scan.nextLine();

        System.out.print("Type in the name of player 2: ");
        playerTwo = scan.nextLine();
    }


    public static void singleplayerMode() {

        //Name input
        singleplayerPrompt();
        System.out.println("\n\nHello " + playerOne + "\n");

        //Singleplayer setup
        coreGameSetup();
        System.out.println("You start out by choosing either rock, paper or scissor.");
        System.out.println("Then it's my turn to do the same.");
        System.out.println("After both of us have made our choice");
        System.out.println("the result of that round is displayed");
        System.out.println("and the following round commences.\n");

        //How many rounds?
        System.out.println("How many rounds would you like to play?\n");
        int wishedNumberOfRounds = scan.nextInt();

        //The game - singleplayer
        for (int i = 0; i < wishedNumberOfRounds; i++) {
            rpsPrompt(playerOne);
            int rpsRoundXPlayerOne = scan.nextInt();
            plentySpace();
            rpsPrompt("Me");
            int rpsRoundXComputer = getRandomInt(1, 3);
            if (rpsRoundXPlayerOne == rpsRoundXComputer) {
                System.out.println("\nThis round was a draw");
                for (int j = 0; j < 1; j++) {
                    scoreThroughoutRounds[0] += 1;
                    scoreThroughoutRounds[1] += 1;
                }
            } else {
                boolean resultOfRound = theGameMechanics(rpsRoundXPlayerOne, rpsRoundXComputer);
                String whichPlayerWonRound = whoWonTheRoundSin(resultOfRound);
                System.out.println("\n" + whichPlayerWonRound + " won this round");
            }

        }

        //Results
        if (scoreThroughoutRounds[0] == scoreThroughoutRounds[1]) {
            System.out.println("\nThis game was a draw");
        } else if (scoreThroughoutRounds[0] > scoreThroughoutRounds[1]) {
            System.out.println("\n" + playerOne + " won this game");
        } else {
            System.out.println("\nI won this game");
        }

    }

    public static void multiplayerMode() {

        //Name input
        multiplayerPrompt();
        System.out.println("\nWelcome " + playerOne + " and " + playerTwo + "\n");

        //Multiplayer setup
        coreGameSetup();
        System.out.println("Player one, which in this case is " + playerOne);
        System.out.println("starts out by choosing either rock, paper or scissor.");
        System.out.println("Then player two, which in this case is " + playerTwo);
        System.out.println("proceeds to do the same.");
        System.out.println("After both players have made their choice,");
        System.out.println("the result of that round is displayed");
        System.out.println("and the following round commences.\n");

        //How many rounds?
        System.out.println("How many rounds would you like to play?\n");
        int wishedNumberOfRounds = scan.nextInt();

        //The game - multiplayer
        for (int i = 0; i < wishedNumberOfRounds; i++) {
            rpsPrompt(playerOne);
            int rpsRoundXPlayerOne = scan.nextInt();
            plentySpace();
            rpsPrompt(playerTwo);
            int rpsRoundXPlayerTwo = scan.nextInt();
            if (rpsRoundXPlayerOne == rpsRoundXPlayerTwo) {
                System.out.println("\nThis round was a draw");
                for (int j = 0; j < 1; j++) {
                    scoreThroughoutRounds[0] += 1;
                    scoreThroughoutRounds[1] += 1;
                }
            } else {
                boolean resultOfRound = theGameMechanics(rpsRoundXPlayerOne, rpsRoundXPlayerTwo);
                String whichPlayerWonRound = whoWonTheRoundMul(resultOfRound);
                System.out.println("\n" + whichPlayerWonRound + " won this round");
            }

        }

        //Results
        if (scoreThroughoutRounds[0] == scoreThroughoutRounds[1]) {
            System.out.println("\nThis game was a draw");
        } else if (scoreThroughoutRounds[0] > scoreThroughoutRounds[1]) {
            System.out.println("\n" + playerOne + " won this game");
        } else {
            System.out.println("\n" + playerTwo + " won this game");
        }

    }


    public static void main(String[] args) {

        //"Welcome", followed by prompt to choose singleplayer or multiplayer
        System.out.println("\nWelcome!\nThis is the famous Rock, Paper, Scissor - game...\n");
        System.out.println("Would you like to play against me (Singleplayer)?");
        System.out.println("Or would you rather play against a friend (Multiplayer)?\n");
        System.out.println("Singleplayer:\tPress 1");
        System.out.println("Multiplayer:\tPress 2\n");

        while (oneOrTwo) {
            String mulOrSin = scan.nextLine().trim();
            if (mulOrSin.equals("1")) { //Multiplayer
                singleplayerMode();
                oneOrTwo = false;
            } else if (mulOrSin.equals("2")) { //Singleplayer
                multiplayerMode();
                oneOrTwo = false;
            } else {
                System.out.println("1 or 2... I believe in you!");
            }

        }

        System.out.println("\nThank you for playing!");

    }
}
