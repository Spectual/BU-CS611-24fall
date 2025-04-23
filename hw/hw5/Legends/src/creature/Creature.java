/**
 * Character.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This abstract class defines a general creature with attributes 
 * like name, level, hp and basic behaviors like attack, take damage and dodge.
 */

package creature;

import world.SpaceType;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int hp;

    protected int initRow;
    protected int initCol;
    protected int row;
    protected int col;

    protected int index;

    protected Creature(String name) {
        this.name = name;
        this.initRow = -1;
        this.initCol = -1;
        this.row = -1;
        this.col = -1;
        this.index = -1;
    }

    public abstract void attack(Creature target);
    public abstract void takeDamage(int damage);
    public abstract boolean dodge();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getInitRow() {
        return initRow;
    }

    public int getInitCol() {
        return initCol;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void setSpawnPosition(int row, int col) {
        this.initRow = row;
        this.initCol = col;
        this.row = row;
        this.col = col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void respawn() {
        this.row = initRow;
        this.col = initCol;
    }

    public void valueBack(SpaceType spaceType) {
    }

    public void valueBonus(SpaceType spaceType) {
    }
}
