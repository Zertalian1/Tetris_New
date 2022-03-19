package com.example.tetris_new.Controller;

import com.example.tetris_new.model.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

public class C {
    public static final int SIZE =25;
    public static final int XMAX = SIZE*12;
    public static final int YMAX = SIZE*15;

    private static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX+150,YMAX);

    private static final int [][] MESH = new int[XMAX/SIZE][YMAX/SIZE];
    private static FigureController object = new FigureController(SIZE,XMAX,YMAX);
    private static boolean game = true;
    private static int score = 1;



    public void moveFigureDown(/*int[][] MESH*/) {
        if(!object.moveDown(MESH)){
            for(Rectangle a:object.getFigure().getFigure()){
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
            }


        RemoveRows();                                                                         // удаление заполненной строки

       // object = nextObj;
       // nextObj = C.makeRect();
            object.makeRect();

            if(!object.checkSpawn(MESH)){
                game = false;
            }else {
                score++;
                for(Rectangle a:object.getFigure().getFigure()) {
                    group.getChildren().add(a);
                }
            }
            moveOnKeyPress();
        }
    }

    private  void RemoveRows() {
        List<Node> rects = new ArrayList<>();
        List<Integer> lines = new ArrayList<>();
        List<Node> newrects = new ArrayList<>();
        int full = 0;
        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1)
                    full++;
            }
            if (full == MESH.length)
                lines.add(i);
            full = 0;
        }

        if (lines.size() > 0)
            do {
                for (Node node : group.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        group.getChildren().remove(node);
                    } else
                        newrects.add(node);
                }

                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();
                for (Node node : group.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();
            } while (lines.size() > 0);
    }


    public void startGame(Stage stage){
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Line line = new Line(XMAX,0,XMAX,YMAX);
        group.getChildren().addAll(scoretext,line);
        for(Rectangle a:object.getFigure().getFigure()) {
            group.getChildren().add(a);
        }
        stage.setScene(scene);
        stage.setTitle("Tetris");
        stage.show();
        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        scoretext.setText("Score: " + Integer.toString(score));
                        if(game){
                            moveFigureDown();
                            //System.out.println("99999");
                        }else{
                            Text over = new Text("GAME OVER");
                            over.setFill(Color.RED);
                            //setStyle
                            over.setX(10);
                            over.setY(250);
                            group.getChildren().add(over);
                            System.exit(0);
                            //timer++;
                        }
                        /*if(timer ==2){
                            List<Integer> scores = null;
                            try {
                                scores = readFile();
                                scores.add(score);
                                Collections.sort(scores, Collections.reverseOrder());
                                writeFile(scores);
                                Thread.sleep(6000);
                            } catch (InterruptedException | IOException e) {
                                e.printStackTrace();
                            }
                            finally {
                                System.exit(0);
                            }
                        }*/

                    }
                });
            }
        };

        fall.schedule(task,0,300);
    }

    public  void moveOnKeyPress(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case RIGHT:
                        object.moveRight(MESH);
                        break;
                    case LEFT:
                        object.moveLeft(MESH);
                        break;
                    case DOWN:
                        object.moveDown(MESH);
                        break;
                    case UP:
                        object.moveTurn(MESH);
                        break;
                }
            }
        });
    }
}
// должен создаваться объект класса FigureController, будут вызываться функции из него, объект хранит нынешнюю фигуру
// разделить С на вид + мир