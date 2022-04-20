package com.example.tetris_new.model;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public  interface  Figure {

    List<Rectangle> getFields();
    default boolean checkPlace(double X, double Y, int[][] MESH) {
        return X < MESH.length && Y < MESH[0].length &&
                X >= 0 && Y >= 0 &&
                MESH[(int)X][(int)Y] == 0;
    }
    default void turn(List<Rectangle> figure, double CentreX, double CentreY, int [][] MESH, int SIZE){
        List<Rectangle> figure1 = new ArrayList<>(figure);
        for(Rectangle a: figure1){
            double X = -a.getY() + CentreY + CentreX;
            double Y = a.getX() - CentreX + CentreY;
            if(!checkPlace(X/SIZE, Y/SIZE, MESH)){
                return;
            }
            a.setY(Y);
            a.setX(X);
        }
        for (int i = 0; i< figure1.size();i++){
            figure.set(i, figure1.get(i));
        }
    }
    void moveTurn(int[][] MESH, int SIZE);
}
