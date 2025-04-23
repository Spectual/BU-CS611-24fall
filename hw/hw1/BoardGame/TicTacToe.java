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
 * It contains methods for players to make moves, check if a player wins or 
 * if the game is a stalemate.
 */

import java.util.Scanner;

public class TicTacToe extends BoardGame{
    protected int lineLengthToWin;

    public TicTacToe() {
        name = "TicTacToe";
        playerCount = 2;
        players = new Player[playerCount];
    }

    @Override
    public String getName() {
        return name;
    }

    // This method starts the game Tic Tac Toe.
    // It allows players to choose the board size, their symbols and the length of pieces.
    // It calls the playGame() function to start the interaction between players.
    @Override
    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to " + getName() + "!\n");    // welcome message

        // let player choose board size, default is 3
        setBoard();

        //  let player choose the line length to win
        setLineLengthToWin();

        // let players choose their symbol
        for (int i = 0; i < playerCount; i++) {
            System.out.print("\nPlayer " + (i + 1) + ", please type your symbol (O or X or whatever u like):");
            
            char symbol = scanner.nextLine().charAt(0);
            players[i] = new Player(Integer.toString(i + 1), symbol);
        }

        while (true) {
            displayPlayerInfo();        // display player info

            System.out.println("\nLet's start the game!");

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
            char symbol;
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

                    // check if the move is within the board or in the correct format
                    if (!board.isValidMove(row, col) || move.length() != 3 || 
                        move.charAt(1) != ' ') {
                        System.out.println("\nOops, Invalid move. Please try the format: row(1-" +
                            boardSize + ") col(1-" + boardSize + ")");
                        continue;
                    }

                    // check if the cell is available
                    Cell[][] cells = board.getCells();
                    if (!cells[row][col].isEmpty()) {
                        System.out.println("\nOops, Invalid move. The cell is already occupied.");
                        continue;
                    }

                    // update and display current board
                    board.updateBoard(row, col, players[currentPlayerIndex].getSymbol());
                    board.displayBoard();

                    break;
                } 
                catch (Exception e) {
                    System.out.println("\nOops, Invalid move. Please try the format: row(1-" +
                        boardSize + ") col(1-" + boardSize + ")");
                }
            }

            // decide if the current player wins
            if (isWin(row, col)) {
                System.out.println("\nPlayer " + players[currentPlayerIndex].getName() + 
                ", You win!");
                players[currentPlayerIndex].changeScoreBy(1);
                break;
            }

            // decide if the game is a stalemate
            if (isStalemate()) {
                System.out.println("\nWell, what a stalemate!");
                break;
            }

            switchPlayer();     // switch to the next player

        }

        displayScore();     // display current score once the game ends
    }

    // This method switches the current player to the next player.
    @Override
    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % playerCount;
    }

    // This method returns true if the current move results in pieces
    // in a line to win, false otherwise.
    @Override
    public boolean isWin(int row, int col) {
        Cell[][] cells = board.getCells();
        char symbol = cells[row][col].getValue();

        // check if pieces in a row line to win
        for (int c = 0; c <= boardSize - lineLengthToWin; c++) {
            for (int i = 0; i < lineLengthToWin; i++) {
                if (cells[row][c + i].getValue() != symbol) {
                    break;
                }
                if (i == lineLengthToWin - 1) {
                    return true;
                }
            }
        }
        // check if pieces in a column line to win
        for (int r = 0; r <= boardSize - lineLengthToWin; r++) {
            for (int i = 0; i < lineLengthToWin; i++){
                if (cells[r + i][col].getValue() != symbol){
                    break;
                }
                if (i == lineLengthToWin - 1){
                    return true;
                }
            }
        }
        // check if pieces in a diagonal line to win
        if (Math.abs(row - col) <= lineLengthToWin - 1) {
            int startRow = row < col ? 0 : row - col;
            int startCol = row < col ? col - row : 0;
            for(int i = 0; i <= boardSize - lineLengthToWin - (Math.abs(row - col)); i++){
                for (int j = 0; j < lineLengthToWin; j++){
                    if (cells[startRow + i + j][startCol + i + j].getValue() != symbol){
                        break;
                    }
                    if (j == lineLengthToWin - 1){
                        return true;
                    }
                }
            }
        }

        // check if pieces in an anti-diagonal line to win
        if ((row + col >= lineLengthToWin - 1) && (row + col <= 2 * (boardSize - 1) - lineLengthToWin + 1)) {

            int startRow = row + col < boardSize - 1 ? 0 : row + col - boardSize + 1;
            int startCol = row + col < boardSize - 1 ? row + col : boardSize - 1;

            for (int i = 0; i <= boardSize - lineLengthToWin - Math.abs((row + col) - (boardSize - 1)); i++) {
                for (int j = 0; j < lineLengthToWin; j++) {
                    if (cells[startRow + i + j][startCol - i - j].getValue() != symbol) {
                        break;
                    }
                    if (j == lineLengthToWin - 1) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    @Override
    public boolean isStalemate() {
        return board.isFull();
    }

    // This method allows players to specify the board size
    // and creates a new board with the specified size.
    @Override
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
                    System.out.println("\nInvalid size! The board size must be between 3 and 9.\n");
                }
            } else {
                System.out.println("\nInvalid input! Please enter a number between 3 and 9.\n");
                scanner.next();  
            }
        }
        
        // create a new board with the specified size
        this.boardSize = boardSize;
        board = new Board(boardSize);
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
                    System.out.println("\nInvalid size! The line length to win must be between 3 and "
                     + boardSize + ".\n");
                }
                
            } else {
                System.out.println("\nInvalid input! Please enter a number between 3 and "
                 + boardSize + ".\n");
                scanner.next();  
            }
        }
    }

    // This method prints the score of each player.
    @Override
    public void displayScore() {
        System.out.println("\nScore:");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + players[i].getName() + ": " + players[i].getScore());
        }
    }

    // This method prints the player information.
    public void displayPlayerInfo() {
        System.out.println("\nPlayers:");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + players[i].getName() + ": " + players[i].getSymbol());
        }
    }
}