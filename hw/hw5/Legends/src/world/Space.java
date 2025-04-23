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

import store.*;

public class Space {
    private SpaceType type;
    private boolean isPlayerHere;
    private int heroHere;
    private int monsterHere;
    private Market market;

    public Space(SpaceType type){
        this.isPlayerHere = false;
        this.heroHere = 0;
        this.monsterHere = 0;
        setType(type);
    }
    
    public SpaceType getType(){
        return type;
    }
    
    public void setType(SpaceType type){
        this.type = type;
        this.market = null;
        if (type == SpaceType.H_NEXUS || type == SpaceType.MARKET) {
            this.market = MarketFactory.createMarket();
        }
    }

    public Market getMarket(){
        return market;
    }

    public boolean checkHeroHere(){
        return heroHere != 0;
    }

    public boolean checkMonsterHere(){
        return monsterHere != 0;
    }

    public boolean checkPlayerHere(){
        return isPlayerHere;
    }

    public void setPlayerHere(boolean isPlayerHere){
        this.isPlayerHere = isPlayerHere;
    }   

    public int getHeroHere(){
        return heroHere;
    }

    public int getMonsterHere(){
        return monsterHere;
    }

    public void setHeroHere(int heroHere){
        this.heroHere = heroHere;
    }   

    public void setMonsterHere(int monsterHere){
        this.monsterHere = monsterHere;
    }

    public boolean isAccessible(){
        return (type != SpaceType.IMPASSIBLE);
    }

    public String toString(){
        if (heroHere != 0 && monsterHere != 0) {
            if (monsterHere >= 10) {
                return "\033[33m" + "H" + (heroHere) + "\033[0m" + "\033[35m" + "M" + (monsterHere) + "\033[0m";
            }
            return "\033[33m" + "H" + (heroHere) + "\033[0m"+ " " + "\033[35m" + "M" + (monsterHere) + "\033[0m";
        }
        if (heroHere != 0 && monsterHere == 0) {
            return "  \033[33m" + "H" + (heroHere) + "\033[0m ";
        }
        if (heroHere == 0 && monsterHere != 0) {
            if (monsterHere >= 10) {
                return " \033[35m" + "M" + (monsterHere) + "\033[0m ";
            }
            return "  \033[35m" + "M" + (monsterHere) + "\033[0m ";
        }

        if (type == SpaceType.IMPASSIBLE) {
            return "\033[31m" + "  X  " + "\033[0m";
        } else if (type == SpaceType.H_NEXUS) {
            return "\033[33m" + "  N  " + "\033[0m";
        } else if (type == SpaceType.M_NEXUS) {
            return "\033[35m" + "  N  " + "\033[0m";
        }  else if (type == SpaceType.BUSH) {
            return  "  B  " ;
        } else if (type == SpaceType.CAVE) {
            return "  C  " ;
        } else if (type == SpaceType.KOULOU) {
            return "  K  " ;
        }

        if (isPlayerHere) {
            return "\033[33m" + "  U  " + "\033[0m";
        }

        if (type == SpaceType.MARKET) {
            return "\033[34m" + "  M  " + "\033[0m";
        } else {
            return "     ";
        }
    }

}
