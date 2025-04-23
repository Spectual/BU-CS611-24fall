/**
 * TicTacToe.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 9/21/2024
 * 
 * This class represents the game TicTacToe. 
 * It extends the BoardGame class.
 * It contains the specific rules and methods for the TicTacToe game.
 * It allows players to choose the board size, their symbols and the length of pieces
 * in a line to win.
 * It contains basic game flow logic.
 */

import java.util.Scanner;

public class TicTacToe extends BoardGame{
    protected int lineLengthToWin;
    protected TTTBoard board;

    public TicTacToe() {
        name = "TicTacToe";
        playerCount = 2;
        players = new Player[playerCount];
    }

    // This method starts the game Tic Tac Toe.
    // It allows players to choose the board size, their symbols and the length
    // of pieces.
    // It calls the playGame() function to start the interaction between players.
    @Override
    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to " + getName() + "!\n");// welcome message

        // let player choose board size, default is 3
        setBoard();

        //  let player choose the line length to win
        setLineLengthToWin();

        // let players choose their symbol
        for (int i = 0; i < playerCount; i++) {
            System.out.print("\nPlayer " + (i + 1) + ", please type your " +
                    "symbol (O or X or whatever u like):");
            
            char symbol = scanner.nextLine().charAt(0);
            players[i] = new Player(Integer.toString(i + 1), new Piece(symbol));
        }

        while (true) {
            displayPlayerInfo();        // display player info

            System.out.println("\nLet's start the game!");
            System.out.println("(Make your move in the format of 'row col', " +
                    "e.g. '1 1')");

            playGame();     // play the game

            // check if players want to play again
            System.out.print("\nWanna play again? (Y/N):");
            char playAgain = scanner.nextLine().charAt(0);
            if (playAgain == 'Y' || playAgain == 'y') {
                continue;
            } else {
                System.out.println("\nSee you next time!");
                break;
            }
        }

    }

    // This method starts the interaction between players.
    // It allows players to make moves and check if a player wins 
    // or if the game is a stalemate.
    // It displays the score once the game ends.
    @Override
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        currentPlayerIndex = 0; // player 1 starts first

        board.clearBoard();     // clear the board
        board.displayBoard();   // display empty board

        while (true) {
            String move;
            int row;
            int col;

            // player makes move by typing in the format of "row col"
            while (true) {            
                System.out.print("\nPlayer" + players[currentPlayerIndex].getName() +
                 ", Make your move:");
           
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
                    System.out.println("\nOops, Invalid move. " +
                            "Please try the format: row(1-" +
                        boardSize + ") col(1-" + boardSize + ")");
                }
            }

            // decide if the current player wins
            if (board.checkWin(row, col, lineLengthToWin)) {
                System.out.println("\nPlayer " + players[currentPlayerIndex].getName() + 
                ", You win!");
                players[currentPlayerIndex].changeScoreBy(1);
                break;
            }

            // decide if the game is a stalemate
            if (board.checkStalemate()) {
                System.out.println("\nWell, what a stalemate!");
                break;
            }

            switchPlayer();     // switch to the next player

        }

        displayScore();     // display current score once the game ends
    }

    // This method allows players to specify the board size
    // and creates a new board with the specified size.
    public void setBoard() {
        Scanner scanner = new Scanner(System.in);
        boardSize = 3;  // default board size is 3

        // let player enter the board size
        while (true) {
            System.out.print("Please enter the board size (between 3 and 9): ");
            
            // check if the input is an integer
            if (scanner.hasNextInt()) {
                boardSize = scanner.nextInt();
                
                // check if the input is between 3 and 9
                if (boardSize >= 3 && boardSize <= 9) {
                    break;  
                } else {
                    System.out.println("\nInvalid size! The board size must be " +
                            "between 3 and 9.\n");
                }
            } else {
                System.out.println("\nInvalid input! Please enter a number " +
                        "between 3 and 9.\n");
                scanner.next();  
            }
        }
        
        // create a new board with the specified size
        this.boardSize = boardSize;
        board = new TTTBoard(boardSize);
    }

    // This method allows players to specify the line length to win.
    public void setLineLengthToWin() {
        Scanner scanner = new Scanner(System.in);
        lineLengthToWin = 3;  // default line length to win is 3

        // let player choose the line length to win
        while (true) {
            System.out.print("Please enter the line length to win (between 3 and "
             + boardSize + "): ");
            
            // check if the input is an integer
            if (scanner.hasNextInt()) {
                lineLengthToWin = scanner.nextInt();
                // check if the input is between 3 and boardSize
                if (lineLengthToWin >= 3 && lineLengthToWin <= boardSize) {
                    break;  
                } else {
                    System.out.println("\nInvalid size! The line length to win " +
                            "must be between 3 and " + boardSize + ".\n");
                }
                
            } else {
                System.out.println("\nInvalid input! Please enter a number " +
                        "between 3 and " + boardSize + ".\n");
                scanner.next();  
            }
        }
    }

    // This method prints the score of each player.
    @Override
    public void displayScore() {
        System.out.println("\nScore:");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + players[i].getName() + ": " +
                    players[i].getScore());
        }
    }

    // This method prints the player information.
    public void displayPlayerInfo() {
        System.out.println("\nPlayers:");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + players[i].getName() + ": " +
                    players[i].getPiece());
        }
    }
}