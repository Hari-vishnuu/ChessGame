package com.hvchess.chess.pieces;

public class Knight extends Piece {

    public Knight(String color) {
        super(color, color.equals("white") ? "/images/white/knight.png" : "/images/black/knight.png");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {

        if (board[endX][endY] != null && board[endX][endY].getColor().equals(this.getColor())) {
            return false;
        }
        return false;
    }
}
