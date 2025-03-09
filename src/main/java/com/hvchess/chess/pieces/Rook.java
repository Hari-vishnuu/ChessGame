package com.hvchess.chess.pieces;

import com.hvchess.chess.helper.Helper;

public class Rook extends Piece {


    public Rook(String color) {
        super(color, color.equals("white") ? "/images/white/rook.png" : "/images/black/rook.png");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {

        if (board[endX][endY] != null && board[endX][endY].getColor().equals(this.getColor())) {
            return false; // Cannot capture your own piece
        }

        if (startX == endX || startY == endY) {
            return Helper.isPathClear(startX, startY, endX, endY, board);
        }
        return false;
    }
}
