/**
 * SuperCell.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 10/4/2024
 * 
 * This class represents a Super Cell. It extends the Cell class and
 * also contains a TTTBoard object that represents the board inside the 
 * super cell. It contains methods to place a piece on the board, check
 * if the piece wins the game or causes a stalemate, and update the piece.
 */

public class SuperCell extends Cell {
    private TTTBoard board;

    public SuperCell() {
        this.piece = null;
        board = new TTTBoard(3);
    }

    public TTTBoard getBoard() {
        return board;
    }

    // This method places a piece on the board inside the cell
    // at the specified row and column. It also checks if the
    // piece wins the game or causes a stalemate. If so, it
    // updates the piece value accordingly.
    public boolean placePiece(int row, int col, Piece piece) {
        boolean isUpdated = board.updateBoard(row, col, piece);
        if (!isUpdated){
            return isUpdated;
        }
        if (board.checkWin(row, col, 3)) {
            this.piece = piece;
            board.clearBoard();
            board.fullFillBoard(this.piece);
            return isUpdated;
        }
        if (board.checkStalemate()) {
            this.piece = new Piece('S');
            board.clearBoard();
            board.fullFillBoard(this.piece);
        }
        return isUpdated;
    }

    @Override
    public void removePiece(){
        this.piece = null;
        board.clearBoard();
    }

}
