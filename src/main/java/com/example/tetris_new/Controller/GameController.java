package com.example.tetris_new.Controller;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public static final int SIZE =25;
    public static final int XMAX = SIZE*12;
    public static final int YMAX = SIZE*20;
    private static int timer = 0;
    private static ViewController viewController;

    private static final int [][] MESH = new int[XMAX/SIZE][YMAX/SIZE];
    private static final FigureController figureController = new FigureController(SIZE,XMAX,YMAX);
    private static boolean game = true;
    private static int score = 1;
    private long speed = 400_000_000;
    private final long minSpeed = 300_000_000;
    private final long increaseSpeed = 20_000_000;



    public void moveFigureDown() {
        if(!FigureController.moveDown(MESH)){
            for(Rectangle a: FigureController.getFigure().getFields()){
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
            }
            RemoveRows();
            figureController.makeRect();
            if(score%2==0 && speed > minSpeed){
                speed -=increaseSpeed;
            }

            if(!FigureController.checkSpawn(MESH)){
                game = false;
            }else {
                score++;
                viewController.printFigure();
            }
        }
        viewController.moveOnKeyPress(MESH, figureController);
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
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            stage.close();
                        }
                    }

                    System.out.println(speed);
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