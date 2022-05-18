package com.example.tetris_new.Controller;

import com.example.tetris_new.Tetris;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    public static final int SIZE = Tetris.SIZE;
    public static final int XMAX = Tetris.XMAX;
    public static final int YMAX = Tetris.YMAX;
    private static int timer = 0;
    private static ViewController viewController;
    private static final DBController dbController= new DBController();

    private static final int [][] MESH = new int[XMAX/SIZE][YMAX/SIZE];
    private static final FigureController figureController = new FigureController(SIZE,XMAX,YMAX);
    private static boolean game = true;
    private static int score = 1;
    private long speed = Tetris.speed;
    private final long minSpeed = Tetris.minSpeed;


    public void moveFigureDown() {
        if(!FigureController.moveDown(MESH)){
            for(Rectangle a: FigureController.getFigure().getFields()){
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
            }
            RemoveRows();
            figureController.makeRect();
            if(score%2==0 && speed > minSpeed){
                speed -= 20_000_000;
            }

            if(!FigureController.checkSpawn(MESH)){
                game = false;
            }else {
                score++;
                viewController.printFigure();
            }
        }
        moveOnKeyPress();
    }

    private  void RemoveRows()  {
        List<Integer> lines = new ArrayList<>();
        int full = 0;
        for (int i = 0; i < MESH[0].length; i++) {
            for (int[] mesh : MESH) {
                if (mesh[i] == 1)
                    full++;
            }
            if (full == XMAX/SIZE)
                lines.add(i);
            full = 0;
        }
        removeLine(lines);
        viewController.RemoveRows(lines, SIZE);
    }

    private void removeLine(List<Integer> lines) {
        int i=0;
        while (lines.size()>i){
            for(int y = lines.get(i);y>=0;y--){
                for(int x = 0;x<XMAX/SIZE;x++){
                    GameController.MESH[x][y] = (y == 0)? 0 : GameController.MESH[x][y-1];
                }
            }
            i++;
        }
    }

    public  void moveOnKeyPress(){
        viewController.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> FigureController.moveRight(MESH);
                case LEFT -> FigureController.moveLeft(MESH);
                case DOWN -> FigureController.moveDown(MESH);
                case UP -> figureController.moveTurn(MESH);
                default -> System.out.println("Hi");
            }
        });
    }



    public void startGame(Stage stage){
        viewController = new ViewController(stage, XMAX, YMAX);
        viewController.printFigure();
        AnimationTimer at = new AnimationTimer(){
            private long lastUpdate = 0 ;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= speed) {
                    if (game) {
                        moveFigureDown();

                    } else {
                        viewController.printText("GAME OVER");
                        timer++;
                    }
                    if (timer == 2) {
                        try {
                            stage.close();
                            System.out.println("Введите ваш ник:");
                            Scanner scanner = new Scanner(System.in);
                            dbController.addDataToDB(scanner.nextLine(),score);
                        } catch (SQLException e) {
                            System.err.println(e);
                            System.out.println("something went wrong");
                        }
                    }
                    lastUpdate = now ;
                }
                viewController.printText(score);
            }
        };
        at.start();
        if(timer == 2){
            at.stop();
        }
    }
}