package com.hvchess.chess.pieces;

import com.hvchess.chess.helper.Helper;

public class Bishop extends Piece {


    public Bishop(String color) {
        super(color, color.equals("white") ? "/images/white/bishop.png" : "/images/black/bishop.png");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {

        if (board[endX][endY] != null && board[endX][endY].getColor().equals(this.getColor())) {
            return false;
        }

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        if (dx == dy) {
            return Helper.isPathClear(startX, startY, endX, endY, board);
        }
        return false;
    }
}
