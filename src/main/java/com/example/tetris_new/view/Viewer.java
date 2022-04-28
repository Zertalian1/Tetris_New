package com.example.tetris_new.view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.List;

public interface Viewer {
    void printField(Rectangle fields);
    void printScoreText(int score);
    void showMsg(String text);
    void start(Pane gr, Scene sc, Stage stage, int XMAX, int YMAX);
    void RemoveRows(List<Integer> lines, int SIZE);
}
