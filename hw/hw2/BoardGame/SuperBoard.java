/**
 * SuperBoard.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 10/4/2024
 * 
 * This class represents a Super TicTacToe board. It contains the size of the
 * board and a 2D array of super cells that represent the board. It extends
 * the Board class and also contains methods to check if the current move
 * leads to a win or stalemate.
 */

public class SuperBoard extends Board {
    private int boardSize;

    private SuperCell[][] cells;

    public SuperBoard(int boardSize) {
        this.boardSize = boardSize;
        cells = new SuperCell[boardSize][boardSize];
        for (int r = 0; r < boardSize; r++) {
            for(int c = 0; c < boardSize; c++) {
                cells[r][c] = new SuperCell();
            }
        }
    }

    public SuperCell[][] getCells() {
        return cells;
    }

    // This method returns true if the current move results in pieces
    // in a line to win, false otherwise.
    public boolean checkWin(int row, int col, int lineLengthToWin) {
        Piece piece = cells[row][col].getPiece();

        if (piece == null || piece.getSymbol() == 'S') {
            return false;
        }

        // check if pieces in a row line to win
        for (int c = 0; c <= boardSize - lineLengthToWin; c++) {
            for (int i = 0; i < lineLengthToWin; i++) {
                if (!piece.equals(cells[row][c + i].getPiece())) {  
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
                if (!piece.equals(cells[r + i][col].getPiece())) {  
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
                    if (!piece.equals(cells[startRow + i + j][startCol + i + j].getPiece())) {  
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
                    if (!piece.equals(cells[startRow + i + j][startCol - i - j].getPiece())) {  
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
    
    public boolean checkStalemate() {
        return checkFull();
    }

    @Override
    public boolean checkFull() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (cells[r][c].checkEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean updateBoard(int superRow, int superCol, int row, int col, Piece piece) {
        if (cells[superRow][superCol].checkEmpty()) {
            return cells[superRow][superCol].placePiece(row, col, piece);
        }
        else {
            return false;
        }
    }

    // This method prints the super board to the console.
    // For example:
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   |   |   | | O |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   | O |   | |   |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   | O | X | |   |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   |   |   | | O |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   |   |   | |   | X |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   |   |   | | X |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   |   |   | |   |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   |   |   | |   |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    // |   |   |   | |   |   |   | |   |   |   | 
    // +---+---+---+ +---+---+---+ +---+---+---+ 
    @Override
    public void displayBoard() {
    
        for (int superRow = 0; superRow < boardSize; superRow++) {
            for (int subRow = 0; subRow < boardSize; subRow++) {
                for (int superCol = 0; superCol < boardSize; superCol++) {
                    System.out.print("+---+---+---+ ");
                }
                System.out.println();

                for (int superCol = 0; superCol < boardSize; superCol++) {
                    SuperCell superCell = cells[superRow][superCol];
                    // print the row of the sub board
                    for (int subCol = 0; subCol < boardSize; subCol++) {
                        Piece piece = superCell.getBoard().getCells()[subRow][subCol].getPiece();
                        String displayPiece = (piece == null) ? " " : piece.toString();
                        System.out.print("| " + displayPiece + " ");
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
    
            // print split between super rows
            for (int superCol = 0; superCol < boardSize; superCol++) {
                System.out.print("+---+---+---+ ");
            }
            System.out.println();
        }
    }

    // This method checks if the move is valid.
    // It returns true if the move is within the board, false otherwise.
    @Override
    public boolean isValidMove(int row, int col) {
        return (row >= 0) && (row < boardSize) && (col >= 0) && (col < boardSize);
    }

    // This method changes the value of a cell in the board.
    // It takes the row, column, and symbol as input.
    @Override
    public boolean updateBoard(int row, int col, Piece piece) {
        if (cells[row][col].checkEmpty()) {
            cells[row][col].placePiece(piece);
            return true;
        }
        return false;
    }

    @Override
    // This method removes all pieces in the board.
    public void clearBoard() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                cells[r][c].removePiece();
            }
        }
    }
}
