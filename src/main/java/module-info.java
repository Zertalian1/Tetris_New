module com.example.tetris_new {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.tetris_new.Controller to javafx.fxml;
    opens com.example.tetris_new to javafx.fxml;
    exports com.example.tetris_new;
}