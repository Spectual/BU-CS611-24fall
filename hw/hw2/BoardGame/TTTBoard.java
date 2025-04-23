/**
 * TTTBoard.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 10/4/2024
 * 
 * This class represents a TicTacToe board. It contains the size of the board and
 * a 2D array of cells that represent the board. It extends the Board class and
 * also contains methods to check if the current move leads to a win or stalemate.
 */

public class TTTBoard extends Board {
    private int boardSize;
    private Cell[][] cells;

    public TTTBoard() {}

    public TTTBoard(int boardSize) {
        this.boardSize = boardSize;   // initialize size of the board

        // initialize a 2D array of cells to represent the board
        cells  = new Cell[boardSize][boardSize];  
        for (int r = 0; r < boardSize; r++) {
            for(int c = 0; c < boardSize; c++) {
                cells[r][c] = new Cell();
            }
        }
    }

    @Override
    public Cell[][] getCells() {
        return cells;
    }

    // This method prints the board to the console.
    // It prints the row and column numbers, cell values, and split lines.
    // For example:
    //   1   2   3
    // 1 X | O | X
    //   -----------
    // 2 O | X | O
    //   -----------
    // 3 X | O | X

    @Override
    public void displayBoard() {
        
        System.out.println("");

        // print column number (1, 2, 3, ...)
        System.out.print("  ");
        for (int c = 0; c < boardSize; c ++) {
            System.out.print(" " + (c + 1) + " ");
            if (c != boardSize - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        

        for (int r = 0; r < boardSize; r++) {

            System.out.print((r + 1) + " ");  // print row number (1, 2, 3, ...)
     
            // print cell value and vertical split line between cells
            for (int c = 0; c < boardSize; c++) {
                System.out.print(" ");
                System.out.print(cells[r][c]);  
                if (c != boardSize - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            
            // print horizontal split line between rows
            if (r != boardSize - 1) {
                System.out.print("  ");  
                for (int i = 0; i < boardSize; i++) {
                    System.out.print("---");
                    if (i != boardSize - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    // This method returns true if the current move results in pieces
    // in a line to win, false otherwise.
    public boolean checkWin(int row, int col, int lineLengthToWin) {
        Piece piece = cells[row][col].getPiece();
    
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

    // This method checks if the board is full.
    // It returns true if the board is full, false otherwise.
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

    // This method removes all pieces in the board.
    @Override
    public void clearBoard() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                cells[r][c].removePiece();
            }
        }
    }

    // This method replaces all pieces in the board with
    // a specified piece.
    public void fullFillBoard(Piece piece) {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                updateBoard(r, c, piece);
            }
        }
    }

    
}