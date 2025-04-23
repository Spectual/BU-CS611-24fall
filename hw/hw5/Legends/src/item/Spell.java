/**
 * Spell.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This class defines the spell item in the game.
 * It extends the Item class and implements the Effect interface.
 * It contains the spell type, damage, and mana cost of the spell.
 * It also contains the effect method that applies the effect to the target monster.
 */

package item;

import creature.Creature;
import creature.Monster;
import interfaces.Effect;

public class Spell extends Item implements Effect {
    private SpellType spellType;
    private int damage;
    private int manaCost;

    public Spell(String name, int price, int level, SpellType spellType, int damage, int manaCost) {
        super(name, price, level);
        this.spellType = spellType;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    // Spell effect applies to the target monster
    public void effect(Creature target) {
        Monster monster = (Monster) target;
        switch (spellType) {
            case ICE:
                monster.decreaseDamage(20);
                break;
            case FIRE:
                monster.decreaseDefense(20);
                break;
            case LIGHTNING:
                monster.decreaseDodge(20);
                break;
            default:
                break;
        }
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public static String getHeader() {
        return String.format("%-20s %-10s %-10s %-15s %-10s %-15s", "Name", "Price", "Level", "Spell Type", "Damage", "Mana Cost");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10d %-10d %-15s %-10d %-15d", getName(), getPrice(), getLevel(), spellType, damage, manaCost);
    }
}
