package com.example.tetris_new.view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.List;

public interface Viewer {
    void printField(Rectangle fields);
    void printScoreText(int score);
    void showMsg(String text);
    void start(Stage stage, int XMAX, int YMAX);
    Scene getScene();
    List<Node> RemoveRows(List<Integer> lines, int [][] MESH, int SIZE);
}
