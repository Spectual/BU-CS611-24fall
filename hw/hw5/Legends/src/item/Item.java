/**
 * Item.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This abstract class defines the item in the game.
 * It contains the name, price, and level of the item.
 */

package item;

public abstract class Item {
    protected String name;
    protected int price;
    protected int level;

    protected Item(String name, int price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }
}
