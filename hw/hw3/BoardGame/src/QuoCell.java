/**
 * QuoCell.java
 * by Yuanhang Xu (xxxqivzz@bu.edu), Yifei Bao (baoyifei@bu.edu)
 * 10/19/2024
 * 
 * This class represents a cell in the Quoridor board. 
 * It extends the Cell class and contains additional information of a cell in the Quoridor board.
 * It contains the piece on the cell,
 * the up and right sides of the cell. It contains methods to check if the cell is empty,
 * place a piece on the cell, remove a piece from the cell, and getters and setters.
 * 
 * In this design, a QuoCell has upSide and rightSide attributes to represent the fences on the cell.
 * It also has upFenceColor and rightFenceColor attributes to represent the color of the fences.
 */

public class QuoCell extends Cell {
    private boolean upSide = false;
    private boolean rightSide = false;
    private String upFenceColor = " ";
    private String rightFenceColor = " ";

    public boolean checkEmpty() {
        return piece == null;
    }

    public void placePiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }
    public Piece getPiece() { return piece; }

    public boolean getRightSide() {
         return rightSide;
     }

    public void setRightSide(boolean rightSide) {
         this.rightSide = rightSide;
     }

    public boolean getUpSide() {
        return upSide;
    }

    public void setUpSide(boolean upSide) {
        this.upSide = upSide;
    }
    public String getUpFenceColor() {
         return upFenceColor;
    }

    public String getRightFenceColor() {
        return rightFenceColor;
    }

    public void setUpFenceColor(String fenceColor) {
        upFenceColor = fenceColor;
    }
    
    public void setRightFenceColor(String fenceColor) {
         rightFenceColor = fenceColor;
    }
}
