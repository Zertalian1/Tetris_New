package com.example.tetris_new.model;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public  interface /*abstract class*/ Figure {
    /*protected List<Rectangle> figure = new ArrayList<>();
    private int form = 1;

    Figure(List<Rectangle> blocks,Color color){
        for(Rectangle a: blocks){
            a.setFill(color);
            figure.add(a);
        }
    }
    Figure() {}

    protected void changeForm(){
        if(form!=4) form++;
        else form=1;
    }*/

    public List<Rectangle> getFigure();

    public abstract void moveTurn(int [][] MESH);
}
// добавить интрфейс