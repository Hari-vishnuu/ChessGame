package com.hvchess.chess;

import com.hvchess.chess.constants.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessGame extends Application {

    private final ChessBoard chessBoard = new ChessBoard();
    private final GridPane grid = new GridPane();

    private int selectedX = -1;
    private int selectedY = -1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1000);
        stage.setMinHeight(600);
        stage.setMinWidth(800);

        drawBoard();
        chessBoard.drawBoard(grid);

        grid.setOnMouseClicked(this::handleMouseClick);

        Scene scene = new Scene(grid, Constants.WIDTH * Constants.TILE_SIZE, Constants.HEIGHT * Constants.TILE_SIZE);
        stage.setScene(scene);
        stage.setTitle("Chess Game");
        stage.show();

    }

    private void addLabel(GridPane grid) {
        for (int col = 0; col < 8; col++) {
            Label label = new Label(String.valueOf((char) ('A' + col)));
            label.setStyle("-fx-font-size: 12px;");
            label.setTranslateX(70);
            label.setTranslateY(-30);
            grid.add(label, col, 0);

        }

        for (int row = 0; row < 8; row++) {
            Label label = new Label(String.valueOf(8 - row));
            label.setStyle("-fx-font-size: 12px;");
            label.setTranslateY(-30);
            grid.add(label, 0, row);

        }
    }

    private void handleMouseClick(MouseEvent event) {
        int col = (int) (event.getX() / Constants.TILE_SIZE);
        int row = (int) (event.getY() / Constants.TILE_SIZE);

        if (selectedX == -1) {
            if (chessBoard.getPiece(row, col) != null) {
                selectedX = row;
                selectedY = col;
            }
        } else {
            chessBoard.movePiece(selectedX, selectedY, row, col);
            selectedX = -1;
            selectedY = -1;
            // Re-draw board with updated piece positions
            drawBoard();
            chessBoard.drawBoard(grid);
        }
    }


    private void drawBoard() {

        for (int row = 0; row < Constants.HEIGHT; row++) {
            for (int col = 0; col < Constants.WIDTH; col++) {
                Rectangle tile = new Rectangle(Constants.TILE_SIZE, Constants.TILE_SIZE);
                tile.setFill((row + col) % 2 == 0 ? Color.WHITE : Color.BURLYWOOD);
                grid.add(tile, col, row);

            }
        }
        addLabel(grid);
    }


}
