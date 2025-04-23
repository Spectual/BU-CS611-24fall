/**
 * QuoBoard.java
 * by Yuanhang Xu (xxxqivzz@bu.edu), Yifei Bao (baoyifei@bu.edu)
 * 10/19/2024
 * 
 * This class represents the Quoridor board. It contains the size of the board and
 * a 2D array of cells that represent the board. It contains methods to initialize the board,
 * update the board with player moves and fence placements, check if a player has a path to their goal,
 * check if a player has won, and display the board.
 * 
 * In this design, a fence is represented by a boolean value in the QuoCell class.
 * A fence can be placed on the right or up side of a cell. When displaying the board,
 * a fence is represented by a vertical or horizontal line between cells with a color to indicate the player.
 */

import java.util.*;

public class QuoBoard {
    private int boardSize;
    private QuoCell[][] cells;

    public QuoBoard(int boardSize) {
        // create 9x9 cells
        this.boardSize = boardSize;   // initialize size of the board

        // initialize a 2D array of cells to represent the board
        cells  = new QuoCell[boardSize][boardSize];  
        for (int r = 0; r < boardSize; r++) {
            for(int c = 0; c < boardSize; c++) {
                cells[r][c] = new QuoCell();
            }
        }
    }

    // Helper method to convert a 1D cell number to a 2D (row, col) position
    private int[] convertPositionTo2D(int cellNumber) {
        int row = (cellNumber - 1) / boardSize;
        int col = (cellNumber - 1) % boardSize;
        return new int[]{row, col};
    }

    // Helper method to convert a 2D (row, col) position to a 1D cell number
    private int convertPositionTo1D(int row, int col) {
        return row * boardSize + col + 1;
    }
    
    // This method initializes the board with players' pieces
    public void initializeBoard(QuoPlayer[] players) {
        //Clear board first
        clearBoard();
        // Place player pieces on the board
        for (QuoPlayer player : players) {
            int[] position = convertPositionTo2D(player.getPosition());
            cells[position[0]][position[1]].placePiece(player.getPiece());
        }
    }

    // This method clears the board by removing all pieces and fences
    public void clearBoard(){
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                cells[r][c].removePiece();
                cells[r][c].setUpSide(false);
                cells[r][c].setRightSide(false);
            }
        }
    }

    // This method updates the board with a player's move
    // It removes the player's piece from the old position and places it on the new position
    public void updateBoardWithMove(QuoPlayer player, int move) {
        int[] newPosition = convertPositionTo2D(move);
        int[] oldPosition = convertPositionTo2D(player.getPosition());

        player.setPosition(move);   // update player's position

        cells[oldPosition[0]][oldPosition[1]].removePiece();    // remove piece from the old position
        cells[newPosition[0]][newPosition[1]].placePiece(player.getPiece());    // place the piece to the new position
    }

    // This method updates the board with a fence placement
    // And set the fence color to the player's color
    public void updateBoardWithFence(QuoPlayer player, int fenceSerialStart,
                                     int fenceSerialEnd, char side, boolean isFence){
        int[] startPosition = convertPositionTo2D(fenceSerialStart);
        int[] endPosition = convertPositionTo2D(fenceSerialEnd);
        String fenceColor = isFence ? player.getFenceColor() : " ";

        if (side == 'L'){
            cells[startPosition[0]][startPosition[1]-1].setRightSide(isFence);
            cells[startPosition[0]][startPosition[1]-1].setRightFenceColor(fenceColor);
            cells[endPosition[0]][endPosition[1]-1].setRightSide(isFence);
            cells[endPosition[0]][endPosition[1]-1].setRightFenceColor(fenceColor);
        }
        if (side == 'R'){
            cells[startPosition[0]][startPosition[1]].setRightSide(isFence);
            cells[startPosition[0]][startPosition[1]].setRightFenceColor(fenceColor);
            cells[endPosition[0]][endPosition[1]].setRightSide(isFence);
            cells[endPosition[0]][endPosition[1]].setRightFenceColor(fenceColor);
        }
        if (side == 'U'){
            cells[startPosition[0]][startPosition[1]].setUpSide(isFence);
            cells[startPosition[0]][startPosition[1]].setUpFenceColor(fenceColor);
            cells[endPosition[0]][endPosition[1]].setUpSide(isFence);
            cells[endPosition[0]][endPosition[1]].setUpFenceColor(fenceColor);
        }
        if (side == 'D'){
            cells[startPosition[0]+1][startPosition[1]].setUpSide(isFence);
            cells[startPosition[0]+1][startPosition[1]].setUpFenceColor(fenceColor);
            cells[endPosition[0]+1][endPosition[1]].setUpSide(isFence);
            cells[endPosition[0]+1][endPosition[1]].setUpFenceColor(fenceColor);
        }
    }

    // This method checks if the fence placement is valid.
    // And it checks if players has a path to their goal
    // It temporarily places a fence on the board and checks if all players have a path to their goal
    // using BFS. If a player is blocked, the fence placement is invalid and the method returns false.
    public boolean hasPathToGo(QuoPlayer[] players, QuoPlayer currentPlayer,
                               int fenceSerialStart, int fenceSerialEnd, char side) {
        /** Playing serial: UP Down Left Right **/
        // Calculate the row and column for the two cells
        char left = 'L';
        char right = 'R';
        char up = 'U';
        char down = 'D';

        int rowStart = (fenceSerialStart - 1) / boardSize;
        int colStart = (fenceSerialStart - 1) % boardSize;
        int rowEnd = (fenceSerialEnd - 1) / boardSize;
        int colEnd = (fenceSerialEnd - 1) % boardSize;

        // Check Left fence placement
        if (side == left) {
            if (colStart != colEnd) {
                System.out.println("Invalid: Left fence must be in same column.");
                return false;
            }
            if (Math.abs(rowStart - rowEnd) != 1) {
                System.out.println("Invalid: Left fence must span exactly one row.");
                return false;
            }
            if (colStart == 0) {
                System.out.println("Invalid: Cannot place Left fence on the left edge of the board.");
                return false;
            }
            if (cells[rowStart][colStart - 1].getRightSide()) {
                System.out.println("Invalid: There is already a Left fence on the starting cell.");
                return false;
            }
            if (cells[rowEnd][colEnd - 1].getRightSide()) {
                System.out.println("Invalid: There is already a Left fence on the ending cell.");
                return false;
            }
        }

        // Check Right fence placement
        else if (side == right) {
            if (colStart != colEnd) {
                System.out.println("Invalid: Right fence must be in same column.");
                return false;
            }
            if (Math.abs(rowStart - rowEnd) != 1) {
                System.out.println("Invalid: Right fence must span exactly one row.");
                return false;
            }
            if (colEnd == boardSize - 1) {
                System.out.println("Invalid: Cannot place Right fence on the right edge of the board.");
                return false;
            }
            if (cells[rowStart][colStart].getRightSide()) {
                System.out.println("Invalid: There is already a Right fence the starting cell.");
                return false;
            }
            if (cells[rowEnd][colEnd].getRightSide()) {
                System.out.println("Invalid: There is already a Right fence on the ending cell.");
                return false;
            }
        }

        // Check Up fence placement
        else if (side == up) {
            if (rowStart != rowEnd) {
                System.out.println("Invalid: Up fence must be in same row.");
                return false;
            }
            if (Math.abs(colStart - colEnd) != 1) {
                System.out.println("Invalid: Up fence must span exactly one column.");
                return false;
            }
            if (rowStart == 0) {
                System.out.println("Invalid: Cannot place Up fence on the top edge of the board.");
                return false;
            }
            if (cells[rowStart][colStart].getUpSide()) {
                System.out.println("Invalid: There is already an fence on the top of the starting cell.");
                return false;
            }
            if (cells[rowEnd][colEnd].getUpSide()) {
                System.out.println("Invalid: There is already an fence on the top of the ending cell.");
                return false;
            }
        }

        // Check Down fence placement
        else if (side == down) {
            if (rowStart != rowEnd) {
                System.out.println("Invalid: Down fence must be in same row.");
                return false;
            }
            if (Math.abs(colStart - colEnd) != 1) {
                System.out.println("Invalid: Down fence must span exactly one column.");
                return false;
            }
            if (rowEnd == boardSize - 1) {
                System.out.println("Invalid: Cannot place Down fence on the bottom edge of the board.");
                return false;
            }
            if (cells[rowStart + 1][colStart].getUpSide()) {
                System.out.println("Invalid: There is already an fence below the starting cell.");
                return false;
            }
            if (cells[rowEnd + 1][colEnd].getUpSide()) {
                System.out.println("Invalid: There is already an fence below the ending cell.");
                return false;
            }
        }

        // Temporarily place the fence on the board
        updateBoardWithFence(currentPlayer, fenceSerialStart, fenceSerialEnd,
                side, true);
        
        // Check if all players have paths to their opposite row/ col
        boolean allPlayersHavePath = true;
        for (QuoPlayer player : players) {
            if (!bfsHasPathToGoal(player)) {
                if (currentPlayer.getName().equals(player.getName())) System.out.println(
                        "Invalid: Fence blocks yours path. Try again!");
                else System.out.println("Invalid: Fence blocks player " + player.getName() + " ( " + player.getPiece().getSymbol() +" ) " + "'s path. Try again!");
                allPlayersHavePath = false;
                break;
            }
        }

        // Undo the temporary fence placement
        updateBoardWithFence(currentPlayer, fenceSerialStart, fenceSerialEnd,
                side, false);

        return allPlayersHavePath;
    }

    // This method uses BFS to check if a player has a path to their goal
    private boolean bfsHasPathToGoal(QuoPlayer player) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> visited = new LinkedList<>();

        // Get the player's current position as (row, col)
        int position = player.getPosition();

        queue.add(position);
        visited.add(position);  // Store visited positions as strings

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Check if the player has reached one of their goal rows
            if (isGoalPosition(player, current)) {
                return true;  // Path found to goal
            }

            // Get all available moves from the current position
            int[] neighbors = getValidMoves(current);

            // Add unvisited neighbors to the queue
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        // No path found to any goal row
        return false;
    }

    // This method checks if the current position is a goal for the player
    private boolean isGoalPosition(QuoPlayer player, int position) {
        int[] currentPosition = convertPositionTo2D(position);
        int row = currentPosition[0];
        int col = currentPosition[1];

        String startingPoint = player.getStartingPoint();  // Retrieve starting point

        if (startingPoint.equals("Up")) {
            // Player starts at the top row, goal is the bottom row
            return row == boardSize - 1;
        } else if (startingPoint.equals("Down")) {
            // Player starts at the bottom row, goal is the top row
            return row == 0;
        } else if (startingPoint.equals("Left")) {
            // Player starts on the leftmost column, goal is the rightmost column
            return col == boardSize - 1;
        } else if (startingPoint.equals("Right")) {
            // Player starts on the rightmost column, goal is the leftmost column
            return col == 0;
        }

        return false;
    }

    // This method checks if a player has won the game
    public boolean checkWin(QuoPlayer player) {
        return isGoalPosition(player, player.getPosition());
    }

    // This method returns an array of valid moves for a player's current position
    public int[] getValidMoves(int currentPosition) {
        Set<int[]> validMoves = new HashSet<>();  // HashSet prevent duplicates
        int[] position = convertPositionTo2D(currentPosition);
        int row = position[0];
        int col = position[1];

        // check if the piece can move up
        if (row >= 1 && cells[row][col].getUpSide() == false) {  // the up side is open
            if (cells[row - 1][col].getPiece() == null) {   // the up cell is empty
                validMoves.add(new int[]{row - 1, col});
            }
            // if the up cell is occupied, check the up, left, right of the up cell
            else if (row >= 1) {   
                // the up side of up cell is open and the up up cell is empty
                if (row > 1 && cells[row - 1][col].getUpSide() == false && cells[row - 2][col].getPiece() == null) { 
                        validMoves.add(new int[]{row - 2, col});
                }
                if (row == 1 || cells[row - 1][col].getUpSide() == true || cells[row - 2][col].getPiece() != null) {
                    if (col >= 1 && cells[row - 1][col - 1].getRightSide() == false) { // the left side is open
                        if (cells[row - 1][col - 1].getPiece() == null) {   // the up left cell is empty
                            validMoves.add(new int[]{row - 1, col - 1});
                        }
                    }
                    if (col <= 7 && cells[row - 1][col].getRightSide() == false) { // the right side is open
                        if (cells[row - 1][col + 1].getPiece() == null) {   // the up right cell is empty
                            validMoves.add(new int[]{row - 1, col + 1});
                        }
                    }
                }
            }
        }

        // check if the piece can move down
        if (row <= 7 && cells[row + 1][col].getUpSide() == false) {  // the down side is open
            if (cells[row + 1][col].getPiece() == null) {   // the down cell is empty
                validMoves.add(new int[]{row + 1, col});
            }
            // if the down cell is occupied, check the down, left, right of the down cell
            else if (row <= 7) {   
                // the down down cell is empty and the down side of down cell is open
                if (row < 7){
                    if (cells[row + 2][col].getUpSide() == false && cells[row + 2][col].getPiece() == null) { 
                        validMoves.add(new int[]{row + 2, col});
                    }
                    else {
                        if (col >= 1 && cells[row + 1][col - 1].getRightSide() == false) { // the left side of down cell is open
                            if (cells[row + 1][col - 1].getPiece() == null) {   // the down left cell is empty
                                validMoves.add(new int[]{row + 1, col - 1});
                            }
                        }
                        if (col <= 7 && cells[row + 1][col].getRightSide() == false) { // the right side of down cell is open
                            if (cells[row + 1][col + 1].getPiece() == null) {   // the down right cell is empty
                                validMoves.add(new int[]{row + 1, col + 1});
                            }
                        }
                    }
                }
                if (row == 7){
                    if (col >= 1 && cells[row + 1][col - 1].getRightSide() == false) { // the left side of down cell is open
                        if (cells[row + 1][col - 1].getPiece() == null) {   // the down left cell is empty
                            validMoves.add(new int[]{row + 1, col - 1});
                        }
                    }
                    if (col <= 7 && cells[row + 1][col].getRightSide() == false) { // the right side of down cell is open
                        if (cells[row + 1][col + 1].getPiece() == null) {   // the down right cell is empty
                            validMoves.add(new int[]{row + 1, col + 1});
                        }
                    }
                }

            }
        }

        // check if the piece can move left
        if (col >= 1 && cells[row][col - 1].getRightSide() == false) {  // the left side is open
            if (cells[row][col - 1].getPiece() == null) {   // the left cell is empty
                validMoves.add(new int[]{row, col - 1});
            }
            // if the left cell is occupied, check the left, up, down of the left cell
            else if (col >= 1) {   
                if (col > 1){
                    // the left left cell is empty and the left side of left cell is open
                    if (cells[row][col - 2].getRightSide() == false && cells[row][col - 2].getPiece() == null) { 
                        validMoves.add(new int[]{row, col - 2});
                    }
                    else{
                        if (row >= 1 && cells[row][col - 1].getUpSide() == false) { // the up side of left cell is open
                            if (cells[row - 1][col - 1].getPiece() == null) {   // the left up cell is empty
                                validMoves.add(new int[]{row - 1, col - 1});
                            }
                        }
                        if (row <= 7 && cells[row + 1][col - 1].getUpSide() == false) { // the down side of left cell is open
                            if (cells[row + 1][col - 1].getPiece() == null) {   // the left down cell is empty
                                validMoves.add(new int[]{row + 1, col - 1});
                            }
                        }
                    }
                }
                if (col == 1){
                    if (row >= 1 && cells[row][col - 1].getUpSide() == false) { // the up side of left cell is open
                        if (cells[row - 1][col - 1].getPiece() == null) {   // the left up cell is empty
                            validMoves.add(new int[]{row - 1, col - 1});
                        }
                    }
                    if (row <= 7 && cells[row + 1][col - 1].getUpSide() == false) { // the down side of left cell is open
                        if (cells[row + 1][col - 1].getPiece() == null) {   // the left down cell is empty
                            validMoves.add(new int[]{row + 1, col - 1});
                        }
                    }
                }

            }
        }

        // check if the piece can move right
        if (col <= 7 && cells[row][col].getRightSide() == false) {  // the right side is open
            if (cells[row][col + 1].getPiece() == null) {   // the right cell is empty
                validMoves.add(new int[]{row, col + 1});
            }
            // if the right cell is occupied, check the right, up, down of the right cell
            else if (col <= 7) {   
                // the right right cell is empty and the right side of right cell is open
                if (col < 7 && cells[row][col + 1].getRightSide() == false && cells[row][col + 2].getPiece() == null) { 
                        validMoves.add(new int[]{row, col + 2});
                }
                if (col == 7 || cells[row][col + 1].getRightSide() == true || cells[row][col + 2].getPiece() != null) {
                    if (row >= 1 && cells[row][col + 1].getUpSide() == false) { // the up side of right cell is open
                        if (cells[row - 1][col + 1].getPiece() == null) {   // the right up cell is empty
                            validMoves.add(new int[]{row - 1, col + 1});
                        }
                    }
                    if (row <= 7 && cells[row + 1][col + 1].getUpSide() == false) { // the down side of right cell is open
                        if (cells[row + 1][col + 1].getPiece() == null) {   // the right down cell is empty
                            validMoves.add(new int[]{row + 1, col + 1});
                        }
                    }
                }

            }
        }
        
        if (validMoves.isEmpty()) {
            return new int[0];  
        }

        int[] result = new int[validMoves.size()];
        int index = 0;

        // convert to 1D array
        for (int[] move : validMoves) {
            result[index++] = convertPositionTo1D(move[0], move[1]);
        }

        return result;
    }
    // This method displays the board with players' pieces and fences
    public void displayBoard(QuoPlayer[] players, int[] expectingMove) {
        int cellNumber = 1;
        int cellWidth = 5;
        String content;
        int contentLength = 0;
        
        for (int i = 0; i < boardSize; i++) {
            // Print top border of the row
            System.out.print("+");
            for (int j = 0; j < boardSize; j++) {
                String topFence = (i > 0 && cells[i][j].getUpSide()) ?
                        cells[i][j].getUpFenceColor() : "";  // upper fence exists
                System.out.print(repeatString(topFence + "-----" + "\033[0m", 1) + "+");
                //System.out.print(repeatString("-----", 1) + "+");
            }
            System.out.println();

            // Print row content (either numbers or pieces)
            System.out.print("|");
            for (int j = 0; j < boardSize; j++) {
                Piece piece = cells[i][j].getPiece();

                // If the cell is empty, display the cell number; otherwise, display the piece
                if (cells[i][j].checkEmpty()) {
                    content = String.valueOf(cellNumber);
                    contentLength = content.length();
                    boolean isExpectingMove = false;
                    for (int move : expectingMove) {
                        if (move == cellNumber) {
                            isExpectingMove = true;
                            break;
                        }
                    }
                    if (isExpectingMove) content = "\033[35m" + content + "\033[0m";  // Purple highlight for expecting move
                    else content = "\033[37m" + content + "\033[0m";  // Grey for normal cells
                } else {
                    content = piece.toString();  // Display the piece symbol
                    contentLength = 1;
                }  

                // Center the content in the cell
                int padding = (cellWidth - contentLength) / 2;
                String rightFenceColor = cells[i][j].getRightSide() ?
                        String.format("%-3s",
                                cells[i][j].getRightFenceColor() + "|" + "\033[0m")
                : "|";  // Blue for right-side fence
                //System.out.print(rightFenceColor);  // Print the vertical fence between cells
                System.out.print(repeatString(" ", padding) + formatPiece(content, players) + repeatString(" ", cellWidth - padding - contentLength) + rightFenceColor);
                cellNumber++;
            }
            System.out.println();
        }
        // Print bottom border
        System.out.print("+");
        for (int j = 0; j < boardSize; j++) {
            System.out.print(repeatString("-----", 1) + "+");
        }
    }

    // This method formats the content to include the player's color
    public static String formatPiece(String content, QuoPlayer[] players) {
        for (QuoPlayer playerE : players ) {
            if (content.equals(String.valueOf(playerE.getPiece().getSymbol()))) {
                return String.format("%-3s", playerE.getFenceColor() + content + "\033[0m");  // Ensure 3-character width for each cell
            }
        }
        return content;
    }

    // Helper method to repeat a string multiple times
    public static String repeatString(String str, int times) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < times; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }

}