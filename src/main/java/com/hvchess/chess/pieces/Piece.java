package com.hvchess.chess.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

abstract public class Piece {
    String color;
    ImageView imageView;

    public Piece(String color, String imagePath) {
        this.color = color;
        this.imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath))));
        this.imageView.setFitHeight(80);
        this.imageView.setFitWidth(80);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getColor() {
        return this.color;
    }

    abstract public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board);
}
