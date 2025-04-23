/*
 * Cell.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents a cell in the game board.
 * It contains a character value that represents the state of the cell.
 * The value can be ' ', 'X', 'O' or any other character depending on the game.
 */

public class Cell{
    private char value;

    public Cell() {
        value = ' ';
    }

    public boolean isEmpty() {
        return value == ' ';
    }

    public String toString() {
        return String.valueOf(value);
    }

    public boolean equals(Cell cell) {
        return value == cell.getValue();
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

}