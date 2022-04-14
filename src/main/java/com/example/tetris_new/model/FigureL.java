package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureL implements Figure{

    protected List<Rectangle> figure = new ArrayList<>();
    private final Color color = Color.DARKGOLDENROD;
    private int form = 1;

    public FigureL(int XMAX, int SIZE) {
        figure.add(new Rectangle(XMAX >> 1,0,SIZE-1,SIZE-1)); //a
        figure.add(new Rectangle(XMAX >> 1,SIZE,SIZE-1,SIZE-1)); //b
        figure.add(new Rectangle(XMAX >> 1,2*SIZE,SIZE-1,SIZE-1)); //d
        figure.add(new Rectangle(XMAX >> 1 + SIZE,2*SIZE,SIZE-1,SIZE-1)); //c
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
        switch (form){
            case 1 ->{
               /* if (checkTurn(figure.get(0), -1, 1) && checkTurn(d, 1, -1) && checkTurn(c, 0, -2)) {
                    turn(a, -1, 1);
                    turn(d, 1, -1);
                    turn(c, 0, -2);
                    form.changeForm();
                }

                if (f == 2 && checkTurn(a, 1, 1) && checkTurn(d, -1, -1) && checkTurn(c, -2, 0)) {
                    turn(a, 1, 1);
                    turn(d, -1, -1);
                    turn(c, -2, 0);
                    form.changeForm();
                }
                if (f == 3 && checkTurn(a, 1, -1) && checkTurn(d, -1, 1) && checkTurn(c, 0, 2)) {
                    turn(a, 1, -1);
                    turn(d, -1, 1);
                    turn(c, 0, 2);
                    form.changeForm();
                }
                if (f == 4 && checkTurn(a, -1, -1) && checkTurn(d, 1, 1) && checkTurn(c, 2, 0)) {
                    turn(a, -1, -1);
                    turn(d, 1, 1);
                    turn(c, 2, 0);
                    form.changeForm();
                }*/
            }
        }
    }
    private void turn(Rectangle rect, int X, int Y, int SIZE){
        rect.setX(rect.getX() + X*SIZE);
        rect.setY(rect.getY() + Y*SIZE);
    }
}
