/**
 * MonsterTeam.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 *
 * This class defines the monster team in the game.
 * It extends the Team class and has additional attributes like monsters.
 * It also has a method to generate a team of monsters.
 */


package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterTeam extends Team{
    private Monster[] monsters;

    public MonsterTeam(int count){
        super("Monsters", 0, 0, count);
        generateTeam();
    }

    @Override
    public void generateTeam(){
        monsters = new Monster[count];
        Random random = new Random();
        List<Monster> allMonsters = new ArrayList<>();

        // create all heroes
        allMonsters.addAll(CharacterFactory.createMonstersFromConfig(MonsterType.DRAGON));
        allMonsters.addAll(CharacterFactory.createMonstersFromConfig(MonsterType.EXOSKELETON));
        allMonsters.addAll(CharacterFactory.createMonstersFromConfig(MonsterType.SPIRIT));

        for (int i = 0; i < count; i++) {
            // choose a random monster
            Monster monster = allMonsters.get(random.nextInt(allMonsters.size()));
            monsters[i] = monster;
        }
    }

    public Monster[] getMonsters(){
        return monsters;
    }
}
