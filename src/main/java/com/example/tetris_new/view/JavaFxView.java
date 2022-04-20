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
    public List<Node> RemoveRows(List<Integer> lines, int [][] MESH, int SIZE){
        List<Node> rows = new ArrayList<>();
        List<Node> new_rows = new ArrayList<>();
        if (lines.size() > 0) {
            do {
                // получаем все фигуры из group
                for (Node node : group.getChildren()) {
                    if (node instanceof Rectangle)
                        rows.add(node);
                }
                // удаляем заполненные строки, не заполненные записываем в new_rows
                for (Node node : rows) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        group.getChildren().remove(node);
                    } else
                        new_rows.add(node);
                }
                // опускаем все фигуры вниз
                for (Node node : new_rows) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        a.setY(a.getY() + SIZE);
                    }
                }
                lines.remove(0);
                rows.clear();
                new_rows.clear();
            } while (lines.size() > 0);
        }
        for (Node node : group.getChildren()) {
            if (node instanceof Rectangle)
                rows.add(node);
        }
        return rows;
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
