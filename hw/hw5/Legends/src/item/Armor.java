/**
 * Armor.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This class defines the armor item in the game.
 * It extends the Item class and has an additional attribute
 * damageReduction.
 */

package item;

public class Armor extends Item {
    private int damageReduction;
    
    public Armor(String name, int price, int level, int damageReduction) {
        super(name, price, level);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public static String getHeader() {
        return String.format("%-20s %-10s %-10s %-15s", "Name", "Price", "Level", "Damage Red");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10d %-10d %-15d", getName(), getPrice(), getLevel(), damageReduction);
    }
}
