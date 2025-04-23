/**
 * Store.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This interface defines the store behavior in the game.
 * It contains the chooseFromCategory method that allows the hero to choose an item from a category.
 */

package interfaces;

import creature.*;
import item.Item;

public interface Store {
    public <T extends Item> Item chooseFromCategory(Hero hero, String categoryName);
}
