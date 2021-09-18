import java.util.Scanner;


public class Main {

    static Scanner scan = new Scanner(System.in);
    static boolean oneOrTwo = true;


    public static void multiplayerMode() {
        System.out.print("\nType in the name of player 1: ");
        String playerOne = scan.nextLine();

        System.out.print("Type in the name of player 2: ");
        String playerTwo = scan.nextLine();


    }


    public static void singleplayerMode() {
        System.out.print("\nType in name of player: ");
        String playerOne = scan.nextLine();
    }


    public static void main(String[] args) {

        System.out.println("\nWelcome!\nThis is the famous Rock, Paper, Scissor - game...\n");
        System.out.println("Would you like to play against a friend (Multiplayer)?");
        System.out.println("Or would you rather play against me (Singleplayer)?\n");
        System.out.println("Multiplayer:\tPress 1");
        System.out.println("Singleplayer:\tPress 2\n");

        while (oneOrTwo) {
            String mulOrSin = scan.nextLine().trim();
            if (mulOrSin.equals("1")) { //Multiplayer
                multiplayerMode();
                oneOrTwo = false;
            } else if (mulOrSin.equals("2")) { //Singleplayer
                singleplayerMode();
                oneOrTwo = false;
            } else {
                System.out.println("1 or 2... I believe in you!");
            }

        }
    }
}
