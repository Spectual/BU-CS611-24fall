/**
 * Inventory.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This class defines the inventory of a hero, which contains 
 * weapons, armors, potions and spells.
 * It has methods to add, remove, check, get and display items.
 * It also has a method to let the hero choose an item from a specific category.
 */

package store;

import item.*;
import util.Printer;
import interfaces.Store;

import java.util.ArrayList;
import java.util.List;

import action.InputHandler;
import creature.Hero;

public class Inventory implements Store {
    private List<Weapon> weapons;
    private List<Armor> armors;
    private List<Potion> potions;
    private List<Spell> spells;

    public Inventory() {
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.spells = new ArrayList<>();
    }

    public boolean isEmpty() {
        return weapons.isEmpty() && armors.isEmpty() && potions.isEmpty() && spells.isEmpty();
    }

    // Add an item to the inventory
    public void addItem(Item item) {
        if (item instanceof Weapon) {
            weapons.add((Weapon) item);
        } else if (item instanceof Armor) {
            armors.add((Armor) item);
        } else if (item instanceof Potion) {
            potions.add((Potion) item);
        } else if (item instanceof Spell) {
            spells.add((Spell) item);
        }
    }

    // Remove an item from the inventory
    public boolean removeItem(Item item) {
        if (item instanceof Weapon) {
            return weapons.remove(item);
        } else if (item instanceof Armor) {
            return armors.remove(item);
        } else if (item instanceof Potion) {
            return potions.remove(item);
        } else if (item instanceof Spell) {
            return spells.remove(item);
        }
        return false;
    }

    // Check if the inventory contains an item
    public boolean contains(Item item) {
        if (item instanceof Weapon) {
            return weapons.contains(item);
        } else if (item instanceof Armor) {
            return armors.contains(item);
        } else if (item instanceof Potion) {
            return potions.contains(item);
        } else if (item instanceof Spell) {
            return spells.contains(item);
        }
        return false;
    }

    // Get all items in the inventory
    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>();
        allItems.addAll(weapons);
        allItems.addAll(armors);
        allItems.addAll(potions);
        allItems.addAll(spells);
        return allItems;
    }

        // Let the hero choose an item from a specific category
    public <T extends Item> Item chooseFromCategory(Hero hero, String categoryName) {
        // Display the category
        Printer.println("\n======== " + "\033[36m" + categoryName + "\033[0m" + " ========");
        String header;
        List<? extends Item> stock = null;

        switch (categoryName) {
            case "WEAPON":
                header = String.format("%-7s", "Index") + Weapon.getHeader();
                stock = weapons;
                break;
            case "ARMOR":
                header = String.format("%-7s", "Index") + Armor.getHeader();
                stock = armors;
                break;
            case "POTION":
                header = String.format("%-7s", "Index") + Potion.getHeader();
                stock = potions;
                break;
            case "SPELL":
                header = String.format("%-7s", "Index") + Spell.getHeader();
                stock = spells;
                break;
            default:
                header = "";
                break;
        }

        if (stock.isEmpty()) {
            Printer.println("EMPTY");
            return null;
        }
        
        Printer.println(header);    
        int i = 1;
        for (Item item : stock) {
            Printer.println(String.format("%-7d", i) + item);
            i++;
        }


        Printer.println("========================");
        
        while (true) {
            // Ask the hero to choose an item
            int itemChoice = InputHandler.getIntInput("\n<Inventory> Enter the index of item you choose ('0' to exit): ", 0, stock.size());
            if (itemChoice == 0) return null;

            // Check if the item choice is valid and get the item
            Item selectedItem = getItemByIndex(stock, itemChoice - 1);
            if (selectedItem != null) {
                return selectedItem;
            } else {
                Printer.println("Invalid item choice.");
            }
        }
    }

    // Get the item at a specific index in the stock
    private Item getItemByIndex(List<? extends Item> stock, int index) {
        int i = 0;
        for (Item item : stock) {
            if (i == index) return item;
            i++;
        }
        return null;
    }

    // Get an item by its name
    public Item getItemByName(String name) {
        for (Item item : getAllItems()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    // display the inventory
    public void display() {
        if (!weapons.isEmpty()){
            Printer.println("\033[36m" + "WEAPON" + "\033[0m");
            Printer.println(Weapon.getHeader());
            weapons.forEach(Printer::println);
        }

        if (!armors.isEmpty()){
            Printer.println("\033[36m" + "ARMOR" + "\033[0m");
            Printer.println(Armor.getHeader());
            armors.forEach(Printer::println);
        }

        if (!potions.isEmpty()){
            Printer.println("\033[36m" + "POTION" + "\033[0m");
            Printer.println(Potion.getHeader());
            potions.forEach(Printer::println);
        }

        if (!spells.isEmpty()){
            Printer.println("\033[36m" + "SPELL" + "\033[0m");
            Printer.println(Spell.getHeader());
            spells.forEach(Printer::println);
        }
    }


    // clear the inventory
    public void clearInventory() {
        weapons.clear();
        armors.clear();
        potions.clear();
        spells.clear();
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public List<Spell> getSpells() {
        return spells;
    }
}