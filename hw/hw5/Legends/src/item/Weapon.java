/**
 * Weapon.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This class defines the weapon item in the game.
 * It extends the Item class.
 * It contains the damage and hands required of the weapon.
 */

package item;

public class Weapon extends Item {
    private int damage;
    private int handsRequired;


    public Weapon(String name, int price, int level, int damage, int handsRequired) {
        super(name, price, level);
        this.damage = damage;
        this.handsRequired = handsRequired;
    }

    public int getDamage() {
        return damage;
    }

    public int getHandsRequired() {
        return handsRequired;
    }

    public static String getHeader() {
        return String.format("%-20s %-10s %-10s %-10s %-15s", "Name", "Price", "Level", "Damage", "Hands Req");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10d %-10d %-10d %-15d", getName(), getPrice(), getLevel(), damage, handsRequired);
    }
}
