package com.example.tetris_new;

import com.example.tetris_new.Controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GameController game = new GameController();
        game.startGame(stage);

    }
    // добавить повороты, меню, подправить надпись "GAME OVER"
}
