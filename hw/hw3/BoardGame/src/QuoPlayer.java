/**
 * QuoPlayer.java
 * by Yuanhang Xu (xxxqivzz@bu.edu), Yifei Bao (baoyifei@bu.edu)
 * 10/19/2024
 * 
 * This class represents a player in the Quoridor game. 
 * It extends the Player class and contains additional information of a player in the Quoridor game.
 * It contains the fence color, fence count, current position, and starting point of the player.
 * It contains getters and setters for these attributes, and methods to reset the player's position,
 * 
 * In this design, a QuoPlayer has fenceColor, fenceCount, currentPosition, and startingPoint attributes.
 * Each player has a unique color to represent their fences and pieces.
 * Each player has a number of fences to place on the board.
 * Each player has a starting point representing the initial position and winning goal.
*/

public class QuoPlayer extends Player {
    private String fenceColor;
    private int fenceCount;     // Store the number of fences the player has
    private int currentPosition;  // Store the player's current position as a number
    private String startingPoint;  // Store the starting point (e.g., "Up", "Down")

    
    public QuoPlayer(String name, Piece piece, String fenceColor,
                     String startingPoint, int fenceCount) {
        super(name, piece);
        this.fenceColor = fenceColor;
        this.startingPoint = startingPoint;  
        this.fenceCount = fenceCount;
        resetPosition();

    }

    public void resetPosition() {
        if (startingPoint.equals("Up")) {
            currentPosition = 5;
        } else if (startingPoint.equals("Down")) {
            currentPosition = 77;
        } else if (startingPoint.equals("Left")) {
            currentPosition = 37;
        } else if (startingPoint.equals("Right")) {
            currentPosition = 45;
        }
    }
    
    public String getFenceColor() {
        return fenceColor;
    }

    public void setFenceColor(String fenceColor) {
        this.fenceColor = fenceColor;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public int getPosition() {
        return currentPosition;
    }

    public void setfenceCount(int fenceCount) {
        this.fenceCount = fenceCount;
    }

    public int getfenceCount() {
        return fenceCount;
    }

    public void setPosition(int position) {
        this.currentPosition = position;
    }
    public void changeFenceCountBy(int change) {
        fenceCount = fenceCount + change;
    }

}
