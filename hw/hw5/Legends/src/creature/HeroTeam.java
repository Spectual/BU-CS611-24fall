/**
 * HeroTeam.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/21/2024
 *
 * This class represents a team of heroes in the game.
 * It extends the Team class and contains a list of heroes.
 * It provides methods to generate a team of heroes and get team level of all heroes.
 */

 package creature;

 import util.Printer;
 
 import java.util.*;
 
 public class HeroTeam extends Team{
     private List<Hero> heroes;
 
     public HeroTeam(int count){
         this("Heroes", count);
     }
 
     public HeroTeam(String name, int count){
         super(name, count);
     }

     public HeroTeam(String name, int row, int col, int count){
         super(name, row, col, count);
     }
 
     // Generate a team of heroes
     @Override
     public void generateTeam(){
         heroes = new ArrayList<>();
         addHeroes(count);
     }
 
     // Add new heroes to the team by count
     public void addHeroes(int count){
         List<Hero> newHeroes = generateHeroes(count);
 
         for (int i = 0; i < count; i++) {
             Hero hero = newHeroes.get(i);
             hero.setIndex(i+1);
             hero.setSpawnPosition(7, 3*i);
             heroes.add(hero);
         }
     }
 
     // Generate new heroes by count
     // Generate new heroes by user selection
     public List<Hero> generateHeroes(int count) {
         List<Hero> allHeroes = new ArrayList<>();
         List<Hero> selectedHeroes = new ArrayList<>();
 
         // Create all heroes
         allHeroes.addAll(CreatureFactory.createHeroesFromConfig(HeroType.WARRIOR));
         allHeroes.addAll(CreatureFactory.createHeroesFromConfig(HeroType.SORCERER));
         allHeroes.addAll(CreatureFactory.createHeroesFromConfig(HeroType.PALADIN));
 
         // Display all heroes for user selection
         Printer.println("Available Heroes:");
         Printer.displayAllHeroes(allHeroes.toArray(new Hero[0]));
 
         // Let the user select heroes
         Scanner scanner = new Scanner(System.in);
         Set<Integer> selectedIndices = new HashSet<>();
 
         Printer.println("\nPlease select " + count + " heroes by entering their serial numbers (1-" + allHeroes.size() + "):");
         while (selectedHeroes.size() < count) {
             try {
                 Printer.print("Enter hero number: ");
                 int choice = scanner.nextInt();
 
                 // Validate input
                 if (choice < 1 || choice > allHeroes.size()) {
                     Printer.printError("Invalid choice. Please select a number between 1 and " + allHeroes.size() + ".");
                 } else if (selectedIndices.contains(choice)) {
                     Printer.printError("You already selected this hero. Please choose another.");
                 } else {
                     Hero chosenHero = allHeroes.get(choice - 1);
                     selectedHeroes.add(chosenHero);
                     selectedIndices.add(choice);
                     Printer.printEvent("Hero " + "\033[33m" + chosenHero.getName() + "\033[0m" + " has been added to your team.");
                 }
             } catch (InputMismatchException e) {
                 Printer.printError("Invalid input. Please enter a number between 1 and " + allHeroes.size() + ".");
                 scanner.next(); // Clear the invalid input
             }
         }
 
         return selectedHeroes;
     }
 
     // Get the highest level of all heroes
     public int getLevel(){
         int level = 0;
         for (Hero hero : heroes) {
             if (hero.getLevel() > level) {
                 level = hero.getLevel();
             }
         }
         return level;
     }
 
     public Hero[] getHeroes(){
         return heroes.toArray(new Hero[0]);
     }
 
     public Hero getHero(int index){
         return heroes.get(index-1);
     }
 }
 