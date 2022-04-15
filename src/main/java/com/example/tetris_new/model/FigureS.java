package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureS implements Figure{

    protected List<Rectangle> figure = new ArrayList<>();
    private final Color color = Color.FORESTGREEN;

    public FigureS(int XMAX, int SIZE) {
        figure.add(new Rectangle(XMAX >> 1,0,SIZE-1,SIZE-1)); //a
        figure.add(new Rectangle((XMAX >> 1) +SIZE,0,SIZE-1,SIZE-1)); //b
        figure.add(new Rectangle(XMAX >> 1,SIZE,SIZE-1,SIZE-1)); //d
        figure.add(new Rectangle((XMAX >> 1) -SIZE,SIZE,SIZE-1,SIZE-1)); //c
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
        turn(figure, figure.get(0).getX(), figure.get(0).getY(), MESH, SIZE);
    }
}
