package com.example.tetris_new.view;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JavaFxView implements Viewer{
    private int XMAX;
    private int YMAX;
    private static Pane group;
    private static Scene scene;
    Text scoretext = new Text("Score: ");

    @Override
    public void start(Stage stage, int XMAX, int YMAX){
        this.XMAX = XMAX;
        this.YMAX = YMAX;
        group = new Pane();
        scene = new Scene(group, XMAX+150,YMAX);
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Line line = new Line(XMAX,0,XMAX,YMAX);
        group.getChildren().addAll(scoretext,line);
        stage.setScene(scene);
        stage.setTitle("Tetris");
        stage.show();
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void RemoveRows(List<Integer> lines, int [][] MESH, int SIZE){           // переписать здесь должны только стираться Rects из group
        List<Node> rects = new ArrayList<>();
        List<Node> newrects = new ArrayList<>();
        if (lines.size() > 0) {
            do {
                // получаем все фигуры из group
                for (Node node : group.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                // удаляем заполненные строки, не заполненные записываем в newrects
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        group.getChildren().remove(node);
                    } else
                        newrects.add(node);
                }
                // опускаем все фигуры вниз
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
                // помечаем фигуры на новых местах в поле
                for (Node node : group.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
                rects.clear();
            } while (lines.size() > 0);
        }
    }

    @Override
    public void printField(Rectangle fields) {
        group.getChildren().add(fields);
    }

    @Override
    public void printScoreText(int score){
        scoretext.setText("Score: " + score);
    }

    @Override
    public void showMsg(String text){
        Text over = new Text(text);
        over.setFill(Color.RED);
        over.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        over.setX((double) XMAX/text.length());
        over.setY(YMAX>>1);
        group.getChildren().add(over);
    }


}
