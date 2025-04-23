/**
 * EquipArmor.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 * 
 * This class is the strategy for equipping armor.
 * It implements the EquipStrategy interface.
 */

package strategy;

import creature.Hero;
import item.Armor;
import item.Item;
import util.Printer;

public class EquipArmor implements EquipStrategy {
    @Override
    public void equip(Hero hero) {
        // choose a weapon from inventory
        Item item = hero.getInventory().chooseFromCategory(hero, "ARMOR");
        if (item == null) return;
        Armor armor = (Armor) item;

        hero.getInventory().removeItem(armor);

        if (hero.getEquippedArmor() != null) {
            hero.getInventory().addItem(hero.getEquippedArmor());
        }

        // equip the weapon
        hero.setEquippedArmor(armor);
        Printer.printEvent(Printer.getHeroColorName(hero) + " equipped " + armor.getName());
    }
}
