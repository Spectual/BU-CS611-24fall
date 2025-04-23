/**
 * GameLauncher.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 *
 * This class is the class to launch the game.
 */

package game;

import java.util.Scanner;

public class GameLauncher {
    private RPGGame legendsValor;
    private RPGGame legendsMah;

    public GameLauncher(){
        legendsValor = LegendsValor.getInstance();
        legendsMah = LegendsMah.getInstance();
    }

    // This method displays the game menu 
    public void displayMenu(){
        System.out.println("\nWelcome to the \033[31mL\033[33mE\033[33mG\033[32mE\033[34mN\033[36mD\033[35mS\033[0m!\n");
        System.out.println("Game Menu:");   
        System.out.println("1. " + legendsValor.getName());
        System.out.println("2. " + legendsMah.getName());
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
                    legendsValor.startGame();
                    break;
                case '2':
                    legendsMah.startGame();
                    break;
                default:
                    System.out.println("Oops! That wasn’t on the menu, try again!");
                    break;
            }
        }

    }
}
