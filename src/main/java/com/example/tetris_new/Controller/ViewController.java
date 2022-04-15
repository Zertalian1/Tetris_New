package com.example.tetris_new.Controller;

import com.example.tetris_new.view.JavaFxView;
import com.example.tetris_new.view.Viewer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.List;

public class ViewController {
    private final Viewer view;

    public ViewController(Stage stage, int XMAX, int YMAX) {
        view = new JavaFxView();
        view.start(stage, XMAX, YMAX);
    }

    public void printFigure(FigureController figureController) {
        for(Rectangle a: FigureController.getFigure().getFields()) {
            view.printField(a);
        }
    }

    public void printText(String text) {
        view.showMsg(text);
    }

    public void printText(int num) {
        view.printScoreText(num);
    }

    public  void moveOnKeyPress(int [][] MESH, FigureController figureController){
        view.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> FigureController.moveRight(MESH);
                case LEFT -> FigureController.moveLeft(MESH);
                case DOWN -> FigureController.moveDown(MESH);
                case UP -> figureController.moveTurn(MESH);
                default -> System.out.println("Hi");
            }
        });
    }

    public void RemoveRows(List<Integer> lines, int [][] MESH, int SIZE){
        view.RemoveRows(lines, MESH, SIZE);
    }
}
