package com.example.tetris_new.model;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {
    protected List<Rectangle> figure = new ArrayList<>();
    private Color color; // зачем мне эта переменная
    private int form = 1;

    Figure(List<Rectangle> blocks,Color color){
        /*for(Rectangle a: figure){
            if(!checkPlace(a,MESH, 0, 0))
                return;             // пусть кидает ошибку
        }*/
        for(Rectangle a: blocks){
            a.setFill(color);
            figure.add(a);
        }
    }
    Figure() {}

 //   public String getName() {
 //       return name;
 //   }
    protected void changeForm(){
        if(form!=4) form++;
        else form=1;
    }
    public List<Rectangle> getFigure(){
        return figure;
    }

    /*public boolean moveRight(int [][] MESH){
        for(Rectangle a: figure){
            if(!checkPlace(a,MESH, 1, 0))
                return false;
        }
        for(Rectangle a: figure){
            a.setX(a.getX()+SIZE);
        }
        return true;
    }

    public boolean moveLeft(int [][] MESH){
        for(Rectangle a: figure){
            if(!checkPlace(a,MESH, -1, 0))
                return false;
        }
        for(Rectangle a: figure){
            a.setX(a.getX()-SIZE);
        }
        return true;
    }

    public boolean moveDown(int[][] MESH) {
        for (Rectangle a : figure) {
            if (!checkPlace(a, MESH, 0, 1))
                return false;
        }
        for (Rectangle a : figure) {
            a.setY(a.getY() + SIZE);
        }
        return true;
    }


    protected boolean checkPlace(Rectangle part,int [][] MESH, int x, int y){ // не вылезти за границы и не врезаться в фигуру
        boolean checkX = false;
        boolean checkY = false;
        if(x>=0)
            checkX = (int)(part.getX()/SIZE+x) < (MESH.length);
        if(x<0)
            checkX = (int)(part.getX()/SIZE+x) >= 0;
        if(y>=0)
            checkY = (int)(part.getY()/SIZE+y) < (MESH[0].length);
        if(y<0)
            checkY = (int)(part.getY()/SIZE+y) >= 0;
        return checkX && checkY && MESH[(int)part.getX()/SIZE+x][(int)part.getY()/SIZE+y]==0;
    }

    public boolean checkSpawn(int [][] MESH){
        for (Rectangle a : figure) {
            if (!checkPlace(a, MESH, 0, 0))
                return false;
        }
        return true;
    }*/

    public abstract void moveTurn(int [][] MESH);
}
