package com.hvchess.chess.pieces;

public class King extends Piece{

    public King(String color) {
        super(color, color.equals("white") ? "/images/white/king.png" : "/images/black/king.png");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        if (board[endX][endY] != null && board[endX][endY].getColor().equals(this.getColor())) {
            return false;
        }
        return false;
    }
}
