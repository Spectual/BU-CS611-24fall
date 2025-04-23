/*
 * Cell.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents a cell in the game board.
 * It contains a character value that represents the state of the cell.
 * The value can be ' ', 'X', 'O' or any other character depending on the game.
 */

 public class Cell {
    protected Piece piece;  

    public Cell() {
        this.piece = null;  
    }

    public boolean checkEmpty() {
        return piece == null;
    }

    public void placePiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        if (checkEmpty()) {
            return " ";  
        }
        return piece.toString();
    }
}