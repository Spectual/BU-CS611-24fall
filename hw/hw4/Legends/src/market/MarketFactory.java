/**
 * MarketFactory.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class is a factory class that creates a market with random items.
 * It reads the configuration files for weapons, armors, potions, and spells,
 * and creates a market with random items from each category.
 */
package market;

import item.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MarketFactory {
    private static final int ITEMS_PER_TYPE = 3; 
    private static final Random RANDOM = new Random();

    public static Market createMarket() {
        List<Weapon> weapons = getRandomItems(loadWeapons("src/config/Weaponry.txt"), ITEMS_PER_TYPE);
        List<Armor> armors = getRandomItems(loadArmors("src/config/Armory.txt"), ITEMS_PER_TYPE);
        List<Potion> potions = getRandomItems(loadPotions("src/config/Potions.txt"), ITEMS_PER_TYPE);
        List<Spell> fireSpells = getRandomItems(loadSpells("src/config/FireSpells.txt", SpellType.FIRE), ITEMS_PER_TYPE);
        List<Spell> iceSpells = getRandomItems(loadSpells("src/config/IceSpells.txt", SpellType.ICE), ITEMS_PER_TYPE);
        List<Spell> lightningSpells = getRandomItems(loadSpells("src/config/LightningSpells.txt", SpellType.LIGHTNING), ITEMS_PER_TYPE);

        List<Spell> spells = new ArrayList<>();
        spells.addAll(fireSpells);
        spells.addAll(iceSpells);
        spells.addAll(lightningSpells);

        return new Market(weapons, armors, potions, spells);
    }

    // load weapons data
    private static List<Weapon> loadWeapons(String filename) {
        List<Weapon> weapons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name")) continue;
                String[] data = line.trim().split("\\s+");
                String name = data[0].replace("_", " ");
                int cost = Integer.parseInt(data[1]);
                int level = Integer.parseInt(data[2]);
                int damage = Integer.parseInt(data[3]);
                int handsRequired = Integer.parseInt(data[4]);
                weapons.add(new Weapon(name, cost, level, damage, handsRequired));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weapons;
    }

    // load armors data
    private static List<Armor> loadArmors(String filename) {
        List<Armor> armors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name")) continue;
                String[] data = line.trim().split("\\s+");
                String name = data[0].replace("_", " ");
                int cost = Integer.parseInt(data[1]);
                int level = Integer.parseInt(data[2]);
                int damageReduction = Integer.parseInt(data[3]);
                armors.add(new Armor(name, cost, level, damageReduction));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return armors;
    }

    // load potions data
    private static List<Potion> loadPotions(String filename) {
        List<Potion> potions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name")) continue;
                String[] data = line.trim().split("\\s+");
                String name = data[0].replace("_", " ");
                int cost = Integer.parseInt(data[1]);
                int level = Integer.parseInt(data[2]);
                int effectAmount = Integer.parseInt(data[3]);
                String[] effects = data[4].split("/");
                EffectType[] effectTypes = new EffectType[effects.length];
                for (int i = 0; i < effects.length; i++) {
                    effectTypes[i] = EffectType.valueOf(effects[i].toUpperCase());
                }
                potions.add(new Potion(name, cost, level, effectAmount, effectTypes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return potions;
    }

    // load spells data
    private static List<Spell> loadSpells(String filename, SpellType spellType) {
        List<Spell> spells = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name")) continue;
                String[] data = line.trim().split("\\s+");
                String name = data[0].replace("_", " ");
                int cost = Integer.parseInt(data[1]);
                int level = Integer.parseInt(data[2]);
                int damage = Integer.parseInt(data[3]);
                int manaCost = Integer.parseInt(data[4]);
                spells.add(new Spell(name, cost, level, spellType, damage, manaCost));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return spells;
    }

    // get random items from a list
    private static <T> List<T> getRandomItems(List<T> items, int count) {
        List<T> randomItems = new ArrayList<>(items);
        Collections.shuffle(randomItems, RANDOM);
        return randomItems.subList(0, Math.min(count, randomItems.size()));
    }
}
