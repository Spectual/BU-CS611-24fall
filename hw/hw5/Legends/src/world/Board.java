/**
 * Board.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 * 
 * This class defines the general board in the game.
 * It contains the board size, spaces, and methods to display the board,
 * and get the space type and market.
 */

package world;

import store.Market;
import util.*;


public class Board {
    protected int boardSize;
    protected Space[][] spaces;

    public Board(int boardSize){
        this.boardSize = boardSize;
        this.spaces = new Space[boardSize][boardSize];
    }

    // Display the whole board
    public void displayBoard() {
        Printer.printEmptyLine();
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
                Printer.print(spaces[i][j] + "|");
            }
            Printer.printEmptyLine();
        }
        // Print bottom border
        Printer.print("+");
        for (int j = 0; j < boardSize; j++) {
            Printer.print("-----" + "+");
        }
        Printer.printEmptyLine();
        Printer.printEmptyLine();
    }


    public SpaceType getSpaceType(int row, int col){
        return spaces[row][col].getType();
    }

    public Market getMarket(int row, int col){
        return spaces[row][col].getMarket();
    }
}
