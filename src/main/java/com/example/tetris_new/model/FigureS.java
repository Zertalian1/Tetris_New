package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureS implements Figure{

    protected List<Rectangle> figure = new ArrayList<>();
    private final Color color = Color.FORESTGREEN;
    private int form = 1;

    public FigureS(int XMAX, int SIZE) {
        figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //a
        figure.add(new Rectangle(XMAX/2+SIZE,0,SIZE-1,SIZE-1)); //b
        figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //d
        figure.add(new Rectangle(XMAX/2-SIZE,SIZE,SIZE-1,SIZE-1)); //c
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

    }
}
