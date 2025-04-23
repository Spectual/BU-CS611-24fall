/**
 * MonsterTeam.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 *
 * This class defines the monster team in the game.
 * It extends the Team class and has additional attributes like monsters.
 * It also has a method to generate a team of monsters.
 */


package creature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonsterTeam extends Team{
    private List<Monster> monsters;
    private int maxIndex;

    public MonsterTeam(int count){
        super("Monsters", count);
    }

    @Override
    public void generateTeam(){
        maxIndex = 0;
        monsters = new ArrayList<>();
        addMonsters(count);
    }

    // Add new monsters to the team by count
    public void addMonsters(int count){
        List<Monster> newMonsters = generateMonsters(count);

        for (int i = 0; i < count; i++) {
            Monster monster = newMonsters.get(i);
            maxIndex += 1;
            monster.setIndex(maxIndex);
            monster.setSpawnPosition(0, 3*i + 1);
            monsters.add(monster);
        }
    }

    // Add new monsters to the team by count and level
    public void addMonsters(int count, int level){
        List<Monster> newMonsters = generateMonsters(count);

        for (int i = 0; i < count; i++) {
            Monster monster = newMonsters.get(i);
            maxIndex += 1;
            monster.setIndex(maxIndex);
            monster.setSpawnPosition(0, 3*i + 1);
            monster.setLevel(level);
            monsters.add(monster);
        }
    }

    // Generate new monsters by count
    public List<Monster> generateMonsters(int count){
        List<Monster> newMonsters;
        List<Monster> allMonsters = new ArrayList<>();

        // create all heroes
        allMonsters.addAll(CreatureFactory.createMonstersFromConfig(MonsterType.DRAGON));
        allMonsters.addAll(CreatureFactory.createMonstersFromConfig(MonsterType.EXOSKELETON));
        allMonsters.addAll(CreatureFactory.createMonstersFromConfig(MonsterType.SPIRIT));

        // choose 3 different monsters randomly
        Collections.shuffle(allMonsters);

        newMonsters = allMonsters.subList(0, count);

        return newMonsters;
    }

    // Remove a monster from the team
    public void removeMonster(Monster monster){
        monsters.remove(monster);
    }

    // Get all monsters
    public Monster[] getMonsters(){
        return monsters.toArray(new Monster[0]);
    }

    // Get a monster by index
    public Monster getMonster(int index){
        Monster monster = null;
        for (Monster m : monsters) {
            if (m.getIndex() == index) {
                monster = m;
            }
        }
        return monster;
    }

    // Set the level of all monsters
    public void setLevel(int level) {
        for (Monster monster : monsters) {
            monster.setLevel(level);
        }
    }
}
