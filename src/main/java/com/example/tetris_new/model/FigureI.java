package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureI implements Figure{
    protected List<Rectangle> figure = new ArrayList<>();
    private final Color color = Color.SANDYBROWN;
    private int form = 1;

    public FigureI(int XMAX, int SIZE ) { // формировать figure здесь
        figure.add(new Rectangle(XMAX >> 1,0,SIZE-1,SIZE-1)); //a
        figure.add(new Rectangle(XMAX >> 1,SIZE,SIZE-1,SIZE-1)); //b
        figure.add(new Rectangle(XMAX >> 1,2*SIZE,SIZE-1,SIZE-1));
        figure.add(new Rectangle(XMAX >> 1,3*SIZE,SIZE-1,SIZE-1));
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
        int negative = (int) Math.pow(-1, form%2);
        if (checkPlace(figure.get(0), negative, -negative, MESH, SIZE) && checkPlace(figure.get(2), -negative,negative, MESH, SIZE) &&
                checkPlace(figure.get(3), -2*negative,2*negative, MESH, SIZE)){
            turn(figure.get(0), negative, -negative, SIZE);
            turn(figure.get(3), -2*negative, 2*negative, SIZE);
            turn(figure.get(2), -negative, negative, SIZE);
            form = (++form)%4;
        }
        System.out.println(form);
    }

    private void turn(Rectangle rect, int X, int Y, int SIZE){
        rect.setX(rect.getX() + X*SIZE);
        rect.setY(rect.getY() + Y*SIZE);
    }
}
