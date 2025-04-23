/**
 * GameLauncher.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 *
 * This class is the class to launch the game.
 */

package game;

public class GameLauncher {
    private Legends legends;

    public GameLauncher(){
        legends = new Legends();
    }

    public void startGame(){
        legends.startGame();
    }
}
