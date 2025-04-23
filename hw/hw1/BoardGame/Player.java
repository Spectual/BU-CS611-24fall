/**
 * Player.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents a player in the game. It contains the player's name,
 * current symbol, and score. It contains methods to get and set the player's 
 * name, symbol, and score, and to change the player's score.
 * 
 */
public class Player {
    private String name;
    private char symbol;
    private int score;
    
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
    
    public int getScore() {
        return score;
    }

    public void changeScoreBy(int value) {
        score += value;
    }
    
    
}