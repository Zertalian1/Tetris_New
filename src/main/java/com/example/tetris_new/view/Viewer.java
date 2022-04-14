package com.example.tetris_new.view;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public interface Viewer {
    public void printField(Rectangle fields);
    public void printScoreText(int score);
    public void showMsg(String text);
    public void start(Stage stage, int XMAX, int YMAX);
    public Scene getScene();
    public void RemoveRows(List<Integer> lines, int [][] MESH, int SIZE);
}
