package com.hvchess.chess;

import com.hvchess.chess.constants.Constants;
import com.hvchess.chess.pieces.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ChessBoard {

    private final Piece[][] board = new Piece[8][8];

    public ChessBoard() {
        board[0][0] = new Rook(Constants.BLACK_COLOR);
        board[0][7] = new Rook(Constants.BLACK_COLOR);
        board[7][0] = new Rook(Constants.WHITE_COLOR);
        board[7][7] = new Rook(Constants.WHITE_COLOR);

        board[0][4] = new Queen(Constants.BLACK_COLOR);
        board[7][3] = new Queen(Constants.WHITE_COLOR);

        board[1][0] = new Pawn(Constants.BLACK_COLOR);
        board[1][1] = new Pawn(Constants.BLACK_COLOR);
        board[1][2] = new Pawn(Constants.BLACK_COLOR);
        board[1][3] = new Pawn(Constants.BLACK_COLOR);
        board[1][4] = new Pawn(Constants.BLACK_COLOR);
        board[1][5] = new Pawn(Constants.BLACK_COLOR);
        board[1][6] = new Pawn(Constants.BLACK_COLOR);
        board[1][7] = new Pawn(Constants.BLACK_COLOR);

        board[6][0] = new Pawn(Constants.WHITE_COLOR);
        board[6][1] = new Pawn(Constants.WHITE_COLOR);
        board[6][2] = new Pawn(Constants.WHITE_COLOR);
        board[6][3] = new Pawn(Constants.WHITE_COLOR);
        board[6][4] = new Pawn(Constants.WHITE_COLOR);
        board[6][5] = new Pawn(Constants.WHITE_COLOR);
        board[6][6] = new Pawn(Constants.WHITE_COLOR);
        board[6][7] = new Pawn(Constants.WHITE_COLOR);

        board[0][1] = new Knight(Constants.BLACK_COLOR);
        board[0][6] = new Knight(Constants.BLACK_COLOR);
        board[7][1] = new Knight(Constants.WHITE_COLOR);
        board[7][6] = new Knight(Constants.WHITE_COLOR);

        board[0][2] = new Bishop(Constants.BLACK_COLOR);
        board[0][5] = new Bishop(Constants.BLACK_COLOR);
        board[7][2] = new Bishop(Constants.WHITE_COLOR);
        board[7][5] = new Bishop(Constants.WHITE_COLOR);

        board[0][3] = new King(Constants.BLACK_COLOR);
        board[7][4] = new King(Constants.WHITE_COLOR);


    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        if (board[startX][startY] != null && board[startX][startY].isValidMove(startX, startY, endX, endY, board)) {
            board[endX][endY] = board[startX][startY];
            board[startX][startY] = null;
        } else {
            System.out.println("invalid move");
        }
    }

    public void drawBoard(GridPane grid) {
        // Remove only piece images before re-drawing
        grid.getChildren().removeIf(node -> node instanceof ImageView);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {
                    grid.add(board[row][col].getImageView(), col, row);

                }
            }
        }

    }


}
