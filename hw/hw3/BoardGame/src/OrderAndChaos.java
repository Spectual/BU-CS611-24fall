/**
 * OrderAndChaos.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents the Order and Chaos game. 
 * It extends the TicTacToe class because Order and Chaos is 
 * a variation of TicTacToe.
 * The difference is that Order and Chaos has a larger board size 
 * of 6x6 and a different win condition.
 * In Order and Chaos, both Order and Chaos players can use 'O' 
 * or 'X' as their symbols in each turn. And Order wins if there
 * are 5 like pieces in a row, column, or diagonal. Chaos wins if 
 * the board is full.
 * Therefore, this class simply overrides the startGame(), playGame(),
 * and setBoard() methods from the TicTacToe class.
 */

import java.util.Scanner;

public class OrderAndChaos extends TicTacToe {

    public OrderAndChaos(){
        name = "Order and Chaos";
        boardSize = 6;
        lineLengthToWin = 5;
        playerCount = 2;
        players = new Player[playerCount];
    }

    // This method starts the game.
    @Override
    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to " + getName() + "!\n");    // welcome message

        setBoard();

        // initialize 2 players Order and Chaos
        players[0] = new Player("Order");
        players[1] = new Player("Chaos");

        while (true) {
            System.out.println("\nLet's start the game!");

            playGame();     // play the game

            // check if players want to play again or exit
            System.out.print("\nWanna play again? (Y/N):");
            char playAgain = scanner.nextLine().charAt(0);
            if (playAgain == 'Y' || playAgain == 'y') {
                continue;
            } else {
                System.out.println("\nSee U next time!");
                break;
            }
        }

    }

    @Override
    public void playGame(){
        Scanner scanner = new Scanner(System.in);

        currentPlayerIndex = 0;     // Order starts first

        board.clearBoard();         // clear the board
        board.displayBoard();       // display empty board

        while (true) {

            System.out.println("\n"+ players[currentPlayerIndex].getName() +
             "'s turn.");

            char symbol;
            String move;
            int row;
            int col;

            // let Order or Chaos choose their symbol (X or O)
            while (true) {
                System.out.print("Choose your symbol (X or O):");
                symbol = scanner.nextLine().charAt(0);
                symbol = Character.toUpperCase(symbol);
                if ((symbol == 'X' || symbol == 'O')) {
                    players[currentPlayerIndex].setPiece(new Piece(symbol));
                    break;
                } else {
                    System.out.println("Invalid symbol! Try again.");
                }
            }

            // player makes move by typing in the format of "row col"
            while (true) {
                System.out.print("Make your move:");

                move = scanner.nextLine();

                try {
                    row = move.charAt(0) - '1';
                    col = move.charAt(2) - '1';
    
                    // update current board by the move
                    boolean isUpdated = board.updateBoard(row, col,
                            players[currentPlayerIndex].getPiece());
                    
                    // check if the cell is available
                    if (!isUpdated) {
                        System.out.println("\nOops, Invalid move. " +
                                "The cell is already occupied.");
                        continue;
                    }

                    board.displayBoard();
    
                    break;
    
                } 
                catch (Exception e) {
                    System.out.println("\nOops, Invalid move. Please try the format: row(1-" +
                         boardSize + ") col(1-" + boardSize + ")");
                }
            }

            // decide if Order wins
            if (board.checkWin(row, col, lineLengthToWin)) {
                System.out.println("\n" + players[0].getName() +
                 " wins!");
                players[0].changeScoreBy(1);
                break;
            }

            // decide if Chaos wins
            if (board.checkStalemate()) {
                System.out.println("\n" + players[1].getName() +
                 " wins!");
                players[1].changeScoreBy(1);
                break;
            }

            switchPlayer();     // switch to the next player
        }
        
        displayScore();     // display current score once the game ends
    }

    // This method creates a new 6x6 board.
    @Override
    public void setBoard(){
        board = new TTTBoard(boardSize);
    }



}