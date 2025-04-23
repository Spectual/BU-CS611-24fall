/**
 * GameLauncher.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents a game launcher. It contains the 
 * core method to start the game.
 * It contains a method to display the game menu (TicTacToe and OrderAndChaos).
 * It contains a method allowing the user to choose a game to play.
 */

import java.util.Scanner;   

public class GameLauncher {
    private TicTacToe ticTacToe;
    private OrderAndChaos orderAndChaos;
    private SuperTicTacToe superTicTacToe;

    public GameLauncher() {
        this.ticTacToe = new TicTacToe();
        this.orderAndChaos = new OrderAndChaos();
        this.superTicTacToe = new SuperTicTacToe();
    }

    // This method displays the game menu 
    // (TicTacToe and OrderAndChaos or Exit).
    public void displayMenu(){
        System.out.println("\nWelcome to the board game!\n");
        System.out.println("Game Menu:");   
        System.out.println("1. " + ticTacToe.getName());
        System.out.println("2. " + orderAndChaos.getName());
        System.out.println("3. " + superTicTacToe.getName());
        System.out.println("0. Exit\n");
        System.out.print("Please choose a game to play:");
    }

    // This method starts the game based on user's choice.
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();

            // user chooses a game by entering a number on the menu
            char gameChoice = scanner.nextLine().charAt(0);

            switch (gameChoice) {
                case '0':
                    System.out.println("See you next time!");
                    return;
                case '1':
                    ticTacToe.startGame();
                    break;
                case '2':
                    orderAndChaos.startGame();
                    break;
                case '3':
                    superTicTacToe.startGame();
                    break;
                default:
                    System.out.println("Oops! That wasn’t on the menu, try again!");
                    break;
            }
        }

    }
}