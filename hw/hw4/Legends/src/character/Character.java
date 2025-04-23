/**
 * Character.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This abstract class defines a general character with attributes 
 * like name, level, hp and basic behaviors like attack, take damage and dodge.
 */

package character;

public abstract class Character {
    protected String name;
    protected int level;
    protected int hp;

    protected Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character target);
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
}
