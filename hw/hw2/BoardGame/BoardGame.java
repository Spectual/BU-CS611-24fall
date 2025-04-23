/**
 * BoardGame.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This abstract class represents a generic board game. It contains basic 
 * information of a board game, such as the name, board size, board, 
 * player count, players, and current player index.
 * It also contains abstract methods that need to be implemented by
 * specific board games.
 */

public abstract class BoardGame {
    protected String name;
    protected int boardSize;
    protected Board board;
    protected int playerCount;
    protected Player[] players;
    protected int currentPlayerIndex;

    public abstract String getName();
    public abstract void startGame();
    public abstract void playGame();
    public abstract void switchPlayer();
    public abstract void setBoard();
    public abstract void displayScore();

    
}