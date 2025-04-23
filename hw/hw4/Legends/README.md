# CS611-Assignment 4 

## < Legends: Monsters and Heroes>

---------------------------------------------------------------------------

- Name: Yifei Bao
- Email: baoyifei@bu.edu
- Student ID: U02463348

## Files
action
- ActionType.java: This enum class defines the action types that a character can take.
- InputHandler.java: This class handles the input from the user.

battle
- Battle.java: This class is responsible for the battle logic in the game. It provides methods to start the battle, handle hero's turn, monster's turn, and end the battle.

character

* Character.java: This abstract class defines a general character with attributes like name, level, hp and basic behaviors like attack, take damage and dodge.
* Hero.java: This class defines the hero character. It is a subclass of Character class. This class defines the hero character in the game. It extends the Character class and has additional attributes like type, experience, strength, agility, dexterity, gold, inventory, equipped weapon and armor. It also has methods to level up, gain experience, gain rewards, attack, take damage, dodge, cast spell, use potion, equip weapon, equip armor, recover, heal, restore MP, increase attributes, check if fainted, revive with penalty, and toString.
* Monster.java: This class defines the monster character in the game. It extends the Character class and has additional attributes like type, damage, defense and dodge.
* HeroType.java: This enum class defines the hero types.
* MonsterType.java: This enum class defines the monster types.

- CharacterFactory.java: This class is the factory class for creating characters from configuration files. It reads the configuration files for heroes and monsters and creates a list of characters.
- Team.java: This abstract class defines a general team with attributes like name, row, col and count. It also has abstract methods to generate a team.
- HeroTeam.java: This class represents a team of heroes in the game. It extends the Team class and contains a list of heroes. It provides methods to generate a team of heroes and get team level of all heroes.
- MonsterTeam.java: This class defines the monster team in the game. It extends the Team class and has additional attributes like monsters. It also has a method to generate a team of monsters.

config

* configuration txt files for heroes, monsters, items

game
- GameLauncher.java: This class is the entry point of the game.
- Legends.java: This class is the main game class. It initializes the game and starts the game loop. It has the game board, hero team. It handles the whole game process like moving, battling, and marketing. It also handles the user input and output.

- Inventory.java: This class defines the inventory of a hero, which contains weapons, armors, potions and spells. It has methods to add, remove, check, get and display items.

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

market
- Market.java: This class defines the market in the game. It implements the Store interface and provides methods for the hero to buy items and sell items to the market. The market contains weapons, armors, potions, and spells for sale.
- MarketFactory.java: This class is a factory class that creates a market with random items. It reads the configuration files for weapons, armors, potions, and spells, and creates a market with random items from each category.

util
- Printer.java: This class is used to print messages to the console.

world
- Board.java: This class defines the board in the game. It contains the 2D array of spaces, board size, and methods to initialize and display the board, move the player on the board.
- Space.java: This class defines the space on the board in the game. It contains the type of the space, whether the player is here, the market on the space, and the methods to access these attributes.
- SpaceType.java: This enum class defines the space types.

Main.java: This is the main class of the program. 

## Notes
1. The CharacterFactory class is used to create characters like heroes and monsters. The MarketFactory class is used to create a market. They follow the factory design pattern.
2. The Effect interface defines the effect method that applies the effect to the target. The item Spell and Potion implements the Effect interface because they all have special effects on characters. Also, Market and Inventory implements the store interface, because they all provides the method to choose items from storage by category. This follows the strategy design pattern.
3. For user friendliness, the game uses colored text to display messages in the console. The Printer class is used to print messages to the console.
4. When monsters are created , their levels are set to match heros' levels and monsters' damage are changed correspondingly using an algorithm. This could improve user experience to prevent the game being to hard or too easy.
5. When hero casts a spell on a monster, the monster can dodge the damage but not the spell effect on their attributes. This makes sense because it's magic after all.
6. In the game board, inaccessible spaces are marked with 'X' and the market spaces are marked with 'M'. The player location is represented by 'U'.
7. The logic of rounds in battle is 1v1. Each hero and monster take turns to attack each other. If a monster is defeated, the next monster will take its place, and vice versa. The battle ends when all heroes or all monsters are defeated.


## File Structure
---------------------------------------------------------------------------


```
src
├── action
│   ├── ActionType.java
│   └── InputHandler.java
├── battle
│   └── Battle.java
├── character
│   ├── Character.java
│   ├── CharacterFactory.java
│   ├── Hero.java
│   ├── HeroTeam.java
│   ├── HeroType.java
│   ├── Monster.java
│   ├── MonsterTeam.java
│   ├── MonsterType.java
│   └── Team.java
├── config
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
│   └── Legends.java
├── interfaces
│   ├── Effect.java
│   └── Store.java
├── inventory
│   └── Inventory.java
├── item
│   ├── Armor.java
│   ├── EffectType.java
│   ├── Item.java
│   ├── Potion.java
│   ├── Spell.java
│   ├── SpellType.java
│   └── Weapon.java
├── market
│   ├── Market.java
│   └── MarketFactory.java
├── util
│   └── Printer.java
├── world
│   ├── Board.java
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

3. Run the following instructions:

   ```
   javac -d out src/action/*.java src/battle/*.java src/character/*.java src/game/*.java src/interfaces/*.java src/inventory/*.java src/item/*.java src/market/*.java src/util/*.java src/world/*.java src/*.java ; java -cp out Main
   ```



## Input/Output Example

---------------------------------------------------------------------------

Note: Colors can not be displayed in this file. Please run the program to see the colors. The game experience is guaranteed by the colors.

```

======== GAME START ========
Welcome to Legends: Monsters and Heroes!

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
- World: The world is divided into a grid of spaces, each with its own unique features like common
  areas ('empty grid'), markets('M'), and inaccessible space('X'). Heroes can move around the world
  to explore, fight monsters,
- Battles with Monsters: In the common areas of the world, heroes may encounter monsters triggering a battle.
  During a battle, each hero takes turns to choose an action, such as attacking using a weapon, casting a spell,
  a potion, or equipping armor. Monsters respond by attacking heroes. The battle proceeds in turns until
  either all monsters or all heroes are defeated.
- Character Attributes: Each hero and monster has unique attributes like HP (health), MP (mana),
  strength, dexterity, agility, and dodge chance. Each hero's class has favored attributes that receive
  additional boosts upon leveling up, making them even more formidable in battle.
- Market: In market spaces, heroes can use their gold to buy weapons, armor, potions, and spells to
  strengthen their abilities or sell unwanted items for extra gold. Each hero has their own inventory
  and gold, so managing resources wisely is crucial.
- Endless Adventure: Your goal is to continually defeat monsters, level up your heroes, and survive
  in this challenging world. Keep upgrading and equipping your heroes to transform them into true legends!

Controls:
- Help: Press H at any time to display the help list of commands.
- Movement: Use W/A/S/D keys to move your hero party around the world map.
- Battle Commands: During battle, each hero can choose to attack, cast spells, use potions, or equip weapon or armor.
  At any time, you can check the stats of your heroes or the monsters they face.
- Market Access: When on a market space, enter the market to buy or sell items and manage your heroes' inventories.
- Exit Game: Press Q at any time to quit the game.
- Again! Press H at any time if you lose sight of what to do.

Good luck, adventurer! May your heroes grow strong, conquer every challenge, and become legends
in this world of Monsters and Heroes!
=========================

<World> How many heroes would you like to assemble? (1-3): 2

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        2500       NULL                 NULL
Caliber Heist        PALADIN    1          8               100        400        400        400        400        2500       NULL                 NULL
==========================================
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  U  |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: w
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  U  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: h

Commands:
w/W - Move up
a/A - Move left
s/S - Move down
d/D - Move right
b/B - Open inventory
m/M - Open market
v/V - View map
i/I - Display hero information
h/H - Display command help
q/Q - Quit the game

<World> Please enter your action: m

======== MARKET ========
WELCOME TO THE MARKET!
We have weapons, armors, potions, and spells for sale.
Take a look around and see if you find anything you like!
========================

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: w

======== WEAPON FOR SALE ========
Index  Quantity  Name                 Price      Level      Damage     Hands Req
1      3         Sword                500        1          800        1
2      2         Scythe               1000       6          1100       2
3      3         TSwords              1400       8          1600       2
================================

<Market> Enter the index of item you favor ('0' to exit): 1
[EVENT] Eunoia Cyn successfully purchased Sword for 500 gold.

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: b

===== Eunoia Cyn's INVENTORY =====
WEAPON
Name                 Price      Level      Damage     Hands Req
Sword                500        1          800        1

===== Caliber Heist's INVENTORY =====
EMPTY

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: a

======== ARMOR FOR SALE ========
Index  Quantity  Name                 Price      Level      Damage Red
1      3         Platinum Shield      150        1          200
2      2         Wizard Shield        1200       10         1500
3      3         Full Body Armor      1000       8          1100
================================

<Market> Enter the index of item you favor ('0' to exit): 1
[EVENT] Eunoia Cyn successfully purchased Platinum Shield for 150 gold.

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: p

======== POTION FOR SALE ========
Index  Quantity  Name                 Price      Level      Effect Amt      Effect Type
1      2         Mermaid Tears        850        5          100             [HP, MP, STRENGTH, AGILITY]
2      3         Ambrosia             1000       8          150             [HP, MP, STRENGTH, DEXTERITY, DEFENSE, AGILITY]
3      1         Healing Potion       250        1          100             [HP]
================================

<Market> Enter the index of item you favor ('0' to exit): 2
[FAIL] Eunoia Cyn level is too low to buy Ambrosia

<Market> Enter the index of item you favor ('0' to exit): 3
[EVENT] Eunoia Cyn successfully purchased Healing Potion for 250 gold.

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: s

======== SPELL FOR SALE ========
Index  Quantity  Name                 Price      Level      Spell Type      Damage     Mana Cost
1      2         Ice Blade            250        1          ICE             450        100
2      3         Arctic Storm         700        6          ICE             800        300
3      1         Electric Arrows      550        5          LIGHTNING       650        200
4      1         Hell Storm           600        3          FIRE            950        600
5      3         Lava Comet           800        7          FIRE            1000       550
6      1         Breath of Fire       350        1          FIRE            450        100
7      3         Thunder Blast        750        4          LIGHTNING       950        400
8      2         Snow Cannon          500        2          ICE             650        250
9      3         Spark Needles        500        2          LIGHTNING       600        200
================================

<Market> Enter the index of item you favor ('0' to exit): 6
[EVENT] Eunoia Cyn successfully purchased Breath of Fire for 350 gold.

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: e
Exiting market...

<Market> Caliber Heist, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: w

======== WEAPON FOR SALE ========
Index  Quantity  Name                 Price      Level      Damage     Hands Req
1      2         Sword                500        1          800        1
2      2         Scythe               1000       6          1100       2
3      3         TSwords              1400       8          1600       2
================================

<Market> Enter the index of item you favor ('0' to exit): 1
[EVENT] Caliber Heist successfully purchased Sword for 500 gold.

<Market> Caliber Heist, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: s

======== SPELL FOR SALE ========
Index  Quantity  Name                 Price      Level      Spell Type      Damage     Mana Cost
1      2         Ice Blade            250        1          ICE             450        100
2      3         Arctic Storm         700        6          ICE             800        300
3      1         Electric Arrows      550        5          LIGHTNING       650        200
4      1         Hell Storm           600        3          FIRE            950        600
5      3         Lava Comet           800        7          FIRE            1000       550
6      3         Thunder Blast        750        4          LIGHTNING       950        400
7      2         Snow Cannon          500        2          ICE             650        250
8      3         Spark Needles        500        2          LIGHTNING       600        200
================================

<Market> Enter the index of item you favor ('0' to exit): 1
[EVENT] Caliber Heist successfully purchased Ice Blade for 250 gold.

<Market> Caliber Heist, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: e
Exiting market...

<World> Please enter your action: i

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        1250       NULL                 NULL
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

<World> Please enter your action: b

===== Eunoia Cyn's INVENTORY =====
WEAPON
Name                 Price      Level      Damage     Hands Req
Sword                500        1          800        1
ARMOR
Name                 Price      Level      Damage Red
Platinum Shield      150        1          200
POTION
Name                 Price      Level      Effect Amt      Effect Type
Healing Potion       250        1          100             [HP]
SPELL
Name                 Price      Level      Spell Type      Damage     Mana Cost
Breath of Fire       350        1          FIRE            450        100

===== Caliber Heist's INVENTORY =====
WEAPON
Name                 Price      Level      Damage     Hands Req
Sword                500        1          800        1
SPELL
Name                 Price      Level      Spell Type      Damage     Mana Cost
Ice Blade            250        1          ICE             450        100

<World> Please enter your action: v
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  U  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: s
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  U  |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: a
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  U  |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
You have encountered an enemy! Let's battle!

======== BATTLE ========
MONSTERS APPEAR!
Let's fight!
========================

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        1250       NULL                 NULL
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          100        50         600        75
St-Shargaas          EXOSKELETON     1          100        55         650        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: ew

======== WEAPON ========
Index  Name                 Price      Level      Damage     Hands Req
1      Sword                500        1          800        1
========================

<Inventory> Enter the index of item you choose ('0' to exit): 1
[EVENT] Eunoia Cyn equipped Sword

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: ea

======== ARMOR ========
Index  Name                 Price      Level      Damage Red
1      Platinum Shield      150        1          200
========================

<Inventory> Enter the index of item you choose ('0' to exit): 1
[EVENT] Eunoia Cyn equipped Platinum Shield

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite took 75 damage and now has 25 HP left.

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          25         50         600        75
St-Shargaas          EXOSKELETON     1          100        55         650        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          25         50         600        75
St-Shargaas          EXOSKELETON     1          100        55         650        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite took 75 damage and now has 0 HP left.
[EVENT] Eunoia Cyn defeated BlueEyesWhite!

<Battle> Eunoia Cyn, what will you do?
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
[HERO TURN] St-Shargaas dodged the spell attack! However...
[HERO TURN] St-Shargaas's defense decreased by 20%.

[MONSTER TURN] St-Shargaas is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

[EVENT] Eunoia Cyn recovered some health and mana.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        330        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          0          50         600        75
St-Shargaas          EXOSKELETON     1          100        55         520        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking St-Shargaas
[HERO TURN] St-Shargaas dodged the attack!

[MONSTER TURN] St-Shargaas is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

[EVENT] Eunoia Cyn recovered some health and mana.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        363        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          0          50         600        75
St-Shargaas          EXOSKELETON     1          100        55         520        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking St-Shargaas
[HERO TURN] St-Shargaas dodged the attack!

[MONSTER TURN] St-Shargaas is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

[EVENT] Eunoia Cyn recovered some health and mana.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        399        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          0          50         600        75
St-Shargaas          EXOSKELETON     1          100        55         520        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking St-Shargaas
[HERO TURN] St-Shargaas took 75 damage and now has 25 HP left.

[MONSTER TURN] St-Shargaas is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

[EVENT] Eunoia Cyn recovered some health and mana.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          0          50         600        75
St-Shargaas          EXOSKELETON     1          25         55         520        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking St-Shargaas
[HERO TURN] St-Shargaas dodged the attack!

[MONSTER TURN] St-Shargaas is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          0          50         600        75
St-Shargaas          EXOSKELETON     1          25         55         520        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking St-Shargaas
[HERO TURN] St-Shargaas dodged the attack!

[MONSTER TURN] St-Shargaas is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          6               100        400        700        800        600        1250       Sword                Platinum Shield
Caliber Heist        PALADIN    1          8               100        400        400        400        400        1750       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          1          0          50         600        75
St-Shargaas          EXOSKELETON     1          25         55         520        55
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking St-Shargaas
[HERO TURN] St-Shargaas took 75 damage and now has 0 HP left.
[EVENT] Eunoia Cyn defeated St-Shargaas!

[EVENT] HEROS WIN!
[EVENT] Eunoia Cyn gained 4 experience!
[EVENT] Eunoia Cyn gained 200 gold!
[EVENT] Caliber Heist gained 4 experience!
[EVENT] Caliber Heist Level up to 2!
[EVENT] Caliber Heist gained 200 gold!

<World> Please enter your action: i

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

<World> Please enter your action: v
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  U  |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: s
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |  U  |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: s
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |  U  |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: d
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |  U  |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: s
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |  U  |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: d
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |  U  |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
You have encountered an enemy! Let's battle!

======== BATTLE ========
MONSTERS APPEAR!
Let's fight!
========================

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
Igneel               DRAGON          2          200        100        400        60
Chrysophylax         DRAGON          2          200        100        500        20
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Igneel
[HERO TURN] Igneel dodged the attack!

[MONSTER TURN] Igneel is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
Igneel               DRAGON          2          200        100        400        60
Chrysophylax         DRAGON          2          200        100        500        20
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Igneel
[HERO TURN] Igneel took 75 damage and now has 125 HP left.

[MONSTER TURN] Igneel is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
Igneel               DRAGON          2          125        100        400        60
Chrysophylax         DRAGON          2          200        100        500        20
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Igneel
[HERO TURN] Igneel took 75 damage and now has 50 HP left.

[MONSTER TURN] Igneel is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
Igneel               DRAGON          2          50         100        400        60
Chrysophylax         DRAGON          2          200        100        500        20
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Igneel
[HERO TURN] Igneel took 75 damage and now has 0 HP left.
[EVENT] Eunoia Cyn defeated Igneel!

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Chrysophylax
[HERO TURN] Chrysophylax dodged the attack!

[MONSTER TURN] Chrysophylax is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
Igneel               DRAGON          2          0          100        400        60
Chrysophylax         DRAGON          2          200        100        500        20
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Chrysophylax
[HERO TURN] Chrysophylax took 75 damage and now has 125 HP left.

[MONSTER TURN] Chrysophylax is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
Igneel               DRAGON          2          0          100        400        60
Chrysophylax         DRAGON          2          125        100        500        20
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Chrysophylax
[HERO TURN] Chrysophylax took 75 damage and now has 50 HP left.

[MONSTER TURN] Chrysophylax is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    1          10              100        400        700        800        600        1450       Sword                Platinum Shield
Caliber Heist        PALADIN    2          12              200        400        440        420        440        1950       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
Igneel               DRAGON          2          0          100        400        60
Chrysophylax         DRAGON          2          50         100        500        20
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Chrysophylax
[HERO TURN] Chrysophylax took 75 damage and now has 0 HP left.
[EVENT] Eunoia Cyn defeated Chrysophylax!

[EVENT] HEROS WIN!
[EVENT] Eunoia Cyn gained 4 experience!
[EVENT] Eunoia Cyn Level up to 2!
[EVENT] Eunoia Cyn gained 400 gold!
[EVENT] Caliber Heist gained 4 experience!
[EVENT] Caliber Heist gained 400 gold!

<World> Please enter your action: v
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |  U  |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: s
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |  U  |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
You have encountered an enemy! Let's battle!

======== BATTLE ========
MONSTERS APPEAR!
Let's fight!
========================

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        400        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          200        100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[HERO TURN] Eunoia Cyn took 0 damage and now has 200 HP left.

[EVENT] Eunoia Cyn recovered some health and mana.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          200        100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          200        100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          200        100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite took 78 damage and now has 122 HP left.

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          122        100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          122        100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite took 78 damage and now has 44 HP left.

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          44         100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          44         100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[HERO TURN] Eunoia Cyn took 0 damage and now has 200 HP left.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          44         100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          44         100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          44         100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          44         100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite dodged the attack!

[MONSTER TURN] BlueEyesWhite is attacking Eunoia Cyn
[HERO TURN] Eunoia Cyn took 0 damage and now has 200 HP left.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          44         100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking BlueEyesWhite
[HERO TURN] BlueEyesWhite took 78 damage and now has 0 HP left.
[EVENT] Eunoia Cyn defeated BlueEyesWhite!

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Aasterinian
[HERO TURN] Aasterinian dodged the attack!

[MONSTER TURN] Aasterinian is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          0          100        600        75
Aasterinian          EXOSKELETON     2          200        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Aasterinian
[HERO TURN] Aasterinian took 78 damage and now has 122 HP left.

[MONSTER TURN] Aasterinian is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          0          100        600        75
Aasterinian          EXOSKELETON     2          122        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Aasterinian
[HERO TURN] Aasterinian dodged the attack!

[MONSTER TURN] Aasterinian is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          0          100        600        75
Aasterinian          EXOSKELETON     2          122        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Aasterinian
[HERO TURN] Aasterinian dodged the attack!

[MONSTER TURN] Aasterinian is attacking Eunoia Cyn
[MONSTER TURN] Eunoia Cyn dodged the attack!

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          0          100        600        75
Aasterinian          EXOSKELETON     2          122        100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Aasterinian
[HERO TURN] Aasterinian took 78 damage and now has 44 HP left.

[MONSTER TURN] Aasterinian is attacking Eunoia Cyn
[HERO TURN] Eunoia Cyn took 0 damage and now has 200 HP left.

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          14              200        440        770        880        630        1850       Sword                Platinum Shield
Caliber Heist        PALADIN    2          16              200        400        440        420        440        2350       NULL                 NULL
==========================================

============ MONSTER INFORMATION ============
Name                 Type            Level      HP         Damage     Defense    Dodge
BlueEyesWhite        DRAGON          2          0          100        600        75
Aasterinian          EXOSKELETON     2          44         100        500        45
=============================================

<Battle> Eunoia Cyn, what will you do?
  (A) Attack
  (C) Cast Spell
  (P) Use Potion
  (EW) Equip Weapon
  (EA) Equip Armor
  (I) Display Info
<Battle> Make your choice: a

[HERO TURN] Eunoia Cyn is attacking Aasterinian
[HERO TURN] Aasterinian took 78 damage and now has 0 HP left.
[EVENT] Eunoia Cyn defeated Aasterinian!

[EVENT] HEROS WIN!
[EVENT] Eunoia Cyn gained 4 experience!
[EVENT] Eunoia Cyn gained 400 gold!
[EVENT] Caliber Heist gained 4 experience!
[EVENT] Caliber Heist gained 400 gold!

<World> Please enter your action: i

============ HERO INFORMATION ============
Name                 Type       Level      Experience      HP         MP         Strength   Agility    Dexterity  Gold       Equipped Weapon      Equipped Armor
Eunoia Cyn           WARRIOR    2          18              200        440        770        880        630        2250       Sword                Platinum Shield
Caliber Heist        PALADIN    2          20              200        400        440        420        440        2750       NULL                 NULL
==========================================

<World> Please enter your action: b

===== Eunoia Cyn's INVENTORY =====
POTION
Name                 Price      Level      Effect Amt      Effect Type
Healing Potion       250        1          100             [HP]

===== Caliber Heist's INVENTORY =====
WEAPON
Name                 Price      Level      Damage     Hands Req
Sword                500        1          800        1
SPELL
Name                 Price      Level      Spell Type      Damage     Mana Cost
Ice Blade            250        1          ICE             450        100

<World> Please enter your action: v
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  M  |  U  |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: a
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  X  |  X  |  X  |  X  |     |     |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  X  |     |     |     |  M  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |  M  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  X  |  M  |  X  |  M  |     |  M  |  X  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |  M  |  M  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  X  |  M  |     |  M  |  M  |  M  |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |  X  |  X  |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  M  |  M  |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |  M  |  U  |     |  X  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+-----+
<World> Please enter your action: m

======== MARKET ========
WELCOME TO THE MARKET!
We have weapons, armors, potions, and spells for sale.
Take a look around and see if you find anything you like!
========================

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: d

===== Eunoia Cyn's INVENTORY =====
POTION
Name                 Price      Level      Effect Amt      Effect Type
Healing Potion       250        1          100             [HP]
<Market> Please enter the name of the item you want to sell: Healing Potion
[EVENT] Eunoia Cyn gained 12500 gold!
[EVENT] Eunoia Cyn successfully sold Healing Potion for 125 gold.

<Market> Eunoia Cyn, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: e
Exiting market...

<Market> Caliber Heist, how can I help you?
  (W) Buy Weapon
  (A) Buy Armor
  (P) Buy Potion
  (S) Buy Spell
  (D) Sell your item
  (E) Exit market

<Market> Make your choice: e
Exiting market...

<World> Please enter your action: q

[EXIT] Thank you for playing! Goodbye!
```

