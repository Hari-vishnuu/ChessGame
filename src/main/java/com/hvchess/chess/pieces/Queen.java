package com.hvchess.chess.pieces;

import com.hvchess.chess.helper.Helper;

public class Queen extends Piece {

    public Queen(String color) {
        super(color, color.equals("white") ? "/images/white/queen.png" : "/images/black/queen.png");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        if (board[endX][endY] != null && board[endX][endY].getColor().equals(this.getColor())) {
            return false;
        }

        if (startX == endX || startY == endY) {
            return Helper.isPathClear(startX, startY, endX, endY, board);
        }

        if (dx == dy) {
            return Helper.isPathClear(startX, startY, endX, endY, board);
        }

        return false;
    }


}
