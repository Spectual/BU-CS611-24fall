/**
 * Space.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class defines the space on the board in the game.
 * It contains the type of the space, whether the player is here, 
 * the market on the space, and the methods to access these attributes.
 */

package world;

import market.*;

public class Space {
    private SpaceType type;
    private boolean isPlayerHere;
    private Market market;

    public Space(SpaceType type){
        this.isPlayerHere = false;
        setType(type);
    }
    
    public SpaceType getType(){
        return type;
    }
    
    public void setType(SpaceType type){
        this.type = type;
        this.market = null;
        if (type == SpaceType.MARKET) {
            this.market = MarketFactory.createMarket();
        }
    }

    public Market getMarket(){
        return market;
    }

    public boolean checkPlayerHere(){
        return isPlayerHere;
    }

    public void setPlayerHere(boolean isPlayerHere){
        this.isPlayerHere = isPlayerHere;
    }   

    public boolean isAccessible(){
        return type != SpaceType.INACCESSIBLE;
    }

    public String toString(){
        if (isPlayerHere) {
            return "\033[33m" + "U" + "\033[0m";
        }
        if (type == SpaceType.INACCESSIBLE) {
            return "\033[31m" + "X" + "\033[0m";
        } else if (type == SpaceType.MARKET) {
            return "\033[34m" + "M" + "\033[0m";
        } else {
            return " ";
        }
    }

}
