/**
 * Player.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents a player in the game. It contains the player's name,
 * current piece, and score. It contains methods to get and set the player's 
 * name, piece, and score, and to change the player's score.
 * 
 */
public class Player {
    private String name;
    private Piece piece;
    private int score;
    
    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
        this.score = 0;
    }

    public Player(String name) {
        this(name, null);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }
    
    public int getScore() {
        return score;
    }

    public void changeScoreBy(int value) {
        score += value;
    }
    
    
}