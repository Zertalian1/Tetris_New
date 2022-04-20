package com.example.tetris_new.Controller;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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



    public void moveFigureDown() {
        if(!FigureController.moveDown(MESH)){
            for(Rectangle a: FigureController.getFigure().getFields()){
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
            }
            RemoveRows();
            figureController.makeRect();
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
            if (full == MESH.length)
                lines.add(i);
            full = 0;
        }
        List<Node> rows = viewController.RemoveRows(lines, MESH, SIZE);
        clearM();
        for (Node node : rows) {
            Rectangle a = (Rectangle) node;
            try {
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
    }

    private void clearM() {
        for(int i=0;i< XMAX/SIZE;i++){
            for(int j=0;j< YMAX/SIZE;j++){
                MESH[i][j]=0;
            }
        }
    }


    public void startGame(Stage stage){
        viewController = new ViewController(stage, XMAX, YMAX);
        viewController.printFigure();

        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    viewController.printText(score);
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
                            fall.cancel();
                            stage.close();
                        }
                    }

                });
            }
        };

        fall.schedule(task,0,400);
    }
}