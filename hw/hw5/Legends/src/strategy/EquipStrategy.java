/**
 * EquipStrategy.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 * 
 * This interface defines the strategy for equipping items.
 * It has a single method equip().
 */

package strategy;

import creature.Hero;

public interface EquipStrategy {
    public void equip(Hero hero);
}
