/**
 * Legend.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This class is the game class for Legends of valor.
 * It initializes the game and starts the game loop.
 * It has the game board, hero team, monster team.
 * It handles the whole game process like moving, battling, and marketing.
 * It also handles the user input and output.
 */

package game;

import action.*;
import world.*;
import creature.*;
import item.*;
import store.*;
import util.*;
import battle.*;
import strategy.*;

import java.util.Random;


public class LegendsValor extends RPGGame{
    private static LegendsValor instance; // Singleton instance
    
    private ValorBoard valorBoard;
    private HeroTeam heroTeam;
    private MonsterTeam monsterTeam;
    private int characterCount;
    private SpaceType currentSpaceType;
    private Battle battle;
    private int roundCount;
    private int spawnInterval;

    private LegendsValor(){
        this.name = "Legends of Valor";
        this.boardSize = 8;
        this.valorBoard = new ValorBoard(boardSize);
        this.characterCount = 3;
        this.roundCount = 0;
        this.spawnInterval = 8;
    }


    // Public static method to get the single instance
    public static LegendsValor getInstance() {
        if (instance == null) {
            instance = new LegendsValor();
        }
        return instance;
    }

    // Start the game
    @Override
    public void startGame(){
        Printer.printValorWelcome();
        Printer.displayHelp();
        Printer.printMarketHelp();

        setTeam();

        valorBoard.initializeBoard(heroTeam.getHeroes(), monsterTeam.getMonsters());
        valorBoard.displayBoard();

        while(true){
            for (Hero hero : heroTeam.getHeroes()){
                makeAction(hero);
                if (hero.getRow() == 0){
                    Printer.printEvent("Congratulations! YOU WIN!");
                    System.exit(0);
                }
            }
            for (Monster monster : monsterTeam.getMonsters()){
                makeMonsterAction(monster);
                if (monster.getRow() == boardSize - 1){
                    Printer.printEvent("Game Over! YOU LOSE!");
                    System.exit(0);
                }
            }

            // Recover and revive fainted heroes
            for (Hero hero : heroTeam.getHeroes()){
                if (hero.isFainted()){
                    hero.respawn();
                    hero.reviveWithPenalty();
                }
                else{
                    hero.recover();
                }
            }

            roundCount += 1;

            // Spawn new monsters every spawnInterval rounds
            if (roundCount % spawnInterval == 0){
                monsterTeam.addMonsters(characterCount, heroTeam.getLevel());
            }

            valorBoard.updateBoard(heroTeam.getHeroes(), monsterTeam.getMonsters());
            valorBoard.displayBoard();
        }
    }

    protected boolean checkBattle(Hero hero){
        Monster[] monsters = valorBoard.getMonstersAround(hero, monsterTeam);
        return monsters.length != 0;
    }

    private boolean checkBattle(Monster monster){
        Hero[] heroes = valorBoard.getHeroesAround(monster, heroTeam);
        return heroes.length != 0;
    }


    private void startBattle(Hero hero){
        battle = new Battle(heroTeam, monsterTeam);
        Monster[] monsters = valorBoard.getMonstersAround(hero, monsterTeam);
        Monster monster;

        if (monsters.length == 1){ 
            monster = monsters[0];
        }
        else{
            monster = InputHandler.getBattleTarget(hero, monsters);
        }

        battle.heroTurn(hero, monster);

        // Check if the monster is defeated
        if (monster.isDefeated()){
            monsterTeam.removeMonster(monster);
            valorBoard.removeMonster(monster);
            Printer.printEvent(Printer.getHeroColorName(hero) + " defeated " + Printer.getMonsterColorName(monster) + "!");
            Monster[] monsterList = {monster};
            hero.gainRewards(monsterList);
        }
    }

    // Perform the world action based on the user input
    private void makeAction(Hero hero){
        boolean isValidAction = false;
        boolean isBattle = checkBattle(hero);
        currentSpaceType = valorBoard.getSpaceType(hero.getRow(), hero.getCol());

        if (isBattle){
            Printer.printEmptyLine();
            Printer.printWarning(Printer.getHeroColorName(hero) + ", Be careful, Enemy around you! (Press 'K' to start attack)");
        }

        if (currentSpaceType == SpaceType.H_NEXUS){
            Printer.printTip(Printer.getHeroColorName(hero) + " is at the Nexus. (Press 'M' to enter the market)");
        }

        while (!isValidAction) {
            ActionType action = InputHandler.getActionInput(hero);
            switch(action){
                case MOVE_UP:
                case MOVE_DOWN:
                case MOVE_LEFT:
                case MOVE_RIGHT:
                case RECALL:
                    if (valorBoard.makeMove(hero, action)){
                        valorBoard.displayBoard();
                        isValidAction = true;
                    }
                    else{
                        Printer.printFail("Oops, invalid move! Try another way.");
                        isValidAction = false;
                    }
                    break;
                
                case TELEPORT:
                    Hero targetHero = InputHandler.getTeleportTarget(hero, heroTeam.getHeroes());
                    if (valorBoard.teleport(hero, targetHero)){
                        valorBoard.displayBoard();
                        isValidAction = true;
                    }
                    else{
                        Printer.printFail("Oops, invalid teleport! Try again!");
                        isValidAction = false;
                    }
                    break;

                case ATTACK:
                    if (isBattle){
                        startBattle(hero);
                        isValidAction = true;
                    }
                    else{
                        Printer.printFail("No enemy around you!");
                        isValidAction = false;
                    }
                    break;

                case INVENTORY:
                    Printer.displayInventory(heroTeam);;
                    break;

                case USE_POTION: // Use Potion
                    hero.usePotion();
                    break;

                case EQUIP_WEAPON: // Equip weapon
                    hero.setEquipStrategy(new EquipWeapon());
                    hero.executeEquip();
                    break;
                    
                case EQUIP_ARMOR: // Equip armor
                    hero.setEquipStrategy(new EquipArmor());
                    hero.executeEquip();
                    break;

                case MARKET:
                    if (currentSpaceType == SpaceType.H_NEXUS){
                        Printer.printMarketWelcome();
                        Market market = valorBoard.getMarket(hero.getRow(), hero.getCol());
                        makeMarketAction(market, hero);
                    }
                    else{
                        Printer.printError("No market here!");
                    }
                    break;
    
                case MAP:
                    valorBoard.displayBoard();
                    break;
    
                case INFO:
                    Printer.displayInfo(heroTeam.getHeroes(), monsterTeam.getMonsters());
                    break;
    
                case HELP:
                    Printer.displayHelp();
                    break;
    
                case PASS:
                    Printer.printEvent(Printer.getHeroColorName(hero) + " passed this round.\n");
                    isValidAction = true;
                    break;

                case QUIT:
                    Printer.printQuitMessage();
                    System.exit(0);
                    break;
    
                default:
                    break;
            }
            
        }
    }
    
    // Perform the monster action
    private void makeMonsterAction(Monster monster){
        boolean isBattle = checkBattle(monster);
        if (isBattle){
            battle = new Battle(heroTeam, monsterTeam);
            Hero[] heroes = valorBoard.getHeroesAround(monster, heroTeam);
            Hero hero = heroes[0];

            // when monster is above the bottom row
            if (monster.getRow() == boardSize - 2){
                // move monster depending on random probability
                int random = new Random().nextInt(2);
                if (random == 0){
                    battle.monsterTurn(monster, hero);
                }
                else{
                    valorBoard.makeMonsterMove(monster);
                }
                return;
            }
            battle.monsterTurn(monster, hero);
        }
        else{
            valorBoard.makeMonsterMove(monster);
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
                    Printer.displayInventory(heroTeam);
                    break;
                case MAP:
                    valorBoard.displayBoard();
                    break;
                case INFO:
                    Printer.displayInfo(heroTeam.getHeroes());
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


    // Initialize the hero team and monster team
    @Override
    protected void setTeam(){
        this.heroTeam = new HeroTeam(characterCount);
        this.monsterTeam = new MonsterTeam(characterCount);
        // set monster team level to hero team level
        monsterTeam.setLevel(heroTeam.getLevel());

        // Print team information
        Printer.displayInfo(heroTeam.getHeroes(), monsterTeam.getMonsters());
    }
}
 