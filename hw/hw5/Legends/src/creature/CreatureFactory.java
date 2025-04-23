/**
 * CharacterFactory.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 *
 * This class is the factory class for creating creatures from configuration files.
 * It reads the configuration files for heroes and monsters and creates a list of characters.
 */

package creature;

import util.Printer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatureFactory {
    private CreatureFactory() {}

    // Create a list of heroes from the configuration file
    public static List<Hero> createHeroesFromConfig(HeroType type) {
        List<Hero> heroes = new ArrayList<>();
        String filename;

        if (type == HeroType.WARRIOR) {
            filename = "src/data/Warriors.txt";
        } else if (type == HeroType.SORCERER) {
            filename = "src/data/Sorcerers.txt";
        } else if (type == HeroType.PALADIN) {
            filename = "src/data/Paladins.txt";
        } else {
            return heroes;  
        }

        // Read the file and create a list of heroes
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("Name")) {
                    continue;
                }

                String[] data = line.split("\\s+");
                
                if (data.length >= 7) {
                    String name = data[0].replace("_", " ");
                    int MP = Integer.parseInt(data[1]);
                    int strength = Integer.parseInt(data[2]);
                    int agility = Integer.parseInt(data[3]);
                    int dexterity = Integer.parseInt(data[4]);
                    int gold = Integer.parseInt(data[5]);
                    int experience = Integer.parseInt(data[6]);

                    // Add the hero to the list
                    heroes.add(new Hero(type, name, MP, strength, agility, dexterity, gold, experience));
                } else {
                    Printer.printError("Data format error, skip the line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return heroes;
    }

    // Create a list of monsters from the configuration file
    public static List<Monster> createMonstersFromConfig(MonsterType type) {
        List<Monster> monsters = new ArrayList<>();
        String filename;

        if (type == MonsterType.DRAGON) {
            filename = "src/data/Dragons.txt";
        } else if (type == MonsterType.EXOSKELETON) {
            filename = "src/data/Exoskeletons.txt";
        } else if (type == MonsterType.SPIRIT) {
            filename = "src/data/Spirits.txt";
        } else {
            return monsters;  
        }

        // Read the file and create a list of monsters
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("Name")) {
                    continue; 
                }

                String[] data = line.split("\\s+");
                
                if (data.length >= 5) {
                    String name = data[0].replace("_", " ");
                    int level = Integer.parseInt(data[1]);
                    int damage = Integer.parseInt(data[2]);
                    int defense = Integer.parseInt(data[3]);
                    int dodge = Integer.parseInt(data[4]);

                    // Add the monster to the list
                    monsters.add(new Monster(type, name, level, damage, defense, dodge));
                } else {
                    Printer.printError("Data format error, skip the line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return monsters;
    }
}