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
        /*List<Node> rects = new ArrayList<>();
        List<Node> newrects = new ArrayList<>();
        if (lines.size() > 0)
            do {
                // получаем все фигуры из group
                for (Node node : view.getField()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                // удаляем заполненные строки, не заполненные записываем в newrects
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        view.getField().remove(node);
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
                for (Node node : view.getField()) {
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
            } while (lines.size() > 0);*/
    }
}
