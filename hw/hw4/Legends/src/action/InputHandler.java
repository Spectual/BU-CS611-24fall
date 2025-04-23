/**
 * InputHandler.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class is the input handler for the game.
 * It provides methods to get user input for different purposes.
 */

package action;

import util.*;

import java.util.Scanner;

import character.Character;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getHeroCountInput(){
        while (true) {
            Printer.print("\n<World> How many heroes would you like to assemble? (1-3): ");
            String input = scanner.nextLine();
            try {
                int heroCount = Integer.parseInt(input);
                if (heroCount < 1 || heroCount > 3) {
                    Printer.printFail("Invalid input. Please enter a number between 1 and 3.");
                } else {
                    return heroCount;
                }
            } catch (NumberFormatException e) {
                Printer.printFail("Invalid input. Please enter a number between 1 and 3.");
            }
        }
    }

    public static int getIntInput(String message, int min, int max){
        while (true) {
            Printer.print(message);
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    Printer.printFail("Invalid input. Please enter a number between " + min + " and " + max);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                Printer.printFail("Invalid input. Please enter a number between " + min + " and " + max );
            }
        }
    }

    public static String getItemNameInput(){
        Printer.print("<Market> Please enter the name of the item you want to sell: ");
        return scanner.nextLine();
    }

    public static ActionType getActionInput(){
        while (true) {
            Printer.print("\n<World> Please enter your action: ");
            String input = scanner.nextLine();
            switch (input) {
                case "w":
                case "W":
                    return ActionType.MOVE_UP;
                case "a":
                case "A":
                    return ActionType.MOVE_LEFT;
                case "s":
                case "S":
                    return ActionType.MOVE_DOWN;
                case "d":
                case "D":
                    return ActionType.MOVE_RIGHT;
                case "b":
                case "B":
                    return ActionType.INVENTORY;
                case "m":
                case "M":
                    return ActionType.MARKET;
                case "v":
                case "V":
                    return ActionType.MAP;
                case "i":
                case "I":
                    return ActionType.INFO;
                case "h":
                case "H":
                    return ActionType.HELP;
                case "q":
                case "Q":
                    return ActionType.QUIT;
                default:
                    Printer.invalidActionInput();
                    break;
            }
        }
    }

    public static ActionType getMarketActionInput(Character hero){
        while (true) {
            Printer.println("\n<Market> \033[33m" + hero.getName() + "\033[0m, how can I help you?");
            Printer.println("  (W) Buy Weapon");
            Printer.println("  (A) Buy Armor");
            Printer.println("  (P) Buy Potion");
            Printer.println("  (S) Buy Spell");
            Printer.println("  (D) Sell your item");
            Printer.println("  (E) Exit market");
            Printer.print("\n<Market> Make your choice: ");
            String input = scanner.nextLine();
            switch (input) {
                case "w":
                case "W":
                    return ActionType.WEAPON;
                case "a":
                case "A":
                    return ActionType.ARMOR;
                case "p":
                case "P":
                    return ActionType.POTION;
                case "s":
                case "S":
                    return ActionType.SPELL;
                case "d":
                case "D":
                    return ActionType.DEAL;
                case "b":
                case "B":
                    return ActionType.INVENTORY;
                case "v":
                case "V":
                    return ActionType.MAP;
                case "i":
                case "I":
                    return ActionType.INFO;
                case "h":
                case "H":
                    return ActionType.HELP;
                case "e":
                case "E":
                    return ActionType.EXIT;
                case "q":
                case "Q":
                    return ActionType.QUIT;
                default:
                    Printer.invalidActionInput();
                    break;
            }
        }
    }

    public static ActionType getBattleActionInput(Character hero){
        while (true) {
            Printer.println("\n<Battle> \033[33m" + hero.getName() + "\033[0m, what will you do?");
            Printer.println("  (A) Attack");
            Printer.println("  (C) Cast Spell");
            Printer.println("  (P) Use Potion");
            Printer.println("  (EW) Equip Weapon");
            Printer.println("  (EA) Equip Armor");
            Printer.println("  (I) Display Info");
            Printer.print("<Battle> Make your choice: ");
            String input = scanner.nextLine();
            switch (input) {
                case "a":
                case "A":
                    return ActionType.ATTACK;
                case "c":
                case "C":
                    return ActionType.CAST_SPELL;
                case "p":
                case "P":
                    return ActionType.USE_POTION;
                case "ew":
                case "EW":
                    return ActionType.EQUIP_WEAPON;
                case "ea":
                case "EA":
                    return ActionType.EQUIP_ARMOR;
                case "b":
                case "B":
                    return ActionType.INVENTORY;
                case "i":
                case "I":
                    return ActionType.DISPLAY_STATS;
                case "h":
                case "H":
                    return ActionType.HELP;
                case "q":
                case "Q":
                    return ActionType.QUIT;
                default:
                    Printer.invalidActionInput();
                    break;
            }
        }
    }
}
