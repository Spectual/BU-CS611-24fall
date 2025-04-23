/**
 * EquipWeapon.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 * 
 * This interface defines the strategy for equipping weapon.
 * It implements the EquipStrategy interface.
 */

package strategy;

import creature.Hero;
import item.Item;
import item.Weapon;
import util.Printer;

public class EquipWeapon implements EquipStrategy {
    @Override
    public void equip(Hero hero) {
        // choose a weapon from inventory
        Item item = hero.getInventory().chooseFromCategory(hero, "WEAPON");
        if (item == null) return;
        Weapon weapon = (Weapon) item;

        hero.getInventory().removeItem(weapon);

        if (hero.getEquippedWeapon() != null) {
            hero.getInventory().addItem(hero.getEquippedWeapon());
        }

        // equip the weapon
        hero.setEquippedWeapon(weapon);
        Printer.printEvent(Printer.getHeroColorName(hero) + " equipped " + weapon.getName());
    }
}
