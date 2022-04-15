package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureI implements Figure{
    protected List<Rectangle> figure = new ArrayList<>();
    private final Color color = Color.SANDYBROWN;

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

        turn(figure, figure.get(1).getX(), figure.get(1).getY(), MESH, SIZE);
    }

}
