/**
 * Board.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 10/4/2024
 * 
 * This abstract class represents a generic game board. It contains basic 
 * member of a board, such as the board size, cells.
 * It also contains abstract methods that need to be implemented by
 * the board of specific game. These methods are basic operations of a board,
 * such as display the board, update the board, check if the board is full,
 * check if a move is valid, etc.
 */

public abstract class Board {
    protected int boardSize;
    protected Cell[][] cells;

    public abstract Cell[][] getCells();
    public abstract void displayBoard();
    public abstract boolean updateBoard(int row, int col, Piece piece);
    public abstract boolean checkFull();
    public abstract void clearBoard();
    
    // This method checks if the move is valid.
    // It returns true if the move is within the board, false otherwise.
    public boolean isValidMove(int row, int col){
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize;
    }

}
