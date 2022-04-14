package com.example.tetris_new.model;
import javafx.scene.shape.Rectangle;
import java.util.List;

public  interface  Figure {

    public List<Rectangle> getFields();
    default boolean checkPlace(Rectangle a, int X, int Y, int[][] MESH, int SIZE) {
        return a.getX() / SIZE + X < MESH.length && a.getY() / SIZE + Y < MESH[0].length &&
                a.getX() / SIZE + X >= 0 && a.getY() / SIZE + Y >= 0 &&
                MESH[(int) (a.getX() / SIZE + X)][(int) (a.getY() / SIZE + Y)] == 0;
    }
    public abstract void moveTurn(int [][] MESH, int SIZE); // фигура не знает, что её будут помещать на поле или переименовать в м
}
