module com.hvchess.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hvchess.chess to javafx.fxml;
    exports com.hvchess.chess;
    exports com.hvchess.chess.constants;
    opens com.hvchess.chess.constants to javafx.fxml;
    exports com.hvchess.chess.pieces;
    opens com.hvchess.chess.pieces to javafx.fxml;
}