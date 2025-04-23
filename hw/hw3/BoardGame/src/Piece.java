/**
 * Piece.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 10/4/2024
 * 
 * This class represents a piece in the game. It contains the symbol of the 
 * piece. It contains methods to get and set the symbol of the piece, and to
 * implement the toString and equals methods.
 */

public class Piece {
    protected char symbol;  

    public Piece(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Piece other = (Piece) obj;
        return symbol == other.symbol;
    }
}
