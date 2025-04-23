/**
 * Battle.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This class is responsible for the battle logic in the game.
 * It provides methods to start the battle, handle hero's turn, monster's turn, 
 * and end the battle.
 */

package battle;

import strategy.EquipArmor;
import strategy.EquipWeapon;
import util.Printer;
import action.*;
import creature.*;

public class Battle {
    private Hero[] heroes;
    private Monster[] monsters;
    private int size;

    public Battle(HeroTeam heroTeam) {
        this.heroes = heroTeam.getHeroes();
        this.size = heroTeam.getCount();
        initializeMonsters(heroTeam.getLevel());
    }

    public Battle(HeroTeam heroTeam, MonsterTeam monsterTeam) {
        this.heroes = heroTeam.getHeroes();
        this.monsters = monsterTeam.getMonsters();
        this.size = heroTeam.getCount();
    }

    // Initialize monsters
    private void initializeMonsters(int level) {
        MonsterTeam monsterTeam = new MonsterTeam(size);
        monsterTeam.setLevel(level);
        monsters = monsterTeam.getMonsters();
    }

    // Start the battle
    public void startBattle() {
        Printer.printBattleWelcome();
        Printer.displayInfo(heroes, monsters);
        
        int heroIndex = 0;  
        int monsterIndex = 0;

        while (heroIndex < heroes.length && monsterIndex < monsters.length) {
            Hero currentHero = heroes[heroIndex];
            Monster currentMonster = monsters[monsterIndex];

            if (!currentHero.isFainted() && !currentMonster.isDefeated()) {
                heroTurn(currentHero, currentMonster);

                // check if monster is defeated
                if (currentMonster.isDefeated()) {
                    Printer.printEvent(Printer.getHeroColorName(currentHero) + " defeated " + Printer.getMonsterColorName(currentMonster) + "!");
                    monsterIndex++;  
                    continue;  // skip monster's turn if defeated
                }
                
                monsterTurn(currentMonster, currentHero);

                // check if hero is fainted
                if (currentHero.isFainted()) {
                    Printer.println(currentHero.getName() + " fainted!");
                    heroIndex++;  // skip hero's turn if fainted
                }
                else{
                    currentHero.recover();
                }
            } else {
                if (currentHero.isFainted()) heroIndex++;  
                if (currentMonster.isDefeated()) monsterIndex++;  
            }
            
            // Display hero and monster information
            Printer.displayInfo(heroes, monsters);
        }

        endBattle();
    }

    // Hero's turn
    public void heroTurn(Hero hero, Monster monster) {
        boolean turnEnded = false;
        while (!turnEnded) {
            ActionType action = InputHandler.getBattleActionInput(hero);
            switch (action) {
                case ATTACK: // Attack
                    heroAttack(hero, monster);
                    turnEnded = true;
                    break;
                case CAST_SPELL: // Cast Spell
                    turnEnded = hero.castSpell(monster);
                    break;
                case USE_POTION: // Use Potion
                    hero.usePotion();
                    break;
                case EQUIP_WEAPON: // Equip weapon
                    hero.setEquipStrategy(new EquipWeapon());
                    hero.executeEquip();
                    break;
                case EQUIP_ARMOR: // Equip armor
                    hero.setEquipStrategy(new EquipArmor());
                    hero.executeEquip();
                    break;
                case INVENTORY: // Display Inventory
                    Printer.displayInventory(hero);
                    break;
                case HELP: // Display Help
                    Printer.printBattleHelp();
                    break;
                case DISPLAY_STATS: // Display Stats (does not end turn)
                    Printer.displayInfo(heroes, monsters);
                    break;
                case QUIT: // Quit
                    Printer.printQuitMessage();
                    System.exit(0);
                    break;
                default:
                    Printer.invalidActionInput();
                    break;
            }
        }
    }

    // Monster's turn
    public void monsterTurn(Monster monster, Hero hero) {
        Printer.printEmptyLine();
        Printer.printMonsterTurn(Printer.getMonsterColorName(monster) + " is attacking " + "\033[33m" + hero.getName() + "\033[0m");
        monster.attack(hero);
        if (hero.isFainted()) {
            Printer.printEvent(Printer.getHeroColorName(hero) + " fainted!");
        }
    }

    // Hero attacks monster
    private void heroAttack(Hero hero, Monster monster) {
        Printer.printEmptyLine();
        Printer.printHeroTurn(Printer.getHeroColorName(hero) + " is attacking " + "\033[35m" + monster.getName() + "\033[0m");
        hero.attack(monster);
    }

    // End battle and determine the winner
    private void endBattle() {
        if (allMonstersDefeated()) {
            Printer.printEmptyLine();
            Printer.printEvent("HEROS WIN!");
            for (Hero hero : heroes) {
                if (!hero.isFainted()) {
                    hero.gainRewards(monsters);
                } else {
                    hero.reviveWithPenalty();
                }
            }
        } else {
            Printer.println("MONSTERS WIN! GAME OVER!");
            Printer.printQuitMessage();
            System.exit(0);
        }
    }

    // Check if all monsters are defeated
    private boolean allMonstersDefeated() {
        for (Monster monster : monsters) {
            if (!monster.isDefeated()) {
                return false;
            }
        }
        return true;
    }
}