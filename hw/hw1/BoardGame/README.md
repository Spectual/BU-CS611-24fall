# CS611-Assignment 1 
## < Tic Tac Toe // Order and Chaos >
---------------------------------------------------------------------------
- Name: Yifei Bao
- Email: baoyifei@bu.edu
- Student ID: U02463348

## Files
---------------------------------------------------------------------------

Cell.java: This class represents a cell in the game board.

Board.java: This class represents a game board and has basic board properties.

Player.java: This class represents a player in the game.

BoardGame.java: This abstract class represents a generic board game.

TicTacToe.java: This class represents the game TicTacToe extending BoardGame. It contains all the basics of interaction and rules of the game.

OrderAndChaos.java: This class represents the Order and Chaos game. It extends TicTacToe because the game is a variation of Tic Tac Toe.

GameLauncher.java: This class is responsible for menu and start of the two sub boardgames.

Main.java: This class is the main class to start the board game.



## Notes
---------------------------------------------------------------------------
1. In the game Tic Tac Toe, user can customize the size of the board (3-9) and even change the rule for how many pieces need to be in a line to win. The line length to win should be no more than the board size, of course.

2. In Tic Tac Toe, user can customize their pieces to be whatever char they like(O,X,@,$,%...).

3. In my design, the class OrderAndChaos extends TicTacToe instead of BoardGame is because the core rules of the two games are very similar except for the size of board and the win condition for two players.
4. For extensibility, I designed the member playerCount in the BoardGame class representing the number of players playing the game because in the future there might be some other board games where more than 2 players are involved. Thus, in the method switchPlayer, I used the modulus operator to get prepared for multiplayer situation.
5. I added a lot of judges to deal with invalid inputs. For example, if the desired input is "1 1" within the size 6, then inputs like "121", "%272x", "1 7" will all be detected as invalid.
6. A little detail: when the user is required to type "Y" for yes, "y" and "Y" should both be OK.
7. I thought a lot about how to write the isWin method. The final optimization strategy I use is to calculate the starting point of the line passing through the placed position and perform a sliding window traversal based on lineLengthToWin. This approach is more efficient than a full global traversal.



## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the source directory "BoardGame" after unzipping the files.

2. Run the following instructions:

   ```
   javac *.java
   java Main
   ```

   

## Input/Output Example
---------------------------------------------------------------------------


```
Output:
Welcome to the board game!

Game Menu:
1. TicTacToe
2. Order and Chaos
0. Exit

Please choose a game to play:
Input:
1
Output:
Welcome to TicTacToe!

Please enter the board size (between 3 and 9):
Input:
3
Output:
Please enter the line length to win (between 3 and 3):
Input:
3
Output:
Player 1, please type your symbol (O or X or whatever u like):
Input:
O
Output:
Player 2, please type your symbol (O or X or whatever u like):
Input:
X
Output:
Players:
Player 1: O
Player 2: X

Let's start the game!

   1   2   3 
1    |   |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

Player1, Make your move:
Input:
1 1
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

Player2, Make your move:
Input:
2 2
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2    | X |  
  ---+---+---
3    |   |  

Player1, Make your move:
Input:
3 3
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2    | X |  
  ---+---+---
3    |   | O

Player2, Make your move:
Input:
3 1
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2    | X |  
  ---+---+---
3  X |   | O

Player1, Make your move:
Input:
3 1
Output:
Oops, Invalid move. The cell is already occupied.

Player1, Make your move:
Input:
4 1
Output:
Oops, Invalid move. Please try the format: row(1-3) col(1-3)

Player1, Make your move:
Input:
2 1
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2  O | X |  
  ---+---+---
3  X |   | O

Player2, Make your move:
Input:
1 3
Output:
   1   2   3 
1  O |   | X
  ---+---+---
2  O | X |  
  ---+---+---
3  X |   | O

Player 2, You win!

Score:
Player 1: 0
Player 2: 1

Wanna play again? (Y/N):
Input:
y
Output:
Players:
Player 1: O
Player 2: X

Let's start the game!

   1   2   3 
1    |   |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

Player1, Make your move:
Input:
1 1
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2    |   |  
  ---+---+---
3    |   |  

Player2, Make your move:
Input:
2 1
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2  X |   |  
  ---+---+---
3    |   |  

Player1, Make your move:
Input:
3 3
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2  X |   |  
  ---+---+---
3    |   | O

Player2, Make your move:
Input:
2 2
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2  X | X |  
  ---+---+---
3    |   | O

Player1, Make your move:
Input:
2 3
Output:
   1   2   3 
1  O |   |  
  ---+---+---
2  X | X | O
  ---+---+---
3    |   | O

Player2, Make your move:
Input:
1 3
Output:
   1   2   3 
1  O |   | X
  ---+---+---
2  X | X | O
  ---+---+---
3    |   | O

Player1, Make your move:
Input:
3 1
Output:
   1   2   3 
1  O |   | X
  ---+---+---
2  X | X | O
  ---+---+---
3  O |   | O

Player2, Make your move:
Input:
3 2
Output:
   1   2   3 
1  O |   | X
  ---+---+---
2  X | X | O
  ---+---+---
3  O | X | O

Player1, Make your move:
Input:
1 2
Output:
   1   2   3 
1  O | O | X
  ---+---+---
2  X | X | O
  ---+---+---
3  O | X | O

Well, what a stalemate!

Score:
Player 1: 0
Player 2: 1

Wanna play again? (Y/N):
Input:
n
Output:
See you next time!

Welcome to the board game!

Game Menu:
1. TicTacToe
2. Order and Chaos
0. Exit

Please choose a game to play:
Input:
2
Output:
Welcome to Order and Chaos!


Let's start the game!

   1   2   3   4   5   6 
1    |   |   |   |   |  
  ---+---+---+---+---+---
2    |   |   |   |   |  
  ---+---+---+---+---+---
3    |   |   |   |   |  
  ---+---+---+---+---+---
4    |   |   |   |   |  
  ---+---+---+---+---+---
5    |   |   |   |   |  
  ---+---+---+---+---+---
6    |   |   |   |   |  

Order's turn.
Choose your symbol (X or O):
Input:
X
Output:
Make your move:
Input:
1 1
Output:
   1   2   3   4   5   6 
1  X |   |   |   |   |  
  ---+---+---+---+---+---
2    |   |   |   |   |  
  ---+---+---+---+---+---
3    |   |   |   |   |  
  ---+---+---+---+---+---
4    |   |   |   |   |  
  ---+---+---+---+---+---
5    |   |   |   |   |  
  ---+---+---+---+---+---
6    |   |   |   |   |  

Chaos's turn.
Choose your symbol (X or O):
Input:
O
Output:
Make your move:
Input:
1 2
Output:
   1   2   3   4   5   6 
1  X | O |   |   |   |  
  ---+---+---+---+---+---
2    |   |   |   |   |  
  ---+---+---+---+---+---
3    |   |   |   |   |  
  ---+---+---+---+---+---
4    |   |   |   |   |  
  ---+---+---+---+---+---
5    |   |   |   |   |  
  ---+---+---+---+---+---
6    |   |   |   |   |  

Order's turn.
Choose your symbol (X or O):
Input:
@
Output:
Invalid symbol! Try again.
Choose your symbol (X or O):
Input:
X
Output:
Make your move:
Input:
2 2
Output:
   1   2   3   4   5   6 
1  X | O |   |   |   |  
  ---+---+---+---+---+---
2    | X |   |   |   |  
  ---+---+---+---+---+---
3    |   |   |   |   |  
  ---+---+---+---+---+---
4    |   |   |   |   |  
  ---+---+---+---+---+---
5    |   |   |   |   |  
  ---+---+---+---+---+---
6    |   |   |   |   |  

Chaos's turn.
Choose your symbol (X or O):
Input:
X
Output:
Make your move:
Input:
3 3
Output:
   1   2   3   4   5   6 
1  X | O |   |   |   |  
  ---+---+---+---+---+---
2    | X |   |   |   |  
  ---+---+---+---+---+---
3    |   | X |   |   |  
  ---+---+---+---+---+---
4    |   |   |   |   |  
  ---+---+---+---+---+---
5    |   |   |   |   |  
  ---+---+---+---+---+---
6    |   |   |   |   |  

Order's turn.
Choose your symbol (X or O):
Input:
X
Output:
Make your move:
Input:
4 4
Output:
   1   2   3   4   5   6 
1  X | O |   |   |   |  
  ---+---+---+---+---+---
2    | X |   |   |   |  
  ---+---+---+---+---+---
3    |   | X |   |   |  
  ---+---+---+---+---+---
4    |   |   | X |   |  
  ---+---+---+---+---+---
5    |   |   |   |   |  
  ---+---+---+---+---+---
6    |   |   |   |   |  

Chaos's turn.
Choose your symbol (X or O):
Input:
O
Output:
Make your move:
Input:
6 7
Output:
Oops, Invalid move. Please try the format: row(1-6) col(1-6)
Make your move:
Input:
6 6
Output:
   1   2   3   4   5   6 
1  X | O |   |   |   |  
  ---+---+---+---+---+---
2    | X |   |   |   |  
  ---+---+---+---+---+---
3    |   | X |   |   |  
  ---+---+---+---+---+---
4    |   |   | X |   |  
  ---+---+---+---+---+---
5    |   |   |   |   |  
  ---+---+---+---+---+---
6    |   |   |   |   | O

Order's turn.
Choose your symbol (X or O):
Input:
X
Output:
Make your move:
Input:
5 5
Output:
   1   2   3   4   5   6 
1  X | O |   |   |   |  
  ---+---+---+---+---+---
2    | X |   |   |   |  
  ---+---+---+---+---+---
3    |   | X |   |   |  
  ---+---+---+---+---+---
4    |   |   | X |   |  
  ---+---+---+---+---+---
5    |   |   |   | X |  
  ---+---+---+---+---+---
6    |   |   |   |   | O

Order wins!

Score:
Player Order: 1
Player Chaos: 0

Wanna play again? (Y/N):
Input:
n
Output:
See you next time!

Output:
Game Menu:
1. TicTacToe
2. Order and Chaos
0. Exit

Please choose a game to play:
Input:
1
Output:
Welcome to TicTacToe!

Please enter the board size (between 3 and 9):
Input:
5
Output:
Please enter the line length to win (between 3 and 5):
Input:
4
Output:
Player 1, please type your symbol (O or X or whatever u like):
Input:
@
Output:
Player 2, please type your symbol (O or X or whatever u like):
Input:
$
Output:
Players:
Player 1: @
Player 2: $

Let's start the game!

   1   2   3   4   5 
1    |   |   |   |  
  ---+---+---+---+---
2    |   |   |   |  
  ---+---+---+---+---
3    |   |   |   |  
  ---+---+---+---+---
4    |   |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player1, Make your move:
Input:
3 3
Output:
   1   2   3   4   5 
1    |   |   |   |  
  ---+---+---+---+---
2    |   |   |   |  
  ---+---+---+---+---
3    |   | @ |   |  
  ---+---+---+---+---
4    |   |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player2, Make your move:
Input:
1 2
Output:
   1   2   3   4   5 
1    | $ |   |   |  
  ---+---+---+---+---
2    |   |   |   |  
  ---+---+---+---+---
3    |   | @ |   |  
  ---+---+---+---+---
4    |   |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player1, Make your move:
Input:
1 5
Output:
   1   2   3   4   5 
1    | $ |   |   | @
  ---+---+---+---+---
2    |   |   |   |  
  ---+---+---+---+---
3    |   | @ |   |  
  ---+---+---+---+---
4    |   |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player2, Make your move:
Input:
2 3
Output:
   1   2   3   4   5 
1    | $ |   |   | @
  ---+---+---+---+---
2    |   | $ |   |  
  ---+---+---+---+---
3    |   | @ |   |  
  ---+---+---+---+---
4    |   |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player1, Make your move:
Input:
2 4
Output:
   1   2   3   4   5 
1    | $ |   |   | @
  ---+---+---+---+---
2    |   | $ | @ |  
  ---+---+---+---+---
3    |   | @ |   |  
  ---+---+---+---+---
4    |   |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player2, Make your move:
Input:
1 1
Output:
   1   2   3   4   5 
1  $ | $ |   |   | @
  ---+---+---+---+---
2    |   | $ | @ |  
  ---+---+---+---+---
3    |   | @ |   |  
  ---+---+---+---+---
4    |   |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player1, Make your move:
Input:
4 2
Output:
   1   2   3   4   5 
1  $ | $ |   |   | @
  ---+---+---+---+---
2    |   | $ | @ |  
  ---+---+---+---+---
3    |   | @ |   |  
  ---+---+---+---+---
4    | @ |   |   |  
  ---+---+---+---+---
5    |   |   |   |  

Player 1, You win!

Score:
Player 1: 1
Player 2: 0

Wanna play again? (Y/N):
Input:
n
Output:
See you next time!

Welcome to the board game!

Game Menu:
1. TicTacToe
2. Order and Chaos
0. Exit

Please choose a game to play:
Input:
0
Output:
See you next time!
```
