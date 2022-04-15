package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureJ implements Figure{
    protected List<Rectangle> figure = new ArrayList<>();
    private final Color color = Color.SLATEGREY;

    public FigureJ(int XMAX, int SIZE) {
        figure.add(new Rectangle(XMAX >> 1,0,SIZE-1,SIZE-1)); //a
        figure.add(new Rectangle(XMAX >> 1,SIZE,SIZE-1,SIZE-1)); //b
        figure.add(new Rectangle(XMAX >> 1,2*SIZE,SIZE-1,SIZE-1)); //d
        figure.add(new Rectangle((XMAX >> 1) -SIZE,2*SIZE,SIZE-1,SIZE-1)); //c
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
        /*switch (form){
            case 0 -> {
                if (checkPlace(figure.get(0), -1, 1, MESH, SIZE) && checkPlace(figure.get(2), 1, -1, MESH, SIZE)
                        && checkPlace(figure.get(3), 2, 0, MESH, SIZE)) {
                    turn(figure.get(0), -1, 1, SIZE);
                    turn(figure.get(2), 1, -1, SIZE);
                    turn(figure.get(3), 2, 0, SIZE);
                    form = (++form)%4;
                }
            }
            case 1 -> {
                if (checkPlace(figure.get(0), 1, 1, MESH, SIZE) && checkPlace(figure.get(2), -1, -1, MESH, SIZE)
                        && checkPlace(figure.get(3), 0, -2, MESH, SIZE)) {
                    turn(figure.get(0), 1, 1, SIZE);
                    turn(figure.get(2), -1, -1, SIZE);
                    turn(figure.get(3), 0, -2, SIZE);
                    form = (++form)%4;
                }
            }
            case 2 -> {
                if (checkPlace(figure.get(0), 1, -1, MESH, SIZE) && checkPlace(figure.get(2), -1, 1, MESH, SIZE)
                        && checkPlace(figure.get(3), -2, 0, MESH, SIZE)) {
                    turn(figure.get(0), 1, -1, SIZE);
                    turn(figure.get(2), -1, 1, SIZE);
                    turn(figure.get(3), -2, 0, SIZE);
                    form = (++form)%4;
                }
            }
            case 3 -> {
                if (checkPlace(figure.get(0), -1, -1, MESH, SIZE) && checkPlace(figure.get(2), 1, 1, MESH, SIZE)
                        && checkPlace(figure.get(3), 0, 2, MESH, SIZE)) {
                    turn(figure.get(0), -1, -1, SIZE);
                    turn(figure.get(2), 1, 1, SIZE);
                    turn(figure.get(3), 0, 2, SIZE);
                    form = (++form)%4;
                }
            }
        }*/
        turn(figure, figure.get(1).getX(), figure.get(1).getY(), MESH, SIZE);


    }

    private void turn(Rectangle rect, int X, int Y, int SIZE){
        rect.setX(rect.getX() + X*SIZE);
        rect.setY(rect.getY() + Y*SIZE);
    }
}
