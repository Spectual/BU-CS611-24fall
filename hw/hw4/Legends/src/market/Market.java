/**
 * Market.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 * 
 * This class defines the market in the game.
 * It implements the Store interface and provides methods for the hero to buy items
 * and sell items to the market.
 * The market contains weapons, armors, potions, and spells for sale.
 */

package market;

import character.*;
import item.*;
import action.*;
import util.*;
import interfaces.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Market implements Store {
    private Map<Weapon, Integer> weaponStock = new HashMap<>();
    private Map<Armor, Integer> armorStock = new HashMap<>();
    private Map<Potion, Integer> potionStock = new HashMap<>();
    private Map<Spell, Integer> spellStock = new HashMap<>();

    private static final Random RANDOM = new Random();

    public Market(List<Weapon> weaponList, List<Armor> armorList, List<Potion> potionList, List<Spell> spellList) {
        addItemsWithRandomQuantity(weaponStock, weaponList);
        addItemsWithRandomQuantity(armorStock, armorList);
        addItemsWithRandomQuantity(potionStock, potionList);
        addItemsWithRandomQuantity(spellStock, spellList);
    }

    // Add items to the market with random quantity (1-3)
    private <T> void addItemsWithRandomQuantity(Map<T, Integer> stock, List<T> items) {
        for (T item : items) {
            stock.put(item, RANDOM.nextInt(3) + 1); 
        }
    }

    // Let the hero choose an item from a specific category
    public <T extends Item> Item chooseFromCategory(Hero hero, String categoryName) {
        // Display the category
        Printer.println("\n======== " + "\033[36m" + categoryName + "\033[0m" + " FOR SALE ========");
        String header;
        Map<? extends Item, Integer> stock = null;

        switch (categoryName) {
            case "WEAPON":
                header = String.format("%-7s", "Index") + String.format("%-10s", "Quantity") + Weapon.getHeader();
                stock = weaponStock;
                break;
            case "ARMOR":
                header = String.format("%-7s", "Index") + String.format("%-10s", "Quantity") + Armor.getHeader();
                stock = armorStock;
                break;
            case "POTION":
                header = String.format("%-7s", "Index") + String.format("%-10s", "Quantity") + Potion.getHeader();
                stock = potionStock;
                break;
            case "SPELL":
                header = String.format("%-7s", "Index") + String.format("%-10s", "Quantity") + Spell.getHeader();
                stock = spellStock;
                break;
            default:
                header = "";
                break;
        }

        Printer.println(header);    
        int i = 1;
        for (Map.Entry<? extends Item, Integer> entry : stock.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            Printer.println(String.format("%-7d", i) + String.format("%-10d", quantity) + item);
            i++;
        }

        Printer.println("================================");
        
        while (true) {
            // Ask the hero to choose an item
            int itemChoice = InputHandler.getIntInput("\n<Market> Enter the index of item you favor ('0' to exit): ", 0, stock.size());
            if (itemChoice == 0) return null;

            // Check if the item choice is valid and buy the item
            Item selectedItem = getItemByIndex(stock, itemChoice - 1);
            if (selectedItem != null) {
                if (buyItem(hero, selectedItem)){
                    return selectedItem;
                }
            } else {
                Printer.println("Invalid item choice.");
            }
        }
    }

    // Get the item at a specific index in the stock
    private Item getItemByIndex(Map<? extends Item, Integer> stock, int index) {
        int i = 0;
        for (Item item : stock.keySet()) {
            if (i == index) return item;
            i++;
        }
        return null;
    }

    // Hero buys an item from the market
    public boolean buyItem(Hero hero, Item item) {
        Map<? extends Item, Integer> stock = getStockMap(item);

        if (stock == null || !stock.containsKey(item) || stock.get(item) <= 0) {
            Printer.printFail(item.getName() + " is out of stock.");
            return false;
        }

        if (hero.getGold() < item.getPrice()) {
            Printer.printFail("\033[33m" + hero.getName() + "\033[0m" + "'s gold is not enough to buy " + item.getName());
            return false;
        }

        if (hero.getLevel() < item.getLevel()) {
            Printer.printFail("\033[33m" + hero.getName() + "\033[0m" + " level is too low to buy " + item.getName());
            return false;
        }

        if (hero.getInventory().contains(item)) {
            Printer.printFail("\033[33m" + hero.getName() + "\033[0m" + " already has " + item.getName());
            return false;
        }

        hero.decreaseGold(item.getPrice());
        hero.getInventory().addItem(item);

        decreaseItemQuantity((Map<Item, Integer>) stock, item);
        Printer.printEvent("\033[33m" + hero.getName() + "\033[0m" + " successfully purchased " + item.getName() + " for " + item.getPrice() + " gold.");
        return true;
    }

    // Hero sells an item to the market
    public boolean sellItem(Hero hero, Item item) {
        if (!hero.getInventory().contains(item)) {
            Printer.printFail("Item not found in hero's inventory.");
            return false;
        }

        Map<? extends Item, Integer> stock = getStockMap(item);
        int sellPrice = item.getPrice() / 2;  // sell at half price
        hero.increaseGold(sellPrice);
        hero.getInventory().removeItem(item);

        increaseItemQuantity((Map<Item, Integer>) stock, item);
        Printer.printEvent("\033[33m" + hero.getName() + "\033[0m" + " successfully sold " + item.getName() + " for " + sellPrice + " gold.");
        return true;
    }

    //  Get the stock map based on the item type
    private Map<? extends Item, Integer> getStockMap(Item item) {
        if (item instanceof Weapon) return weaponStock;
        if (item instanceof Armor) return armorStock;
        if (item instanceof Potion) return potionStock;
        if (item instanceof Spell) return spellStock;
        return null;
    }

    // Decrease the quantity of an item in the stock
    private <T extends Item> void decreaseItemQuantity(Map<T, Integer> stock, T item) {
        stock.put(item, stock.get(item) - 1);
        if (stock.get(item) <= 0) {
            stock.remove(item);
        }
    }

    // Increase the quantity of an item in the stock
    private <T> void increaseItemQuantity(Map<T, Integer> stock, T item) {
        stock.put(item, stock.getOrDefault(item, 0) + 1);
    }

    public Map<Weapon, Integer> getWeapons() { return weaponStock; }
    public Map<Armor, Integer> getArmors() { return armorStock; }
    public Map<Potion, Integer> getPotions() { return potionStock; }
    public Map<Spell, Integer> getSpells() { return spellStock; }
}