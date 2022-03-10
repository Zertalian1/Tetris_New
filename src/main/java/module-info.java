module com.example.tetris_new {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tetris_new to javafx.fxml;
    exports com.example.tetris_new;
}