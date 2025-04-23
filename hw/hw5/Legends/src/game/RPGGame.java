/**
 * RPGGame.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 * 
 * This abstract class defines the RPG game.
 * It has attributes like name, board and board size.
 * It also has abstract methods to start the game and set the team.
 */

package game;

import world.Board;

public abstract class RPGGame {
    protected String name;
    protected Board board;
    protected int boardSize;

    public String getName() {
        return name;
    }

    public abstract void startGame();

    // Initialize the character team
    protected abstract void setTeam();
}
