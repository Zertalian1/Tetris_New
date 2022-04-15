package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureL implements Figure{

    protected List<Rectangle> figure = new ArrayList<>();
    private final Color color = Color.DARKGOLDENROD;

    public FigureL(int XMAX, int SIZE) {
        figure.add(new Rectangle(XMAX >> 1,0,SIZE-1,SIZE-1)); //a
        figure.add(new Rectangle(XMAX >> 1,SIZE,SIZE-1,SIZE-1)); //b
        figure.add(new Rectangle(XMAX >> 1,2*SIZE,SIZE-1,SIZE-1)); //d
        figure.add(new Rectangle((XMAX >> 1) +SIZE,2*SIZE,SIZE-1,SIZE-1)); //c
        SetColor();
    }

    private void SetColor(){
        for(Rectangle a: figure){
            a.setFill(color);
        }
    }

    @Override
    public List<Rectangle> getFields() {
        return figure;
    }

    @Override
    public void moveTurn(int [][] MESH, int SIZE) {
        turn(figure, figure.get(1).getX(), figure.get(1).getY(),MESH, SIZE);
    }
    private void turn(Rectangle rect, int X, int Y, int SIZE){
        rect.setX(rect.getX() + X*SIZE);
        rect.setY(rect.getY() + Y*SIZE);
    }
}
