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
        double [][] move = new double[figure.size()][2];
        int i=0;
        for(Rectangle a: figure) {
            move[i][0] = -a.getY() + CentreY + CentreX;
            move[i][1] = a.getX() - CentreX + CentreY;
            if (!checkPlace( move[i][0] / SIZE, move[i][1] / SIZE, MESH)) {
                return;
            }
            i++;
        }
        i=0;
        for(Rectangle a: figure){
            a.setY(move[i][1]);
            a.setX(move[i][0]);
            i++;
        }
    }
    void moveTurn(int[][] MESH, int SIZE);
}
