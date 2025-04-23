/**
 * HeroTeam.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 *
 * This class represents a team of heroes in the game.
 * It extends the Team class and contains a list of heroes.
 * It provides methods to generate a team of heroes and get team level of all heroes.
 */

package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeroTeam extends Team{
    private Hero[] heroes;

    public HeroTeam(String name){
        this(name, 0, 0, 1);
    }

    public HeroTeam(String name, int row, int col, int count){
        super(name, row, col, count);
        generateTeam();
    }

    // Generate a team of heroes
    @Override
    public void generateTeam(){
        heroes = new Hero[count];
        Random random = new Random();
        List<Hero> allHeroes = new ArrayList<>();

        // create all heroes
        allHeroes.addAll(CharacterFactory.createHeroesFromConfig(HeroType.WARRIOR));
        allHeroes.addAll(CharacterFactory.createHeroesFromConfig(HeroType.SORCERER));
        allHeroes.addAll(CharacterFactory.createHeroesFromConfig(HeroType.PALADIN));

        for (int i = 0; i < count; i++) {
            // choose a random hero
            Hero hero = allHeroes.get(random.nextInt(allHeroes.size()));
            heroes[i] = hero;
        }
    }

    // Get the highest level of all heroes
    public int getTeamLevel(){
        int level = 0;
        for (Hero hero : heroes) {
            if (hero.getLevel() > level) {
                level = hero.getLevel();
            }
        }
        return level;
    }

    public Hero[] getHeroes(){
        return heroes;
    }
}
