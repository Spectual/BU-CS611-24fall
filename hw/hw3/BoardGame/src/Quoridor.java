/**
 * Quoridor.java
 * by Yuanhang Xu (xxxqivzz@bu.edu), Yifei Bao (baoyifei@bu.edu)
 * 10/19/2024
 * 
 * This class represents the game Quoridor.
 * It extends the BoardGame class.
 * It contains the specific rules and methods for the Quoridor game.
 * It also contains basic helper interaction methods for the game.
 * It allows players to choose number of players, their symbols.
 * It contains basic game flow logic.
 */

import java.util.*;

public class Quoridor extends BoardGame {
    private QuoBoard board;
    protected QuoPlayer[] players;
    private static final Scanner scanner = new Scanner(System.in);

    public Quoridor() {
        name = "Quoridor";
        boardSize = 9;
        board = new QuoBoard(this.boardSize);
    }

    // This method starts the game Quoridor.
    // It allows players to choose the number of players, their symbols.
    // It calls the playGame() function to start the interaction between players.
    public void startGame() {

        displayGameInfo();  // Display game information

        // Get valid player count (2 or 4)
        playerCount = getValidInput("Enter the number of players (2 or 4): ",
                 2,4);
        players = new QuoPlayer[playerCount];

        int fenceAmount = 20;
        String[] colors = {"\033[32m", "\033[34m", "\033[31m", "\033[33m"};  // Fence colors
        String[] startingSerial = {"Up", "Down", "Left", "Right"};  // Starting points

        // let players choose their symbol and initialize players
        for (int i = 0; i < playerCount; i++) {
            char symbol = getValidSymbolInput(i + 1);
            String fenceColor = colors[i % colors.length];

            // Create the player and assign the starting point
            players[i] = new QuoPlayer(Integer.toString(i + 1), new Piece(symbol),
                    fenceColor, startingSerial[i], fenceAmount / playerCount);
        }

        // Game loop
        while (true) {
            displayPlayerInfo();  // display player info

            System.out.println("\nLet's start the game!");
            System.out.println("(Make your move following the instructions)");

            playGame();     

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
    // It allows players to make moves and place fences.
    // It checks if a player has won and updates the board accordingly.
    public void playGame() {
        // Scanner scanner = new Scanner(System.in);

        currentPlayerIndex = 0; // player 1 starts first

        resetPlayers();     // reset player positions
        board.initializeBoard(players);  // Initialize the board with players
        board.displayBoard(players, new int[0]);   // display empty board

        while (true) {

            QuoPlayer currentPlayer = players[currentPlayerIndex];
            Piece piece = players[currentPlayerIndex].getPiece();

            //let player choose to move or put fence
            System.out.print("\nPlayer " + currentPlayer.getName() + "(" +
                currentPlayer.getPiece() + ") ,");

            // Get valid move type (1 or 2)
            int moveType = getValidInput(
                    "Choose an action: 1 - Make Move, 2 - Place Fence: ",
                    1,2
            );

            if (moveType == 1) {    // Make Move
                // display valid moves
                int[] validMoves = board.getValidMoves(currentPlayer.getPosition());
                board.displayBoard(players, validMoves);   // display board with valid moves
                System.out.print("\nValid moves: ");
                for (int i = 0; i < validMoves.length; i++) {
                    System.out.print(validMoves[i] + ", ");
                }

                // let player choose a move
                int move = getValidInput("\nPlayer " + currentPlayer.getName() + "(" +
                                currentPlayer.getPiece() + ")" + " choose your move (or 0 to go back): ", validMoves);
                if (move == -1) {
                    System.out.println("Returning to action selection...");
                    board.displayBoard(players, new int[0]);
                    continue;  // Go back to action selection
                }
                // update board with new move and remove past moves
                // and update the player's position
                board.updateBoardWithMove(currentPlayer, move);
            } else {    // Put Fence
                // Exit from the loop or logic if no fences are left
                if (currentPlayer.getfenceCount() > 0) System.out.println("\nYou have " +
                 currentPlayer.getfenceCount() + " fences left.");
                else {
                    System.out.println("No fences remaining! You can't place more fences.");
                    continue;
                }

                int fenceSerialStart = 0;
                int fenceSerialEnd = 0;
                char side = ' ';

                // Get fence information from the user
                while (true) {
                    // Get fence start and end positions
                    fenceSerialStart = getValidInput("Enter the starting position of the fence (or 0 to go back) : ",
                     1, boardSize * boardSize, players);
                    if (fenceSerialStart == -1) {
                        System.out.println("Returning to action selection...");
                        switchBackPlayer();
                        break;  // Return to action selection
                    }

                    fenceSerialEnd = getValidInput("Enter the ending position of the fence (or 0 to go back) : ",
                     1, boardSize * boardSize, players);
                    if (fenceSerialEnd == -1) {
                        System.out.println("Returning to action selection...");
                        switchBackPlayer();
                        break;  // Return to action selection
                    }

                    side = getValidSideInput("Enter the side for the fence U (Up), D (Down), L (Left), R (Right) (or 0 to go back): ");
                    if (side == '0') {
                        System.out.println("Returning to action selection...");
                        switchBackPlayer();
                        break;  // Return to action selection
                    }

                    // Validate the fence placement and put fence
                    boolean isValidFence = board.hasPathToGo(players,
                            currentPlayer, fenceSerialStart, fenceSerialEnd, side);

                    // Update the board with the fence if it is valid
                    if (isValidFence) {
                        board.updateBoardWithFence(currentPlayer, fenceSerialStart, fenceSerialEnd,
                            side, true);
                        System.out.println("Fence placed!");
                        currentPlayer.changeFenceCountBy(-1);
                        break;
                    }else {
                        System.out.println("Oops, Invalid fence placement. Try again!\n");
                    }
                }
            }

            board.displayBoard(players, new int[0]);   // display the updated board

            // decide if the current player wins
            if (board.checkWin(currentPlayer)) {
                System.out.println("\nPlayer " + currentPlayer.getName() +
                        "(" + currentPlayer.getPiece() + ")" +
                        ", You win!");
                currentPlayer.changeScoreBy(1);
                break;
            }

            switchPlayer();     // switch to the next player
        }
        displayScore();     // display current score once the game ends
    }

    public void switchBackPlayer() {
        currentPlayerIndex = (currentPlayerIndex - 1 + playerCount) % playerCount;
    }
    // This method resets the player positions to their starting positions.
    public void resetPlayers() {
        for (int i = 0; i < playerCount; i++) {
            players[i].resetPosition();
        }
    }

    public void displayGameInfo(){
        System.out.println("------------------------------------\n");
        System.out.println("Welcome to " + getName() + "!");
        System.out.println("Quoridor is a strategy board game for 2 or 4 players.\n" +
                "The objective of the game is to be the first player to reach the opposite side of the board.\n" +
                "Players can move their pieces or place fences to block their opponents.\n" +
                "Player share 20 fences and can place them to block other players.\n" +
                "Fences can be placed vertically or horizontally to block the path of the opponents.\n" +
                "Fence will be marked with the player's color.\n" +
                "Example of placing a fence: 3 4 D (Place a fence from position 3 to 4 on the down side)");
        System.out.println("\n------------------------------------\n");
    }
    // This method prints the score of each player.
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

    // Common method to get valid integer input with error handling
    private static int getIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear invalid input
            }
        }
    }

    // Method to get a valid integer input within a range
    public static int getValidInput(String prompt, int first, int second) {
        while (true) {
            int input = getIntegerInput(prompt);
            if (input == first || input == second) return input;

            System.out.println("Invalid input. Please enter a number between " + first + " and " + second + ".");
        }
    }

    // Method to get a valid integer input from an array of valid options
    public static int getValidInput(String prompt, int[] validInputs) {
        while (true) {
            int input = getIntegerInput(prompt);

            // Handle "go back" with special input (e.g., 0)
            if (input == 0) return -1;  // Signal to go back

            for (int valid : validInputs) {
                if (input == valid) return input;  // Valid input
            }

            System.out.println("Invalid choice. Please select a valid number from the given options.");
        }
    }

    // Method to get a valid input (either number or player symbol)
    public static int getValidInput(String prompt, int min, int max, QuoPlayer[] players) {
        while (true) {
            System.out.print(prompt);
            String userInput = scanner.nextLine().trim();  // Read input

            try {
                int input = Integer.parseInt(userInput);
                if (input == 0) return -1;  // Signal to go back
                if (input >= min && input <= max) return input;  // Valid input

                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                if (players != null) {
                    for (QuoPlayer player : players) {
                        if (userInput.equals(String.valueOf(player.getPiece().getSymbol()))) {
                            return player.getPosition();  // Return matching position
                        }
                    }
                }
                System.out.println("Invalid input. Enter a valid symbol or board position.");
            }
        }
    }

    // Method to get a valid side input (U, D, L, R)
    public static char getValidSideInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String userInput = scanner.nextLine().trim().toUpperCase();

            if (userInput.length() == 1 && "UDLR0".contains(userInput)) {
                return userInput.charAt(0);  // Valid input
            } else {
                System.out.println("Invalid input. Please enter U, D, L, or R.");
            }
        }
    }

    // Method to limit the creation of player.
    public char getValidSymbolInput(int playerNumber) {
        while (true) {
            System.out.print("\nPlayer " + playerNumber +
                    ", please enter a single, non-numeric character as symbol (e.g. O, X, $, @): ");
            String input = scanner.nextLine().trim();  // Read input and trim any spaces

            // Check if the input is exactly one character and not a digit
            if (input.length() == 1 && !Character.isDigit(input.charAt(0))) return input.charAt(0);  // Valid symbol, return it
            else System.out.println("Invalid input. Please enter a single, non-numeric character (e.g., O, X, $, @).");
        }
    }

}
