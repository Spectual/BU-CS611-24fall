/**
 * InputHandler.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This class is the input handler for the game.
 * It provides methods to get user input for different purposes.
 */

package action;

import util.*;

import java.util.Scanner;

import creature.*;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    private InputHandler(){}

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
                case "up":
                case "UP":
                    return ActionType.USE_POTION;
                case "ew":
                case "EW":
                    return ActionType.EQUIP_WEAPON;
                case "ea":
                case "EA":
                    return ActionType.EQUIP_ARMOR;
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

    public static ActionType getActionInput(Creature hero){
        while (true) {
            Printer.print("\n<World> " + Printer.getHeroColorName(hero) + ", please enter your action: ");
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
                case "t":
                case "T":
                    return ActionType.TELEPORT;
                case "r":
                case "R":
                    return ActionType.RECALL;
                case "k":
                case "K":
                    return ActionType.ATTACK;
                case "b":
                case "B":
                    return ActionType.INVENTORY;
                case "up":
                case "UP":
                    return ActionType.USE_POTION;
                case "ew":
                case "EW":
                    return ActionType.EQUIP_WEAPON;
                case "ea":
                case "EA":
                    return ActionType.EQUIP_ARMOR;
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
                case "p":
                case "P":
                    return ActionType.PASS;
                case "q":
                case "Q":
                    return ActionType.QUIT;
                default:
                    Printer.invalidActionInput();
                    break;
            }
        }
    }

    public static ActionType getMarketActionInput(Creature hero){
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

    public static ActionType getBattleActionInput(Creature hero){
        while (true) {
            Printer.println("\n<Battle> " + Printer.getHeroColorName(hero) + ", what will you do?");
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

    // Get the target monster for the hero to attack by monster index
    public static Monster getBattleTarget(Hero hero, Monster[] monsters){
        while (true) {
            Printer.println("\n<Battle> " + Printer.getHeroColorName(hero) + ", please choose a monster to attack: ");
            for (int i = 0; i < monsters.length; i++) {
                Printer.println(Printer.getMonsterColorName(monsters[i]));
            }
            Printer.print("Please enter your choice: ");

            String input = scanner.nextLine();
            try {
                int targetIndex = Integer.parseInt(input); 
    
                // find the monster with the target index
                for (Monster monster : monsters) {
                    if (monster.getIndex() == targetIndex) {
                        return monster; 
                    }
                }
                
                Printer.printFail("Invalid input. Please enter a valid monster index.");
            } catch (NumberFormatException e) {
                Printer.printFail("Invalid input. Please enter a valid monster index.");
            }
        }
    }

    public static Hero getTeleportTarget(Hero hero, Hero[] heroes){
        while (true) {
            Printer.println("\n<Teleport> " + Printer.getHeroColorName(hero) + ", please choose a hero to teleport to: ");
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i] != hero) {
                    Printer.println(Printer.getHeroColorName(heroes[i]));
                }
            }
            Printer.print("Please enter your choice: ");

            String input = scanner.nextLine();
            try {
                int index = Integer.parseInt(input) - 1;
                if (index < 0 || index >= heroes.length || heroes[index] == hero) {
                    Printer.printFail("Invalid input. Please enter a number between 1 and " + heroes.length + " (excluding yourself).");
                } else {
                    return heroes[index];
                }
            } catch (NumberFormatException e) {
                Printer.printFail("Invalid input. Please enter a number between 1 and " + heroes.length + " (excluding yourself).");
            }
        }
    }

    public static ActionType getTeleportPositionInput(Creature hero, Creature target){
        while (true) {
            Printer.println("\n<Teleport> " + Printer.getHeroColorName(hero) + ", which side of " + Printer.getHeroColorName(target) + " would you like to teleport to?");
            Printer.println("  (A) Left");
            Printer.println("  (D) Right");
            Printer.println("  (S) Bottom");
            Printer.print("Please enter your choice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "a":
                case "A":
                    return ActionType.MOVE_LEFT;
                case "s":
                case "S":
                    return ActionType.MOVE_DOWN;
                case "d":
                case "D":
                    return ActionType.MOVE_RIGHT;
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
