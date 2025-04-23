/**
 * SuperTicTacToe.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 10/4/2024
 * 
 * This class represents the Super Tic Tac Toe game. 
 * It extends the TicTacToe class because it is 
 * a variation of TicTacToe.
 * The difference is that the Super Tic Tac Toe game is played
 * on a 3x3 board of 3x3 boards. Each cell in the big board is a
 * small board. Players take turns to place their pieces in the
 * small boards. The player who wins the small board can place
 * their piece in the big board. The player who wins the big board
 * wins the game.
 * Therefore, this class simply overrides the startGame(), playGame(),
 * and setBoard() methods from the TicTacToe class.
 */

import java.util.Scanner;

public class SuperTicTacToe extends TicTacToe{
    protected SuperBoard board;

    public SuperTicTacToe() {
        super();
        name = "Super Tic Tac Toe";
        boardSize = 3;
        lineLengthToWin = 3;
    }

    @Override
    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to " + getName() + "!");    // welcome message

        setBoard();

        // let players choose their symbol
        for (int i = 0; i < playerCount; i++) {
            System.out.print("\nPlayer " + (i + 1) + ", please type your symbol (O or X or whatever u like):");
            
            char symbol = scanner.nextLine().charAt(0);
            players[i] = new Player(Integer.toString(i + 1), new Piece(symbol));
        }

        while (true) {
            displayPlayerInfo();        // display player info

            System.out.println("\nLet's start the game!\n");
            System.out.println("------------------------------------\n");
            System.out.println("Super Tic Tac Toe is a 3x3 board game.");
            System.out.println("Make your move in the format of 'SuperRow SuperCol SubRow SubCol', e.g. '1 2 1 1'.");
            System.out.println("SuperRow and SuperCol are the coordinates of the big super board.");
            System.out.println("SubRow and SubCol are the coordinates of the small board.");
            System.out.println("If there is a winner in a small board, then " +
                            "the board will be fullfilled by the winner's " +
                            "symbol.");
            System.out.println("If there is a stalemate in a small board, " +
                    "then the board will be fullfilled by the letter 'S'.");
            System.out.println("\n------------------------------------\n");

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

    @Override
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        currentPlayerIndex = 0; // player 1 starts first

        board.clearBoard();     // clear the board

        board.displayBoard();   // display empty board

        while (true) {
            String move;
            int superRow;
            int superCol;
            int row;
            int col;

            // player makes move by typing in the format of "superRow superCol"
            while (true) {            
                System.out.print("\nPlayer " + players[currentPlayerIndex].getPiece() +
                 ", Make your move:");
                move = scanner.nextLine();

                try {
                    superRow = move.charAt(0) - '1';
                    superCol = move.charAt(2) - '1';
                    row = move.charAt(4) - '1';
                    col = move.charAt(6) - '1';

                    // update current board
                    boolean isUpdated = board.updateBoard(superRow, superCol, row, col, players[currentPlayerIndex].getPiece());
                    
                    // check if the cell is available
                    if (!isUpdated) {
                        System.out.println("\nOops, Invalid move. The cell is already occupied.");
                        continue;
                    }

                    
                    board.displayBoard();
                    break;
                } 
                catch (Exception e) {
                    System.out.println("\nOops, Invalid move. Please try the format: SuperRow(1-" +
                        boardSize + ") SuperCol(1-" + boardSize + ") SubRow(1-" + boardSize + 
                        ") SubCol(1-" + boardSize + ")");
                }
            }

            // decide if the current player wins
            if (board.checkWin(superRow, superCol, lineLengthToWin)) {
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

    @Override
    public void setBoard() {
        board = new SuperBoard(boardSize);
    }

}
