/**
 * Monster.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 *
 * This class defines the monster character in the game.
 * It extends the Character class and has additional attributes like type, damage, defense and dodge.
 */

package character;

import util.Printer;

public class Monster extends Character {
    private MonsterType type;
    private int damage;
    private int defense;
    private int dodge;

    public Monster(MonsterType type, String name, int level, int damage, int defense, int dodge) {
        super(name);
        this.type = type;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodge = dodge;
        
        setHP();
    }

    public void setHP() {
        hp = level * 100;
    }

    public void setDamage(int level) {
        damage = damage / (this.level) / 2 * level;
    }

    public void setLevel(int level) {
        setDamage(level);
        this.level = level;
        setHP();
    }

    public void decreaseDamage(int amount) {
        damage -= damage * amount / 100;
        Printer.printHeroTurn(Printer.getMonsterColorName(this) + "'s damage decreased by " + amount + "%.");
    }

    public void decreaseDefense(int amount) {
        defense -= defense * amount / 100;
        Printer.printHeroTurn(Printer.getMonsterColorName(this) + "'s defense decreased by " + amount + "%.");
    }

    public void decreaseDodge(int amount) {
        dodge -= dodge * amount / 100;
        Printer.printHeroTurn(Printer.getMonsterColorName(this) + "'s dodge chance decreased by " + amount + "%.");
    }

    // Attack hero
    public void attack(Character target) {
        if (!target.dodge()) {
            target.takeDamage(damage);
        } else {
            Printer.printMonsterTurn(Printer.getHeroColorName(target) + " dodged the attack!");
        }
    }

    // Take damage from a hero
    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(0, damage);
        hp = Math.max(0, hp - reducedDamage);
        Printer.printHeroTurn(Printer.getMonsterColorName(this) + " took " + reducedDamage + " damage and now has " + hp + " HP left.");
    }

    // Dodge a hero's attack
    @Override
    public boolean dodge() {
        return Math.random() < dodge * 0.01;
    }

    public boolean isDefeated() {
        return hp <= 0;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10d %-10d %-10d %-10d %-10d",
                             name, type, level, hp, damage, defense, dodge);
    }

    // Getter
    public MonsterType getType() { return type; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getDodge() { return dodge; } 

}