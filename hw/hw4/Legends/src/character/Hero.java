/**
 * Hero.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 *
 * This class defines the hero character in the game.
 * It extends the Character class and has additional attributes 
 * like type, experience, strength, agility, dexterity, gold, 
 * inventory, equipped weapon and armor.
 * 
 * It also has methods to level up, gain experience, gain rewards,
 * attack, take damage, dodge, cast spell, use potion, equip weapon,
 * equip armor, recover, heal, restore MP, increase attributes, check
 * if fainted, revive with penalty, and toString.
 */

package character;

import inventory.Inventory;
import item.*;
import util.Printer;

import java.util.Arrays;

public class Hero extends Character {
    private HeroType type;
    private int experience;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int strength;
    private int agility;
    private int dexterity;
    private int defense;
    private boolean isStrengthFavored;
    private boolean isAgilityFavored;
    private boolean isDexterityFavored;
    private int gold;
    private Inventory inventory;
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Hero(HeroType type, String name, int mp, int strength, int agility, int dexterity, int gold, int experience) {
        super(name);
        this.type = type;
        this.mp = mp;
        this.maxMp = mp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.experience = experience;
        this.defense = 0;
        this.inventory = new Inventory();
        this.equippedWeapon = null;
        this.equippedArmor = null;

        this.isStrengthFavored = (type != HeroType.SORCERER);
        this.isAgilityFavored = (type != HeroType.PALADIN);
        this.isDexterityFavored = (type != HeroType.WARRIOR);

        this.setLevel();
        this.setHP();
    }

    public void setLevel() {
        level = (int) Math.ceil(experience / 10.0);
    }

    public void setHP() {
        maxHp = level * 100;
        hp = maxHp;
    }

    public void setMP() {
        maxMp = (int) (mp * 1.1);
    }

    public boolean checkLevelUp() {
        return experience > level * 10;
    }

    // Level up the hero
    public void levelUp() {
        setLevel();
        setHP();
        setMP();
        strength = isStrengthFavored ? (int) (strength * 1.1) : (int) (strength * 1.05);
        agility = isAgilityFavored ? (int) (agility * 1.1) : (int) (agility * 1.05);
        dexterity = isDexterityFavored ? (int) (dexterity * 1.1) : (int) (dexterity * 1.05);

        Printer.printEvent(Printer.getHeroColorName(this) + " Level up to " + level + "!");
    }

    // Gain experience after defeating monsters
    public void gainExperience(int monsterCount) {
        int gain = monsterCount * 2;
        experience += gain;
        Printer.printEvent(Printer.getHeroColorName(this) + " gained " + gain + " experience!");
        if (checkLevelUp()) {
            levelUp();
        }
    }

    public void increaseGold(int monsterLevel) {
        int gain = monsterLevel * 100;
        gold += gain;
        Printer.printEvent(Printer.getHeroColorName(this) + " gained " + gain + " gold!");
    }

    public void decreaseGold(int amount) {
        gold -= amount;
    }

    // Gain rewards after defeating monsters
    public void gainRewards(Monster[] monsters) {
        int totalMonsterLevel = 0;
        // calculate total experience and gold
        for (Monster monster : monsters) {
            totalMonsterLevel += monster.getLevel();          
        }
    
        if (!isFainted()) {
            gainExperience(monsters.length);  
            increaseGold(totalMonsterLevel);          
        } else {
            reviveWithPenalty();  // hero who fainted will be revived with half HP and MP
        }
    }

    // Attack a monster
    public void attack(Character target) {
        int baseDamage = (int) ((strength + (equippedWeapon != null ? equippedWeapon.getDamage() : 0)) * 0.05);
        if (!target.dodge()) {
            target.takeDamage(baseDamage);
        } else {
            Printer.printHeroTurn(Printer.getMonsterColorName(target) + " dodged the attack!");
        }
    }

    // Take damage from a monster
    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max((equippedArmor != null) ? damage - equippedArmor.getDamageReduction() - defense : damage - defense, 0);
        hp = Math.max(0, hp - reducedDamage);
        Printer.printHeroTurn(Printer.getHeroColorName(this) + " took " + reducedDamage + " damage and now has " + hp + " HP left.");
    }

    // Dodge a monster's attack
    @Override
    public boolean dodge() {
        return Math.random() < agility * 0.001;
    }

    // Choose from inventory and cast a spell on a monster
    public boolean castSpell(Monster target) {
        // choose a spell from inventory
        Item item = inventory.chooseFromCategory(this, "SPELL");
        if (item == null) return false;
        Spell spell = (Spell) item;

        // check if hero has enough mana
        if (mp < spell.getManaCost()) {
            Printer.printFail(Printer.getHeroColorName(this) + " does not have enough mana.");
            return false;
        }

        inventory.removeItem(spell);    

        // calculate spell damage and apply it to the monster
        int spellDamage = (int) (spell.getDamage() + ((double) dexterity / 10000) * spell.getDamage());
        mp -= spell.getManaCost();

        if (!target.dodge()) {
            target.takeDamage(spellDamage);
            Printer.printHeroTurn(Printer.getHeroColorName(this) + " cast " + spell.getName() + " on " + Printer.getMonsterColorName(target) + " for " + spellDamage + " damage!");
        } else {
            Printer.printHeroTurn(Printer.getMonsterColorName(target) + " dodged the spell attack! However...");
        }

        spell.effect(target);

        return true;
    }

    // Choose from inventory and use a potion
    public void usePotion() {
        // choose a potion from inventory
        Item item = inventory.chooseFromCategory(this, "POTION");
        if (item == null) return;
        Potion potion = (Potion) item;

        inventory.removeItem(potion);

        // use the potion
        potion.effect(this);
        Printer.printEvent(Printer.getHeroColorName(this) + " used a potion and lifted " + Arrays.toString(potion.getEffectTypes()));
    }

    // Choose from inventory and equip a weapon
    public void equipWeapon() {
        // choose a weapon from inventory
        Item item = inventory.chooseFromCategory(this, "WEAPON");
        if (item == null) return;
        Weapon weapon = (Weapon) item;

        inventory.removeItem(weapon);

        if (equippedWeapon != null) {
            inventory.addItem(equippedWeapon);
        }

        // equip the weapon
        equippedWeapon = weapon;
        Printer.printEvent(Printer.getHeroColorName(this) + " equipped " + weapon.getName());
    }

    // Choose from inventory and equip an armor
    public void equipArmor() {
        // choose a armor from inventory
        Item item = inventory.chooseFromCategory(this, "ARMOR");
        if (item == null) return;
        Armor armor = (Armor) item;

        inventory.removeItem(armor);

        if (equippedArmor != null) {
            inventory.addItem(equippedArmor);
        }

        // equip the armor
        equippedArmor = armor;
        Printer.printEvent(Printer.getHeroColorName(this) + " equipped " + armor.getName());
    }

    // Recover some health and mana
    public void recover() {
        if (hp != maxHp || mp != maxMp) {
            Printer.printEmptyLine();
            Printer.printEvent(Printer.getHeroColorName(this) + " recovered some health and mana.");
        }
        hp = Math.min(maxHp, (int) (hp * 1.1));
        mp = Math.min(maxMp, (int) (mp * 1.1));
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }

    public void restoreMp(int amount) {
        mp = Math.min(maxMp, mp + amount);
    }

    public void increaseDexterity(int amount) {
        dexterity += amount;
    }

    public void increaseAgility(int amount) {
        agility += amount;
    }

    public void increaseStrength(int amount) {
        strength += amount;
    }

    public void increaseDefense(int amount) {
        defense += amount;
    }

    public boolean isFainted() {
        return hp <= 0;
    }

    public void reviveWithPenalty() {
        hp = maxHp / 2;
        mp = maxMp / 2;
        Printer.printEvent(Printer.getHeroColorName(this) + " has been revived with half HP and Mana.");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s %-10d %-15d %-10d %-10d %-10d %-10d %-10d %-10d %-20s %-20s",
                name, type, level, experience, hp, mp, strength, agility, dexterity, gold, 
                equippedWeapon==null ? "NULL" : equippedWeapon.getName(), 
                equippedArmor==null ? "NULL" : equippedArmor.getName());
    }

    public HeroType getType() { return type; }
    public int getExperience() { return experience; }
    public int getMp() { return mp; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getDexterity() { return dexterity; }
    public int getGold() { return gold; }
    public Inventory getInventory() { return inventory; }
}