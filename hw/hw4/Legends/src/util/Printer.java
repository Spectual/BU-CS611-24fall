/**
 * Printer.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class defines the printer in the game.
 * It contains multiple methods to print messages to the console.
 */

package util;

import character.Hero;
import character.HeroTeam;
import character.Monster;
import character.Character;

public class Printer {
    public static void printWelcome(){
        println("\n======== GAME START ========");
        println("Welcome to Legends: Monsters and Heroes!");
        printEmptyLine();
        println("Game Background:");
        println("In this fantasy world of magic, monsters, and heroes, you will lead a brave party of heroes");
        println("on an endless journey filled with adventure. This world is dominated by powerful creatures");
        println("and fierce battles, where heroes and monsters clash in an eternal struggle. Every victory brings");
        println("your heroes experience and wealth, allowing them to grow stronger and acquire new items for");
        println("future battles.");
        printEmptyLine();
        println("For centuries, heroes and monsters have been locked in a constant battle. As your heroes defeat");
        println("monsters, they gain experience and gold, becoming more capable of facing even greater foes.");
        println("Heroes can use gold to buy weapons, armor, potions, and spells to improve their chances to win.");
        println("When enough experience is gained, heroes level up, improving their skills and gaining power to face");
        println("tougher enemies.");
        printEmptyLine();
        println("Gameplay:");
        println("- World: The world is divided into a grid of spaces, each with its own unique features like common");
        println("  areas ('empty grid'), markets('M'), and inaccessible space('X'). Heroes can move around the world");
        println("  to explore, fight monsters,");
        println("- Battles with Monsters: In the common areas of the world, heroes may encounter monsters triggering a battle.");
        println("  During a battle, each hero takes turns to choose an action, such as attacking using a weapon, casting a spell,");
        println("  a potion, or equipping armor. Monsters respond by attacking heroes. The battle proceeds in turns until");
        println("  either all monsters or all heroes are defeated.");
        println("- Character Attributes: Each hero and monster has unique attributes like HP (health), MP (mana),");
        println("  strength, dexterity, agility, and dodge chance. Each hero's class has favored attributes that receive");
        println("  additional boosts upon leveling up, making them even more formidable in battle.");
        println("- Market: In market spaces, heroes can use their gold to buy weapons, armor, potions, and spells to");
        println("  strengthen their abilities or sell unwanted items for extra gold. Each hero has their own inventory");
        println("  and gold, so managing resources wisely is crucial.");
        println("- Endless Adventure: Your goal is to continually defeat monsters, level up your heroes, and survive");
        println("  in this challenging world. Keep upgrading and equipping your heroes to transform them into true legends!");
        printEmptyLine();
        println("Controls:");
        println("- Help: Press H at any time to display the help list of commands.");
        println("- Movement: Use W/A/S/D keys to move your hero party around the world map.");
        println("- Battle Commands: During battle, each hero can choose to attack, cast spells, use potions, or equip weapon or armor.");
        println("  At any time, you can check the stats of your heroes or the monsters they face.");
        println("- Market Access: When on a market space, enter the market to buy or sell items and manage your heroes' inventories.");
        println("- Exit Game: Press Q at any time to quit the game.");
        println("- Again! Press H at any time if you lose sight of what to do.");
        printEmptyLine();
        println("Good luck, adventurer! May your heroes grow strong, conquer every challenge, and become legends");
        println("in this world of Monsters and Heroes!");
        println("=========================");
    }

    public static void printMarketWelcome(){
        Printer.println("\n======== MARKET ========");
        Printer.println("WELCOME TO THE MARKET!");
        Printer.println("We have weapons, armors, potions, and spells for sale.");
        Printer.println("Take a look around and see if you find anything you like!");
        Printer.println("========================");
    }

    public static void printBattleWelcome(){
        println("\n======== BATTLE ========");
        println("MONSTERS APPEAR!");
        println("Let's fight!");
        println("========================");
    }

    public static void displayHelp(){
        println("\nCommands:");
        println("w/W - Move up");
        println("a/A - Move left");
        println("s/S - Move down");
        println("d/D - Move right");
        println("b/B - Open inventory");
        println("m/M - Open market");
        println("v/V - View map");
        println("i/I - Display hero information");
        println("h/H - Display command help");
        println("q/Q - Quit the game");
    }

    public static void printMarketHelp(){
        println("\nMarket Commands:");
        println("w/W - Buy Weapon");
        println("a/A - Buy Armor");
        println("p/P - Buy Potion");
        println("s/S - Buy Spell");
        println("b/B - Open inventory");
        println("d/D - Sell your item");
        println("e/E - Exit market");
        println("i/I - Display hero information");
        println("h/H - Display command help");
        println("q/Q - Quit the game");
    }

    public static void printBattleHelp(){
        println("\nBattle Commands:");
        println("a/A - Attack");
        println("c/C - Use spell");
        println("p/P - Use potion");
        println("ew/EW - Equip weapon");
        println("ea/EA - Equip armor");
        println("b/B - Open inventory");
        println("i/I - Display hero and monster status");
        println("h/H - Display command help");
        println("q/Q - Quit the game");
    }

    public static void invalidActionInput(){
        printFail("INVALID ACTION. Please try again! (or type 'h' for help)");
    }

    public static boolean displayInventory(Hero hero){
        if (hero.getInventory().isEmpty()) {
            println("\n===== \033[33m" + hero.getName() + "'s\033[0m INVENTORY =====");
            println("EMPTY");
            return false;
        }
        println("\n===== \033[33m" + hero.getName() + "'s\033[0m INVENTORY =====");
        hero.getInventory().display();
        return true;
    }

    public static void displayInventory(HeroTeam team){
        for (Hero hero : team.getHeroes()) {
            displayInventory(hero);
        }
    }

    public static void displayInfo(Hero[] heroes) {
        println("\n============ HERO INFORMATION ============");
        
        String header = String.format("%-20s %-10s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-20s %-20s", 
            "Name", "Type", "Level", "Experience", "HP", "MP", "Strength", "Agility", 
            "Dexterity", "Gold", "Equipped Weapon", "Equipped Armor");
        println(header);

        for (Hero hero : heroes) {
            println(hero);
        }

        println("==========================================");
    }

    public static void displayInfo(Hero[] heroes, Monster[] monsters){
        displayInfo(heroes);
        println("\n============ MONSTER INFORMATION ============");

        String header = String.format("%-20s %-15s %-10s %-10s %-10s %-10s %-10s",
        "Name", "Type", "Level", "HP", "Damage", "Defense", "Dodge");
        println(header);

        for (Monster monster : monsters) {
            println(monster);
        }
        println("=============================================");
    }

    public static void printHeroTurn(String message){
        println("[HERO TURN] " + message);
    }

    public static void printMonsterTurn(String message){
        println("[MONSTER TURN] " + message);
    }

    public static void printEvent(String message){
        println("\033[32m[EVENT]\033[0m " + message);
    }

    public static void printFail(String message){
        println("\033[31m[FAIL]\033[0m " + message);
    }

    public static void printError(String message){
        println("\033[31m[ERROR]\033[0m " + message);
    }

    public static void printWarning(String message){
        println("[WARNING] " + message);
    }

    public static void printQuitMessage(){
        println("\n\033[31m[EXIT]\033[0m Thank you for playing! Goodbye!");
    }

    public static void println(Object message){
        System.out.println(message.toString());
    }

    public static void print(Object message){
        System.out.print(message.toString());
    }

    public static void printEmptyLine(){
        System.out.println();
    }

    public static String getHeroColorName(Character hero){
        return "\033[33m" + hero.getName() + "\033[0m";
    }

    public static String getMonsterColorName(Character monster){
        return "\033[35m" + monster.getName() + "\033[0m";
    }
}
