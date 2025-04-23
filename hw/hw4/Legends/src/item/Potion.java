/**
 * Potion.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class defines the potion item in the game.
 * It extends the Item class and implements the Effect interface.
 * It contains the effect amount and effect types of the potion.
 * It also contains the effect method that applies the effect to the target hero.
 */

package item;

import character.Character;
import character.Hero;
import interfaces.Effect;

import java.util.Arrays;

public class Potion extends Item implements Effect{
    private int effectAmount;
    private EffectType[] effectTypes;

    public Potion(String name, int price, int level, int effectAmount, EffectType[] effectTypes) {
        super(name, price, level);
        this.effectAmount = effectAmount;
        this.effectTypes = effectTypes;
    }

    // Potion effect applies to the target hero
    public void effect(Character target) {
        Hero hero = (Hero) target;
        for (EffectType effectType : effectTypes) {
            switch (effectType) {
                case HP:
                    hero.heal(effectAmount);
                    break;
                case MP:
                    hero.restoreMp(effectAmount);
                    break;
                case STRENGTH:
                    hero.increaseStrength(effectAmount);
                    break;
                case DEXTERITY:
                    hero.increaseDexterity(effectAmount);
                    break;
                case DEFENSE:
                    hero.increaseDefense(effectAmount);
                    break;
                case AGILITY:
                    hero.increaseAgility(effectAmount);
                    break;
                default:
                    break;
            }
        }
    }

    public int getEffectAmount() {
        return effectAmount;
    }

    public EffectType[] getEffectTypes() {
        return effectTypes;
    }

    public static String getHeader() {
        return String.format("%-20s %-10s %-10s %-15s %-20s", "Name", "Price", "Level", "Effect Amt", "Effect Type");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10d %-10d %-15d %-20s", getName(), getPrice(), getLevel(), effectAmount, Arrays.toString(effectTypes));
    }
}
