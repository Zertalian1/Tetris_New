package com.example.tetris_new;
import com.example.tetris_new.Controller.DBController;
import com.example.tetris_new.Controller.GameController;
import com.example.tetris_new.Controller.MainMenuController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Tetris extends Application {

    private static final MainMenuController mainMenuC = new MainMenuController();
    public static final int SIZE =25;
    public static final int XMAX = SIZE*12;
    public static final int YMAX = SIZE*20;
    public static long speed = 400_000_000;
    public static long minSpeed = 300_000_000;

    public static void startGame() {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        int chose;
        do {
            chose = action();
            switch (chose) {
                case 1 -> {
                    try {
                        DBController show = new DBController();
                        show.getDataFromDB();
                    } catch (SQLException e) {
                        System.out.println("Can't get data from DB");
                    }
                }
                case 2 -> {
                    GameController game = new GameController();
                    game.startGame(stage);
                }
                case 3 -> {
                    Platform.exit();
                }
            }
        }while (chose!=3 && chose!=2);

    }

    private int action(){
        System.out.println("select an action");
        System.out.println("1) Вывести топ 10 пользователей") ;
        System.out.println("2) запустить игру");
        System.out.println("3) Выйти");

        Scanner action = new Scanner(System.in);
        return action.nextInt();
    }
}
