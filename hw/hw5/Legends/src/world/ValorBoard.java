/**
 * MahBoard.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 * 
 * This class defines the board in the game Legends of Valor.
 * It contains the board size, spaces, and methods to initialize and display the board,
 * move the player on the board and specific functions in the game like to teleport a hero,
 * get monsters around a hero, get heroes around a monster, remove a monster from the board.
 */

package world;

import action.ActionType;
import action.InputHandler;
import creature.Hero;
import creature.HeroTeam;
import creature.Monster;
import creature.MonsterTeam;
import util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValorBoard extends Board {
    private static final int NUM_TYPES = 4;

    public ValorBoard(int boardSize) {
        super(boardSize);
    }

    public void initializeBoard(Hero[] heroes, Monster[] monsters) {
        int totalSpaces = boardSize * boardSize;
        int numNexus = 12;
        int numInacc = 16;
        int remaining = totalSpaces - numNexus - numInacc;
        int numPlain = remaining - 15;
        int numBush = 5;
        int numCave = 5;
        int numKoulou = 5;


        for (int i = 1; i < boardSize - 1; i++) {
            for (int j = 0; j < boardSize ; j++) {
                if (j != 2 && j != 5) {
                    Random rand = new Random();
                    int spaceNum = rand.nextInt(NUM_TYPES + 1) + 1;

                    // Assign tiles based on random number and tile availability
                    if (spaceNum == 1 && numBush > 0) {
                        spaces[i][j] = new Space(SpaceType.BUSH);
                        numBush--;
                    } else if (spaceNum == 2 && numCave > 0) {
                        spaces[i][j] = new Space(SpaceType.CAVE);
                        numCave--;
                    } else if (spaceNum == 3 && numKoulou > 0) {
                        spaces[i][j] = new Space(SpaceType.KOULOU);
                        numKoulou--;
                    } else if (spaceNum == 4 || spaceNum == 5 && numPlain > 0) {
                        spaces[i][j] = new Space(SpaceType.PLAIN);
                        numPlain--;
                    } else {
                        spaces[i][j] = new Space(SpaceType.PLAIN);
                        numPlain--;
                    }
                }
            }
        }

        // Set the Nexus space
        for (int j = 0; j < boardSize; j++) {
            spaces[0][j] = new Space(SpaceType.M_NEXUS);
            spaces[7][j] = new Space(SpaceType.H_NEXUS);
        }

        // Set the Impassible spaces
        for (int i = 0; i < boardSize; i++) {
            spaces[i][2] = new Space(SpaceType.IMPASSIBLE);
            spaces[i][5] = new Space(SpaceType.IMPASSIBLE);
        }

        // Set the initial position of the player
        for (Hero hero : heroes) {
            int row = hero.getRow();
            int col = hero.getCol();
            spaces[row][col].setHeroHere(hero.getIndex());
        }

        // Set the initial position of the monsters
        for (Monster monster : monsters) {
            int row = monster.getRow();
            int col = monster.getCol();
            spaces[row][col].setMonsterHere(monster.getIndex());
        }
    }

    // Update board with current positions of heroes and monsters
    public void updateBoard(Hero[] heroes, Monster[] monsters){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                spaces[i][j].setHeroHere(0);
                spaces[i][j].setMonsterHere(0);
            }
        }

        for (Hero hero : heroes) {
            int row = hero.getRow();
            int col = hero.getCol();
            spaces[row][col].setHeroHere(hero.getIndex());
        }

        for (Monster monster : monsters) {
            int row = monster.getRow();
            int col = monster.getCol();
            spaces[row][col].setMonsterHere(monster.getIndex());
        }
    }

    // Move the player on the board
    public boolean makeMove(Hero hero, ActionType move){
        int row = hero.getRow();
        int col = hero.getCol();
        int index = hero.getIndex();

        switch(move){
            case MOVE_UP:
                if (row > 0 && spaces[row-1][col].isAccessible() && !spaces[row-1][col].checkHeroHere()) {
                    if (col == 0 && !spaces[row][col].checkMonsterHere() && !spaces[row][col+1].checkMonsterHere()) {
                        spaces[row][col].setHeroHere(0);
                        hero.valueBack(spaces[row][col].getType());
                        spaces[row-1][col].setHeroHere(index);
                        hero.valueBonus(spaces[row-1][col].getType());
                        hero.setPosition(row-1, col);
                        return true;
                    }

                    if (col == 7 && !spaces[row][col - 1].checkMonsterHere() && !spaces[row][col].checkMonsterHere()) {
                        spaces[row][col].setHeroHere(0);
                        hero.valueBack(spaces[row][col].getType());
                        spaces[row-1][col].setHeroHere(index);
                        hero.valueBonus(spaces[row-1][col].getType());
                        hero.setPosition(row-1, col);
                        return true;
                    } if (col != 0 && col != 7 && !spaces[row][col - 1].checkMonsterHere() && !spaces[row][col].checkMonsterHere() && !spaces[row][col+1].checkMonsterHere()) {
                        spaces[row][col].setHeroHere(0);
                        hero.valueBack(spaces[row][col].getType());
                        spaces[row - 1][col].setHeroHere(index);
                        hero.valueBonus(spaces[row - 1][col].getType());
                        hero.setPosition(row - 1, col);
                        return true;
                    }
                }
                break;
            case MOVE_DOWN:
                if (row < boardSize-1 && spaces[row+1][col].isAccessible() && !spaces[row+1][col].checkHeroHere()) {
                    spaces[row][col].setHeroHere(0);
                    hero.valueBack(spaces[row][col].getType());
                    spaces[row+1][col].setHeroHere(index);
                    hero.valueBonus(spaces[row-1][col].getType());
                    hero.setPosition(row+1, col);
                    return true;
                }
                break;
            case MOVE_LEFT:
                if (col > 0 && spaces[row][col-1].isAccessible() && !spaces[row][col-1].checkHeroHere()) {
                    spaces[row][col].setHeroHere(0);
                    hero.valueBack(spaces[row][col].getType());
                    spaces[row][col-1].setHeroHere(index);
                    hero.valueBonus(spaces[row-1][col].getType());
                    hero.setPosition(row, col-1);
                    return true;
                }
                break;
            case MOVE_RIGHT:
                if (col < boardSize-1 && spaces[row][col+1].isAccessible() && !spaces[row][col+1].checkHeroHere()) {
                    spaces[row][col].setHeroHere(0);
                    hero.valueBack(spaces[row][col].getType());
                    spaces[row][col+1].setHeroHere(index);
                    hero.valueBonus(spaces[row-1][col].getType());
                    hero.setPosition(row, col+1);
                    return true;
                }
                break;
            case RECALL:
                int initRow = hero.getInitRow();
                int initCol = hero.getInitCol();

                if (!spaces[initRow][initCol].checkHeroHere()) {
                    spaces[row][col].setHeroHere(0);
                    spaces[initRow][initCol].setHeroHere(index);

                    hero.recall();
                    Printer.printEvent(Printer.getHeroColorName(hero) + " is recalled to the Nexus!");
                    return true;
                }
                Printer.printWarning("The Nexus is occupied! Can not recall!");
        }
        return false;
    }

    // Move a monster down on the board
    public boolean makeMonsterMove(Monster monster){
        int row = monster.getRow();
        int col = monster.getCol();
        int index = monster.getIndex();

        if (row < boardSize-1 && spaces[row+1][col].isAccessible() && !spaces[row+1][col].checkMonsterHere()) {
            spaces[row][col].setMonsterHere(0);
            spaces[row+1][col].setMonsterHere(index);
            monster.setPosition(row+1, col);
            Printer.printMonsterTurn(Printer.getMonsterColorName(monster) + " moves down!");
            return true;
        }
        return false;
    }

    // Teleport the player to the target player
    public boolean teleport(Hero hero, Hero target){
        int row = hero.getRow();
        int col = hero.getCol();
        int index = hero.getIndex();

        int targetRow = target.getRow();
        int targetCol = target.getCol();

        ActionType action = InputHandler.getTeleportPositionInput(hero, target);
        switch(action){
            case MOVE_LEFT:
                if (targetCol > 0 && spaces[targetRow][targetCol-1].isAccessible() && !spaces[targetRow][targetCol-1].checkHeroHere()) {
                    spaces[row][col].setHeroHere(0);
                    spaces[targetRow][targetCol-1].setHeroHere(index);
                    hero.setPosition(targetRow, targetCol-1);
                    Printer.printEvent(Printer.getHeroColorName(hero) + " teleported to " + Printer.getHeroColorName(target) + "'s left!");
                    return true;
                }
                break;
            case MOVE_RIGHT:
                if (targetCol < boardSize-1 && spaces[targetRow][targetCol+1].isAccessible() && !spaces[targetRow][targetCol+1].checkHeroHere()) {
                    spaces[row][col].setHeroHere(0);
                    spaces[targetRow][targetCol+1].setHeroHere(index);
                    hero.setPosition(targetRow, targetCol+1);
                    Printer.printEvent(Printer.getHeroColorName(hero) + " teleported to " + Printer.getHeroColorName(target) + "'s right!");
                    return true;
                }
                break;
            case MOVE_DOWN:
                if (targetRow < boardSize-1 && spaces[targetRow+1][targetCol].isAccessible() && !spaces[targetRow+1][targetCol].checkHeroHere()) {
                    spaces[row][col].setHeroHere(0);
                    spaces[targetRow+1][targetCol].setHeroHere(index);
                    hero.setPosition(targetRow+1, targetCol);
                    Printer.printEvent(Printer.getHeroColorName(hero) + " teleported to " + Printer.getHeroColorName(target) + "'s bottom!");
                    return true;
                }
                break;
            case QUIT:
                Printer.printQuitMessage();
                System.exit(0);
        }
        return false;
    }

    // Check if there are monsetrs around the hero
    public Monster[] getMonstersAround(Hero target, MonsterTeam monsterTeam){
        int row = target.getRow();
        int col = target.getCol();
        int index;

        List<Monster> enemies = new ArrayList<>();
        if (spaces[row][col].checkMonsterHere()){
            index = spaces[row][col].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (row > 0 && spaces[row-1][col].checkMonsterHere()){
            index = spaces[row-1][col].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (row < boardSize-1 && spaces[row+1][col].checkMonsterHere()){
            index = spaces[row+1][col].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (col > 0 && spaces[row][col-1].checkMonsterHere()){
            index = spaces[row][col-1].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (col < boardSize-1 && spaces[row][col+1].checkMonsterHere()){
            index = spaces[row][col+1].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (col > 0 && row > 0 && spaces[row-1][col-1].checkMonsterHere()){
            index = spaces[row-1][col-1].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (col < boardSize-1 && row > 0 && spaces[row-1][col+1].checkMonsterHere()){
            index = spaces[row-1][col+1].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (col > 0 && row < boardSize-1 && spaces[row+1][col-1].checkMonsterHere()){
            index = spaces[row+1][col-1].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }
        if (col < boardSize-1 && row < boardSize-1 && spaces[row+1][col+1].checkMonsterHere()){
            index = spaces[row+1][col+1].getMonsterHere();
            enemies.add(monsterTeam.getMonster(index));
        }

        return enemies.toArray(new Monster[0]);
    }

    // Check if there are heroes around the monster
    public Hero[] getHeroesAround(Monster target, HeroTeam heroTeam){
        int row = target.getRow();
        int col = target.getCol();
        int index;

        List<Hero> enemies = new ArrayList<>();
        if (spaces[row][col].checkHeroHere()){
            index = spaces[row][col].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (row < boardSize-1 && spaces[row+1][col].checkHeroHere()){
            index = spaces[row+1][col].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (row > 0 && spaces[row-1][col].checkHeroHere()){
            index = spaces[row-1][col].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (col > 0 && spaces[row][col-1].checkHeroHere()){
            index = spaces[row][col-1].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (col < boardSize-1 && spaces[row][col+1].checkHeroHere()){
            index = spaces[row][col+1].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (col > 0 && row > 0 && spaces[row-1][col-1].checkHeroHere()){
            index = spaces[row-1][col-1].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (col < boardSize-1 && row > 0 && spaces[row-1][col+1].checkHeroHere()){
            index = spaces[row-1][col+1].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (col > 0 && row < boardSize-1 && spaces[row+1][col-1].checkHeroHere()){
            index = spaces[row+1][col-1].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }
        if (col < boardSize-1 && row < boardSize-1 && spaces[row+1][col+1].checkHeroHere()){
            index = spaces[row+1][col+1].getHeroHere();
            enemies.add(heroTeam.getHero(index));
        }

        return enemies.toArray(new Hero[0]);
    }

    // Remove a monster from the board
    public void removeMonster(Monster monster){
        int row = monster.getRow();
        int col = monster.getCol();
        spaces[row][col].setMonsterHere(0);
    }
}
