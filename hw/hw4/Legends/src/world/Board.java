/**
 * Board.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class defines the board in the game.
 * It contains the board size, spaces, and methods to initialize and display the board,
 * move the player on the board.
 */

package world;

import action.*;
import character.*;
import market.Market;
import util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Board {
    private int boardSize;
    private Space[][] spaces;

    public Board(int boardSize){
        this.boardSize = boardSize;
        this.spaces = new Space[boardSize][boardSize];
    }

    public void initializeBoard(int initRow, int initCol){
        int totalSpaces = boardSize * boardSize;
        int inaccessibleCount = (int) (totalSpaces * 0.2);
        int marketCount = (int) (totalSpaces * 0.3);
        int commonCount = totalSpaces - inaccessibleCount - marketCount;

        // Create a list of spaces with the correct number of each type
        List<Space> spaceList = new ArrayList<>();
        for (int i = 0; i < inaccessibleCount; i++) {
            spaceList.add(new Space(SpaceType.INACCESSIBLE));
        }
        for (int i = 0; i < marketCount; i++) {
            spaceList.add(new Space(SpaceType.MARKET));
        }
        for (int i = 0; i < commonCount; i++) {
            spaceList.add(new Space(SpaceType.COMMON));
        }

        // shuffle the list
        Collections.shuffle(spaceList);

        // fill the 2D board with the shuffled list
        int index = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                spaces[i][j] = spaceList.get(index++);
            }
        }

        // Set the initial position of the player
        spaces[initRow][initCol] = new Space(SpaceType.COMMON);
        spaces[initRow][initCol].setPlayerHere(true);
    }

    // Display the whole board
    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            // Print top border of the row
            Printer.print("+");
            for (int j = 0; j < boardSize; j++) {
                Printer.print("-----+");
            }
            Printer.printEmptyLine();

            // Print row content
            Printer.print("|");
            for (int j = 0; j < boardSize; j++) {
                // Center the content in the cell
                Printer.print("  " + spaces[i][j] + "  |");
            }
            Printer.printEmptyLine();
        }
        // Print bottom border
        Printer.print("+");
        for (int j = 0; j < boardSize; j++) {
            Printer.print("-----" + "+");
        }
    }

    // Move the player on the board
    public boolean makeMove(HeroTeam player, ActionType move){
        int row = player.getRow();
        int col = player.getCol();

        switch(move){
            case MOVE_UP:
                if (row > 0 && spaces[row-1][col].isAccessible()) {
                    spaces[row][col].setPlayerHere(false);
                    spaces[row-1][col].setPlayerHere(true);
                    player.setPosition(row-1, col);
                    return true;
                }
                break;
            case MOVE_DOWN:
                if (row < boardSize-1 && spaces[row+1][col].isAccessible()) {
                    spaces[row][col].setPlayerHere(false);
                    spaces[row+1][col].setPlayerHere(true);
                    player.setPosition(row+1, col);
                    return true;
                }
                break;
            case MOVE_LEFT:
                if (col > 0 && spaces[row][col-1].isAccessible()) {
                    spaces[row][col].setPlayerHere(false);
                    spaces[row][col-1].setPlayerHere(true);
                    player.setPosition(row, col-1);
                    return true;
                }
                break;
            case MOVE_RIGHT:
                if (col < boardSize-1 && spaces[row][col+1].isAccessible()) {
                    spaces[row][col].setPlayerHere(false);
                    spaces[row][col+1].setPlayerHere(true);
                    player.setPosition(row, col+1);
                    return true;
                }
                break;
        }
        return false;
    }

    public SpaceType getSpaceType(int row, int col){
        return spaces[row][col].getType();
    }

    public Market getMarket(int row, int col){
        return spaces[row][col].getMarket();
    }
}
