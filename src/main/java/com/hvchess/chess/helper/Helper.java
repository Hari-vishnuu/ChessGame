package com.hvchess.chess.helper;

import com.hvchess.chess.pieces.Piece;

public class Helper {

    public static boolean isPathClear(int startX, int startY, int endX, int endY, Piece[][] board) {
        int stepX = Integer.compare(endX, startX); // 1, -1, or 0
        int stepY = Integer.compare(endY, startY); // 1, -1, or 0

        int x = startX + stepX;
        int y = startY + stepY;

        while (x != endX || y != endY) {
            if (board[x][y] != null) {
                return false; // Path blocked
            }
            x += stepX;
            y += stepY;
        }
        return true;
    }

}
