# CS611-Assignment 5

## < Legends of Valor>

---------------------------------------------------------------------------

- Name: Yifei Bao, Tingxuan Tang
- Email: baoyifei@bu.edu, tttttx@bu.edu
- Student ID: U02463348, U33353328

## Files
action
- ActionType.java: This enum class defines the action types that a character can take.
- InputHandler.java: This class handles the input from the user.

battle
- Battle.java: This class is responsible for the battle logic in the game. It provides methods to start the battle, handle hero's turn, monster's turn, and end the battle.

creature
* Creature.java: This abstract class defines a general creature with attributes like name, level, hp and basic behaviors like attack, take damage and dodge.
* Hero.java: This class defines the hero creature. It is a subclass of Creature class. This class defines the hero character in the game. It extends the Character class and has additional attributes like type, experience, strength, agility, dexterity, gold, inventory, equipped weapon and armor. It also has methods to level up, gain experience, gain rewards, attack, take damage, dodge, cast spell, use potion, equip weapon, equip armor, recover, heal, restore MP, increase attributes, check if fainted, revive with penalty, and toString.
* Monster.java: This class defines the monster creature in the game. It extends the Creature class and has additional attributes like type, damage, defense and dodge.
* HeroType.java: This enum class defines the hero types.
* MonsterType.java: This enum class defines the monster types.

- CreatureFactory.java: This class is the factory class for creating creatures from configuration files. It reads the configuration files for heroes and monsters and creates a list of creatures.
- Team.java: This abstract class defines a general team with attributes like name, row, col and count. It also has abstract methods to generate a team.
- HeroTeam.java: This class represents a team of heroes in the game. It extends the Team class and contains a list of heroes. It provides methods to generate a team of heroes and get team level of all heroes.
- MonsterTeam.java: This class defines the monster team in the game. It extends the Team class and has additional attributes like monsters. It also has a method to generate a team of monsters.

data

* configuration txt files for heroes, monsters, items

game
- GameLauncher.java: This class is the entry point of the game. It initializes the two games and starts the game.
- RPGGame.java: This abstract class defines the general RPG game. 
- LegendsMah.java: This class is the game class for Monsters and Heroes. It initializes the game and starts the game loop. It has the game board, hero team. It handles the whole game process like moving, battling, and marketing. It also handles the user input and output.
- LegendsValor.java: This class is the game class for Legends of Valor. It initializes the game and starts the game loop. It has the game board, hero team, monster team. It handles the whole game process like moving, battling, and marketing. It also handles the user input and output.

item
- Item.java: This abstract class defines the item.
- Armor.java: This class defines the armor item. It extends the Item class and has an additional attribute damageReduction.
- Potion.java: This class defines the potion item in the game. It extends the Item class and implements the Effect interface. It contains the effect amount and effect types of the potion. It also contains the effect method that applies the effect to the target hero.
- Spell.java: This class defines the spell item in the game. It extends the Item class and implements the Effect interface. It contains the spell type, damage, and mana cost of the spell. It also contains the effect method that applies the effect to the target monster.
- Weapon.java: This class defines the weapon item in the game. It extends the Item class. It contains the damage and hands required of the weapon.
- EffectType.java: This enum class defines the effect types of a potion.
- SpellType.java: This enum class defines the spell types.

interfaces

* Effect.java: This interface defines the effect of behavior in the game. It contains the effect method that applies the effect to the target.
* Store.java: This interface defines the store behavior in the game. It contains the chooseFromCategory method that allows the hero to choose an item from a category.

store

* Inventory.java: This class defines the inventory of a hero, which contains weapons, armors, potions and spells. It implements the Store interface and has methods to add, remove, check, get and display items.

- Market.java: This class defines the market in the game. It implements the Store interface and provides methods for the hero to buy items and sell items to the market. The market contains weapons, armors, potions, and spells for sale.
- MarketFactory.java: This class is a factory class that creates a market with random items. It reads the configuration files for weapons, armors, potions, and spells, and creates a market with random items from each category.

strategy

* Equipstrategy.java: This interface defines the strategy for equipping items. It has a single method equip().
* EquipArmor.java: This class is the strategy for equipping armor. It implements the EquipStrategy interface.
* EquipWeapon.java: This class is the strategy for equipping weapon. It implements the EquipStrategy interface.

util
- Printer.java: This class is used to print messages to the console.

world
- Board.java: This class defines the general board in the game. It contains the board size, spaces, and methods to display the board, and get the space type and market.
- MahBoard.java: This class defines the board in the game Monsters and Heroes. It contains the board size, spaces, and methods to initialize and display the board, move the player on the board.
- ValorBoard.java: This class defines the board in the game Legends of Valor. It contains the board size, spaces, and methods to initialize and display the board, move the player on the board and specific functions in the game like to teleport a hero, get monsters around a hero, get heroes around a monster, remove a monster from the board.
- Space.java: This class defines the space on the board in the game. It contains the type of the space, whether the player is here, the market on the space, and the methods to access these attributes.
- SpaceType.java: This enum class defines the space types.

Main.java: This is the main class of the program. 

## Notes
1. Singleton pattern, Factory pattern and Strategy pattern are used in the class design. See details in design documentation.
2. For user friendliness, the game uses colored text to display messages in the console. The Printer class is used to print messages to the console.
3. You can easily customize board size in Monsters and Heroes.
4. When monsters are created, their levels are set to match heros' levels and monsters' damage are changed correspondingly using an algorithm. This could improve user experience to prevent the game being to hard or too easy.
5. When hero casts a spell on a monster, the monster can dodge the damage but not the spell effect on their attributes. This makes sense because it's magic after all.


## File Structure
---------------------------------------------------------------------------


```
src
├── action
│   ├── ActionType.java
│   └── InputHandler.java
├── battle
│   └── Battle.java
├── creature
│   ├── Creature.java
│   ├── CreatureFactory.java
│   ├── Hero.java
│   ├── HeroTeam.java
│   ├── HeroType.java
│   ├── Monster.java
│   ├── MonsterTeam.java
│   ├── MonsterType.java
│   └── Team.java
├── data
│   ├── Armory.txt
│   ├── Dragons.txt
│   ├── Exoskeletons.txt
│   ├── FireSpells.txt
│   ├── IceSpells.txt
│   ├── LightningSpells.txt
│   ├── Paladins.txt
│   ├── Potions.txt
│   ├── Sorcerers.txt
│   ├── Spirits.txt
│   ├── Warriors.txt
│   └── Weaponry.txt
├── game
│   ├── GameLauncher.java
│   ├── RPGGame.java
│   ├── LegendsMah.java
│   └── LegendsValor.java
├── interfaces
│   ├── Effect.java
│   └── Store.java
├── item
│   ├── Armor.java
│   ├── EffectType.java
│   ├── Item.java
│   ├── Potion.java
│   ├── Spell.java
│   ├── SpellType.java
│   └── Weapon.java
├── store
│   ├── Inventory.java
│   ├── Market.java
│   └── MarketFactory.java
├── strategy
│   ├── EquipStrategy.java
│   ├── EquipArmor.java
│   ├── EquipWeapon.java
├── util
│   └── Printer.java
├── world
│   ├── Board.java
│   ├── MahBoard.java
│   ├── ValorBoard.java
│   ├── Space.java
│   └── SpaceType.java
├── Main.java
out
README.md
```

## How to compile and run

---------------------------------------------------------------------------

1. Navigate to the source directory Legends after unzipping the files.

2. Please make sure your file structure is the same as the above file structure!

3. Run the following instructions in TERMINAL:

   Notes: We uses relative file pathing, but it only works fine in TERMINAL, not IDEA!!

   ```
   javac -d out src/action/*.java src/battle/*.java src/creature/*.java src/game/*.java src/interfaces/*.java src/item/*.java src/store/*.java src/util/*.java src/world/*.java src/strategy/*.java src/*.java; java -cp out Main
   ```



## Input/Output Example

---------------------------------------------------------------------------

Note: Colors can not be displayed in this file. Please run the program to see the colors. The game experience is guaranteed by the colors.

```
Welcome to the LEGENDS!

Game Menu:
1. Legends of Valor
2. Legends of Monsters and Heroes
0. Exit

Please choose a game to play:1

======== GAME START ========
Welcome to Legends of Valor!

Game Background:
In this fantasy world of magic, monsters, and heroes, you will lead a brave party of heroes
on an endless journey filled with adventure. This world is dominated by powerful creatures
and fierce battles, where heroes and monsters clash in an eternal struggle. Every victory brings
your heroes experience and wealth, allowing them to grow stronger and acquire new items for
future battles.

For centuries, heroes and monsters have been locked in a constant battle. As your heroes defeat
monsters, they gain experience and gold, becoming more capable of facing even greater foes.
Heroes can use gold to buy weapons, armor, potions, and spells to improve their chances to win.
When enough experience is gained, heroes level up, improving their skills and gaining power to face
tougher enemies.

Gameplay:
- World: The world is divided into a grids in three lanes, each with its own unique features like plain
  areas ('empty grid'), bush('B'), cave('C'), koulou('K') and inaccessible space('X'). Heroes can move around the world
  to explore, fight monsters,
- Battles with Monsters: Monsters keep moving down until a hero appear in its attack range. Monsters will attack
  heroes automatically. Heroes can attack monsters in their attack range to stop them from moving down.
  During a battle, hero can choose an action, such as attacking using a weapon, casting a spell, a potion, or equipping armor.
- Character Attributes: Each hero and monster has unique attributes like HP (health), MP (mana),
  strength, dexterity, agility, and dodge chance. Each hero's class has favored attributes that receive
  additional boosts upon leveling up, making them even more formidable in battle.
- Market: In Nexus spaces, heroes can enter a market and use their gold to buy weapons, armor, potions, and spells to
  strengthen their abilities or sell unwanted items for extra gold. Each hero has their own inventory
  and gold, so managing resources wisely is crucial.
- Goal: Your goal is to have one of your heroes reach the Nexus of the monster team
  Good luck, adventurer! May your heroes grow strong, conquer every challenge, and become legends

Controls:
- Help: Press H at any time to display the help list of commands.
- Movement: Use W/A/S/D keys to move your hero party around the world map.
- Battle Commands: During battle, each hero can choose to attack, cast spells, use potions, or equip weapon or armor.
  At any time, you can check the stats of your heroes or the monsters they face.
- Market Access: When on a Nexus space, press 'm' to enter the market to buy or sell items and manage your heroes' inventories.
- Exit Game: Press Q at any time to quit the game.
- Again! Press H at any time if you lose sight of what to do.

Good luck, adventurer! May your heroes grow strong, conquer every challenge, and become legends
in this world of Monsters and Heroes!
=========================

Commands:
w/W - Move up
a/A - Move left
s/S - Move down
d/D - Move right
t/T - Teleport to another hero
r/R - Recall to Nexus
k/K - Start to attack
up/UP - Use potion
ew/EW - Equip weapon
ea/EA - Equip armor
p/P - Pass the turn
b/B - Open inventory
m/M - Open market
v/V - View map
i/I - Display character information
h/H - Display command help
q/Q - Quit the game


Market Commands:
w/W - Buy Weapon
a/A - Buy Armor
p/P - Buy Potion
s/S - Buy Spell
b/B - Open inventory
d/D - Sell your item
e/E - Exit market
i/I - Display hero information
h/H - Display command help
q/Q - Quit the game

Available Heroes:

============ HERO INFORMATION ============
Index   Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
1       Gaerdal Ironhand     WARRIOR    1          7               200        100        700        500        600        1354       NULL                 NULL
2       Sehanine Monnbow     WARRIOR    1          8               200        600        700        800        500        2500       NULL                 NULL
3       Muamman Duathall     WARRIOR    1          6               200        300        900        500        750        2546       NULL                 NULL
4       Flandal Steelskin    WARRIOR    1          7               200        200        750        650        700        2500       NULL                 NULL
5       Undefeated Yoj       WARRIOR    1          7               200        400        800        400        700        2500       NULL                 NULL
6       Eunoia Cyn           WARRIOR    1          6               200        400        700        800        600        2500       NULL                 NULL
7       Rillifane Rallathil  SORCERER   1          9               200        1300       750        450        500        2500       NULL                 NULL
8       Segojan Earthcaller  SORCERER   1          5               200        900        800        500        650        2500       NULL                 NULL
9       Reign Havoc          SORCERER   1          8               200        800        800        800        800        2500       NULL                 NULL
10      Reverie Ashels       SORCERER   1          7               200        900        800        700        400        2500       NULL                 NULL
11      Kalabar              SORCERER   1          6               200        800        850        400        600        2500       NULL                 NULL
12      Skye Soar            SORCERER   1          5               200        1000       700        400        500        2500       NULL                 NULL
13      Parzival             PALADIN    1          7               200        300        750        650        700        2500       NULL                 NULL
14      Sehanine Moonbow     PALADIN    1          7               200        300        750        700        700        2500       NULL                 NULL
15      Skoraeus Stonebones  PALADIN    1          4               200        250        650        600        350        2500       NULL                 NULL
16      Garl Glittergold     PALADIN    1          5               200        100        600        500        400        2500       NULL                 NULL
17      Amaryllis Astra      PALADIN    1          5               200        500        500        500        500        2500       NULL                 NULL
18      Caliber Heist        PALADIN    1          8               200        400        400        400        400        2500       NULL                 NULL
==========================================

Please select 3 heroes by entering their serial numbers (1-18):
Enter hero number: 1
[EVENT] Hero Gaerdal Ironhand has been added to your team.
Enter hero number: 12
[EVENT] Hero Skye Soar has been added to your team.
Enter hero number: 12
[ERROR] You already selected this hero. Please choose another.
Enter hero number: 16
[EVENT] Hero Garl Glittergold has been added to your team.

============ HERO INFORMATION ============
Index   Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
1       Gaerdal Ironhand     WARRIOR    1          7               200        100        700        500        600        1354       NULL                 NULL
2       Skye Soar            SORCERER   1          5               200        1000       700        400        500        2500       NULL                 NULL
3       Garl Glittergold     PALADIN    1          5               200        100        600        500        400        2500       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Index   Name                 Type            Level      HP         Damage     Defense    Dodge
1       Desghidorrah         DRAGON          1          100        50         400        35
2       Melchiresas          SPIRIT          1          100        25         150        75
3       Chronepsish          EXOSKELETON     1          100        54         750        60
=============================================

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M1 |  X  |  N  |  M2 |  X  |  N  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |  N  |  X  |  H2 |  N  |  X  |  H3 |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[TIP] [1] Gaerdal Ironhand is at the Nexus. (Press 'M' to enter the market)

<World> [1] Gaerdal Ironhand, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M1 |  X  |  N  |  M2 |  X  |  N  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  H2 |  N  |  X  |  H3 |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[TIP] [2] Skye Soar is at the Nexus. (Press 'M' to enter the market)

<World> [2] Skye Soar, please enter your action: m

======== MARKET ========
WELCOME TO THE MARKET!
We have weapons, armors, potions, and spells for sale.
Take a look around and see if you find anything you like!
========================

<Market> Skye Soar, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: w

======== WEAPON FOR SALE ========
Index  Quantity  Name                 Price      Level      Damage     Hands Req
1      1         TSwords              1400       8          1600       2
2      1         Dagger               200        1          250        1
3      1         Bow                  300        2          500        2
================================

<Market> Enter the index of item you favor ('0' to exit): 2
[EVENT] Skye Soar successfully purchased Dagger for 200 gold.

<Market> Skye Soar, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: a

======== ARMOR FOR SALE ========
Index  Quantity  Name                 Price      Level      Damage Red
1      3         Breastplate          350        3          600
2      1         Wizard Shield        1200       10         1500
3      1         Full Body Armor      1000       8          1100
================================

<Market> Enter the index of item you favor ('0' to exit): 2
[FAIL] Skye Soar level is too low to buy Wizard Shield

<Market> Enter the index of item you favor ('0' to exit): 0

<Market> Skye Soar, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: s

======== SPELL FOR SALE ========
Index  Quantity  Name                 Price      Level      Spell Type      Damage     Mana Cost
1      3         Snow Cannon          500        2          ICE             650        250
2      1         Breath of Fire       350        1          FIRE            450        100
3      2         Lightning Dagger     400        1          LIGHTNING       500        150
4      1         Spark Needles        500        2          LIGHTNING       600        200
5      1         Hell Storm           600        3          FIRE            950        600
6      3         Ice Blade            250        1          ICE             450        100
7      1         Lava Comet           800        7          FIRE            1000       550
8      3         Frost Blizzard       750        5          ICE             850        350
9      2         Electric Arrows      550        5          LIGHTNING       650        200
================================

<Market> Enter the index of item you favor ('0' to exit): 2
[EVENT] Skye Soar successfully purchased Breath of Fire for 350 gold.

<Market> Skye Soar, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: e
Exiting market...

<World> [2] Skye Soar, please enter your action: h

Commands:
w/W - Move up
a/A - Move left
s/S - Move down
d/D - Move right
t/T - Teleport to another hero
r/R - Recall to Nexus
k/K - Start to attack
up/UP - Use potion
ew/EW - Equip weapon
ea/EA - Equip armor
p/P - Pass the turn
b/B - Open inventory
m/M - Open market
v/V - View map
i/I - Display character information
h/H - Display command help
q/Q - Quit the game


<World> [2] Skye Soar, please enter your action: ew

======== WEAPON ========
Index  Name                 Price      Level      Damage     Hands Req
1      Dagger               200        1          250        1
========================

<Inventory> Enter the index of item you choose ('0' to exit): 1
[EVENT] [2] Skye Soar equipped Dagger

<World> [2] Skye Soar, please enter your action: ea

======== ARMOR ========
EMPTY

<World> [2] Skye Soar, please enter your action: v

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M1 |  X  |  N  |  M2 |  X  |  N  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  H2 |  N  |  X  |  H3 |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [2] Skye Soar, please enter your action: d

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M1 |  X  |  N  |  M2 |  X  |  N  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  H2 |  X  |  H3 |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[TIP] [3] Garl Glittergold is at the Nexus. (Press 'M' to enter the market)

<World> [3] Garl Glittergold, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M1 |  X  |  N  |  M2 |  X  |  N  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  H2 |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[MONSTER TURN] [1] Desghidorrah moves down!
[MONSTER TURN] [2] Melchiresas moves down!
[MONSTER TURN] [3] Chronepsish moves down!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |     |  M2 |  X  |  K  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  H2 |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [1] Gaerdal Ironhand, please enter your action: w
[EVENT] [1] Gaerdal Ironhand enters a koulou and gains strength bonus!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |     |  M2 |  X  |  K  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  H2 |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[TIP] [2] Skye Soar is at the Nexus. (Press 'M' to enter the market)

<World> [2] Skye Soar, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |     |  M2 |  X  |  K  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |  H2 |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [3] Garl Glittergold, please enter your action: w
[EVENT] [3] Garl Glittergold enters a cave and gains agility bonus!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |     |  M2 |  X  |  K  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |  K  |     |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |  H2 |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[MONSTER TURN] [1] Desghidorrah moves down!
[MONSTER TURN] [2] Melchiresas moves down!
[MONSTER TURN] [3] Chronepsish moves down!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  M1 |  X  |     |  M2 |  X  |     |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |  K  |     |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |  H2 |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [1] Gaerdal Ironhand, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  M1 |  X  |     |  M2 |  X  |     |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |  H2 |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [2] Skye Soar, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  M1 |  X  |     |  M2 |  X  |     |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |  H2 |  X  |  H3 |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [3] Garl Glittergold, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  M1 |  X  |     |  M2 |  X  |     |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |  H3 |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |  H2 |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[MONSTER TURN] [1] Desghidorrah moves down!
[MONSTER TURN] [2] Melchiresas moves down!
[MONSTER TURN] [3] Chronepsish moves down!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |  K  |  M2 |  X  |  C  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |  H3 |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |  H2 |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [1] Gaerdal Ironhand, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [1] Gaerdal Ironhand, please enter your action: k

<Battle> [1] Gaerdal Ironhand, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] [1] Gaerdal Ironhand is attacking Desghidorrah
[HERO TURN] [1] Desghidorrah took 35 damage and now has 65 HP left.

<World> [2] Skye Soar, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |  K  |  M2 |  X  |  C  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |  H2 |  X  |  H3 |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [3] Garl Glittergold, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [3] Garl Glittergold, please enter your action: k

<Battle> [3] Garl Glittergold, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] [3] Garl Glittergold is attacking Chronepsish
[HERO TURN] [3] Chronepsish took 30 damage and now has 70 HP left.

[MONSTER TURN] [1] Desghidorrah is attacking Gaerdal Ironhand
[MONSTER TURN] [1] Gaerdal Ironhand took 50 damage and now has 150 HP left.

[MONSTER TURN] [2] Melchiresas is attacking Skye Soar
[MONSTER TURN] [2] Skye Soar took 25 damage and now has 175 HP left.

[MONSTER TURN] [3] Chronepsish is attacking Garl Glittergold
[MONSTER TURN] [3] Garl Glittergold dodged the attack!

[EVENT] [1] Gaerdal Ironhand recovered some health and mana.

[EVENT] [2] Skye Soar recovered some health and mana.

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |  K  |  M2 |  X  |  C  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |  H2 |  X  |  H3 |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [1] Gaerdal Ironhand, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [1] Gaerdal Ironhand, please enter your action: i

============ HERO INFORMATION ============
Index   Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
1       Gaerdal Ironhand     WARRIOR    1          7               165        100        700        500        600        1354       NULL                 NULL
2       Skye Soar            SORCERER   1          5               192        1000       700        400        500        1950       Dagger               NULL
3       Garl Glittergold     PALADIN    1          5               200        100        600        500        400        2500       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Index   Name                 Type            Level      HP         Damage     Defense    Dodge
1       Desghidorrah         DRAGON          1          65         50         400        35
2       Melchiresas          SPIRIT          1          100        25         150        75
3       Chronepsish          EXOSKELETON     1          70         54         750        60
=============================================

<World> [1] Gaerdal Ironhand, please enter your action: k

<Battle> [1] Gaerdal Ironhand, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] [1] Gaerdal Ironhand is attacking Desghidorrah
[HERO TURN] [1] Desghidorrah took 35 damage and now has 30 HP left.

[WARNING]] [2] Skye Soar, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [2] Skye Soar, please enter your action: h

Commands:
w/W - Move up
a/A - Move left
s/S - Move down
d/D - Move right
t/T - Teleport to another hero
r/R - Recall to Nexus
k/K - Start to attack
up/UP - Use potion
ew/EW - Equip weapon
ea/EA - Equip armor
p/P - Pass the turn
b/B - Open inventory
m/M - Open market
v/V - View map
i/I - Display character information
h/H - Display command help
q/Q - Quit the game


<World> [2] Skye Soar, please enter your action: k

<Battle> [2] Skye Soar, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: c

======== SPELL ========
Index  Name                 Price      Level      Spell Type      Damage     Mana Cost
1      Breath of Fire       350        1          FIRE            450        100
========================

<Inventory> Enter the index of item you choose ('0' to exit): 1
[HERO TURN] [2] Melchiresas took 472 damage and now has 0 HP left.
[HERO TURN] [2] Skye Soar cast Breath of Fire on [2] Melchiresas for 472 damage!
[HERO TURN] [2] Melchiresas's defense decreased by 20%.
[EVENT] [2] Skye Soar defeated [2] Melchiresas!
[EVENT] [2] Skye Soar gained 2 experience!
[EVENT] [2] Skye Soar gained 1 gold!

[WARNING]] [3] Garl Glittergold, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [3] Garl Glittergold, please enter your action: w
[EVENT] [3] Garl Glittergold enters a cave and gains agility bonus!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |  K  |  C  |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |  H2 |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[MONSTER TURN] [1] Desghidorrah is attacking Gaerdal Ironhand
[MONSTER TURN] [1] Gaerdal Ironhand dodged the attack!

[MONSTER TURN] [3] Chronepsish is attacking Garl Glittergold
[MONSTER TURN] [3] Garl Glittergold took 54 damage and now has 146 HP left.

[EVENT] [1] Gaerdal Ironhand recovered some health and mana.

[EVENT] [2] Skye Soar recovered some health and mana.

[EVENT] [3] Garl Glittergold recovered some health and mana.

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  M1 |  X  |  K  |  C  |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |  H2 |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [1] Gaerdal Ironhand, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [1] Gaerdal Ironhand, please enter your action: k

<Battle> [1] Gaerdal Ironhand, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] [1] Gaerdal Ironhand is attacking Desghidorrah
[HERO TURN] [1] Desghidorrah took 35 damage and now has 0 HP left.
[EVENT] [1] Gaerdal Ironhand defeated [1] Desghidorrah!
[EVENT] [1] Gaerdal Ironhand gained 2 experience!
[EVENT] [1] Gaerdal Ironhand gained 1 gold!

<World> [2] Skye Soar, please enter your action: w
[EVENT] [2] Skye Soar enters a cave and gains agility bonus!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  H2 |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [3] Garl Glittergold, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [3] Garl Glittergold, please enter your action: w
[FAIL] Oops, invalid move! Try another way.

<World> [3] Garl Glittergold, please enter your action: w
[FAIL] Oops, invalid move! Try another way.

<World> [3] Garl Glittergold, please enter your action: k

<Battle> [3] Garl Glittergold, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] [3] Garl Glittergold is attacking Chronepsish
[HERO TURN] [3] Chronepsish dodged the attack!

[MONSTER TURN] [3] Chronepsish is attacking Garl Glittergold
[MONSTER TURN] [3] Garl Glittergold dodged the attack!

[EVENT] [1] Gaerdal Ironhand recovered some health and mana.

[EVENT] [2] Skye Soar recovered some health and mana.

[EVENT] [3] Garl Glittergold recovered some health and mana.

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  H2 |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [1] Gaerdal Ironhand, please enter your action: w
[EVENT] [1] Gaerdal Ironhand enters a bush and gains dexterity bonus!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |  C  |  X  |  K  |  H2 |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [2] Skye Soar, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |  H2 |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |  C  |  X  |  K  |  C  |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [3] Garl Glittergold, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [3] Garl Glittergold, please enter your action: k

<Battle> [3] Garl Glittergold, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] [3] Garl Glittergold is attacking Chronepsish
[HERO TURN] [3] Chronepsish dodged the attack!

[MONSTER TURN] [3] Chronepsish is attacking Garl Glittergold
[MONSTER TURN] [3] Garl Glittergold took 54 damage and now has 122 HP left.

[EVENT] [1] Gaerdal Ironhand recovered some health and mana.

[EVENT] [3] Garl Glittergold recovered some health and mana.

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |  H2 |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |  C  |  X  |  K  |  C  |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [1] Gaerdal Ironhand, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |  H2 |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [2] Skye Soar, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |     |  H2 |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  H3 |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [3] Garl Glittergold, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [3] Garl Glittergold, please enter your action: k'
[FAIL] INVALID ACTION. Please try again! (or type 'h' for help)

<World> [3] Garl Glittergold, please enter your action: a
[FAIL] Oops, invalid move! Try another way.

<World> [3] Garl Glittergold, please enter your action: t

<Teleport> [3] Garl Glittergold, please choose a hero to teleport to:
[1] Gaerdal Ironhand
[2] Skye Soar
Please enter your choice: 2

<Teleport> [3] Garl Glittergold, which side of [2] Skye Soar would you like to teleport to?
  (A) Left
  (D) Right
  (S) Bottom
Please enter your choice: a
[EVENT] [3] Garl Glittergold teleported to [2] Skye Soar's left!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |  H3 |  H2 |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  C  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[MONSTER TURN] [3] Chronepsish moves down!

[EVENT] [3] Garl Glittergold recovered some health and mana.

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M4 |  X  |  N  |  M5 |  X  |  N  |  M6 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |  H3 |  H2 |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


<World> [1] Gaerdal Ironhand, please enter your action: r
[EVENT] [1] Gaerdal Ironhand is recalled to the Nexus!

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M4 |  X  |  N  |  M5 |  X  |  N  |  M6 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |  H3 |  H2 |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+


[WARNING]] [2] Skye Soar, Be careful, Enemy around you! (Press 'K' to start attack)

<World> [2] Skye Soar, please enter your action: w

+-----+-----+-----+-----+-----+-----+-----+-----+
|  N  |  M4 |  X  |  N  |H2 M5|  X  |  N  |  M6 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  B  |  X  |  H3 |     |  X  |  K  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |  C  |  X  |  K  |  C  |  X  |  C  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |  M3 |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  K  |     |  X  |  K  |     |  X  |  C  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  X  |     |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  H1 |  N  |  X  |  N  |  N  |  X  |  N  |  N  |
+-----+-----+-----+-----+-----+-----+-----+-----+

[EVENT] Congratulations! YOU WIN!
```

