/**
 * Legend.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class is the main game class.
 * It initializes the game and starts the game loop.
 * It has the game board, hero team.
 * It handles the whole game process like moving, battling, and marketing.
 * It also handles the user input and output.
 */

package game;

import action.*;
import world.*;
import character.*;
import item.*;
import market.*;
import util.*;
import battle.*;


public class Legends {
    private Board board;
    private int boardSize;
    private HeroTeam team;
    private SpaceType currentSpaceType;

    public Legends(){
        this.boardSize = 9;
        this.board = new Board(boardSize);
    }

    // Start the game
    public void startGame(){
        Printer.printWelcome();

        setTeam();
        board.initializeBoard(team.getRow(), team.getCol());
        board.displayBoard();

        while(true){
            ActionType action = InputHandler.getActionInput();
            makeAction(action);
        }
    }

    private boolean checkBattle(){
        return Math.random() < 0.3;
    }

    private void startBattle(){
        Printer.println("\nYou have encountered an enemy! Let's battle!");
        Battle battle = new Battle(team);
        battle.startBattle();
    }

    // Perform the world action based on the user input
    private void makeAction(ActionType action){
        switch(action){
            case MOVE_UP:
            case MOVE_DOWN:
            case MOVE_LEFT:
            case MOVE_RIGHT:
                int row = team.getRow();
                int col = team.getCol();
                if (board.makeMove(team, action)){
                    board.displayBoard();
                    currentSpaceType = board.getSpaceType(team.getRow(), team.getCol());
                    if (currentSpaceType == SpaceType.COMMON && checkBattle()){
                        startBattle();
                    }
                }
                else{
                    Printer.printFail("Oops, wall ahead! Try another way.");
                }
                break;

            case INVENTORY:
                Printer.displayInventory(team);
                break;

            case MARKET:
                if (currentSpaceType == SpaceType.MARKET){
                    Printer.printMarketWelcome();
                    Market market = board.getMarket(team.getRow(), team.getCol());
                    Hero[] heroes = team.getHeroes();
                    for (Hero hero : heroes){
                        makeMarketAction(market, hero);
                    }
                }
                else{
                    Printer.printError("No market here!");
                }
                break;

            case MAP:
                board.displayBoard();
                break;

            case INFO:
                Printer.displayInfo(team.getHeroes());
                break;

            case HELP:
                Printer.displayHelp();
                break;

            case QUIT:
                Printer.printQuitMessage();
                System.exit(0);
                break;

            default:
                break;
        }
    }
    
    // Perform the market action based on the user input
    private void makeMarketAction(Market market, Hero hero){
        while (true){
            ActionType action = InputHandler.getMarketActionInput(hero);
            switch(action){
                case WEAPON:
                    market.chooseFromCategory(hero, "WEAPON");
                    break;
                case ARMOR:
                    market.chooseFromCategory(hero, "ARMOR");
                    break;
                case POTION:
                    market.chooseFromCategory(hero, "POTION");
                    break;
                case SPELL:
                    market.chooseFromCategory(hero, "SPELL");
                    break;
                case DEAL:
                    String itemName;
                    if (Printer.displayInventory(hero)){
                        itemName = InputHandler.getItemNameInput();
                        Item item = hero.getInventory().getItemByName(itemName);
                        market.sellItem(hero, item);
                    }
                    else{
                        Printer.printFail("No item to sell!");
                    }
                    break;
                case INVENTORY:
                    Printer.displayInventory(team);
                    break;
                case MAP:
                    board.displayBoard();
                    break;
                case INFO:
                    Printer.displayInfo(team.getHeroes());
                    break;
                case HELP:
                    Printer.printMarketHelp();
                    break;
                case EXIT:
                    Printer.println("Exiting market...");
                    return;
                case QUIT:
                    Printer.printQuitMessage();
                    System.exit(0);
                    break;
                default:
                    Printer.invalidActionInput();
                    break;
            }
        }
    }

    private void setTeam(){
        // Set team at the center of the board
        int initRow = boardSize/2;
        int initCol = boardSize/2;

        // Initialize team
        int heroCount = InputHandler.getHeroCountInput();
        this.team = new HeroTeam("Party", initRow, initCol, heroCount);

        // Print team information
        Printer.displayInfo(team.getHeroes());

    }

}
