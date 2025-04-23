/**
 * Board.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents a game board. It contains the size of the board and
 * a 2D array of cells that represent the board. It contains methods to
 * display the board, check if the board is full, check if a move is valid etc.
 */

public class Board {
    int size;
    Cell[][] cells;

    public Board(int size) {
        this.size = size;   // initialize size of the board

        // initialize a 2D array of cells to represent the board
        cells  = new Cell[size][size];  
        for (int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                cells[r][c] = new Cell();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    // This method prints the board to the console.
    // It prints the row and column numbers, cell values, and split lines.
    // For example:
    //   1   2   3
    // 1 X | O | X
    //   -----------
    // 2 O | X | O
    //   -----------
    // 3 X | O | X
    public void displayBoard() {
        
        System.out.println("");

        // print column number (1, 2, 3, ...)
        System.out.print("  ");
        for (int c = 0; c < size; c ++) {
            System.out.print(" " + (c + 1) + " ");
            if (c != size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        

        for (int r = 0; r < size; r++) {

            System.out.print((r + 1) + " ");  // print row number (1, 2, 3, ...)
     
            // print cell value and vertical split line between cells
            for (int c = 0; c < size; c++) {
                System.out.print(" ");
                System.out.print(cells[r][c].getValue());  
                if (c != size - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            
            // print horizontal split line between rows
            if (r != size - 1) {
                System.out.print("  ");  
                for (int i = 0; i < size; i++) {
                    System.out.print("---");
                    if (i != size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    // This method checks if the board is full.
    // It returns true if the board is full, false otherwise.
    public boolean isFull() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (cells[r][c].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    // This method checks if the move is valid.
    // It returns true if the move is within the board, false otherwise.
    public boolean isValidMove(int row, int col) {
        return (row >= 0) && (row < size) && (col >= 0) && (col < size);
    }

    // This method changes the value of a cell in the board.
    // It takes the row, column, and symbol as input.
    public void updateBoard(int row, int col, char symbol) {
        cells[row][col].setValue(symbol);
    }

    // This method clears all cells in the board.
    public void clearBoard() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                cells[r][c].setValue(' ');
            }
        }
    }
    
}