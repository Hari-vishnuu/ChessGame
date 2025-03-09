package com.hvchess.chess.pieces;

public class Pawn extends Piece {

    public Pawn(String color) {
        super(color, color.equals("white") ? "/images/white/pawn.png" : "/images/black/pawn.png");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {

        if (board[endX][endY] != null && board[endX][endY].getColor().equals(this.getColor())) {
            return false;
        }
        int direction = (this.getColor().equals("white")) ? -1 : 1; // White moves up, Black moves down

        // ✅ Move forward by 1 square (only if empty)
        if (startX + direction == endX && startY == endY && board[endX][endY] == null) {
            return true;
        }

        // ✅ First move → Can move 2 squares forward (only if both squares are empty)
        if (startX + 2 * direction == endX && startY == endY &&
                board[endX][endY] == null && board[startX + direction][startY] == null &&
                (startX == 1 || startX == 6)) {
            return true;
        }

        // ✅ Capture diagonally (if enemy piece exists)
        if (startX + direction == endX && Math.abs(startY - endY) == 1 && board[endX][endY] != null &&
                !board[endX][endY].getColor().equals(this.getColor())) {
            return true;
        }

        return false; // ❌ Invalid move
    }
}
