package com.example.tetris_new.Controller;

import com.example.tetris_new.model.*;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FigureController {
    public static int SIZE =25;
    public static int XMAX = SIZE*12;
    public static int YMAX = SIZE*15;
    private static Figure figure;

    public FigureController(int SIZE, int XMAX, int YMAX){
        makeRect();
        this.SIZE= SIZE;
        this.XMAX = XMAX;
        this.YMAX = YMAX;
    }

    public static Figure getFigure() {
        return figure;
    }

    public static boolean moveRight(int[][] MESH){
        for(Rectangle a: figure.getFigure()){
            if(!checkPlace(a,MESH, 1, 0))
                return false;
        }
        for(Rectangle a: figure.getFigure()){
            a.setX(a.getX()+1);
        }
        return true;
    }

    public static boolean moveLeft(int[][] MESH){
        for(Rectangle a: figure.getFigure()){
            if(!checkPlace(a,MESH, -1, 0))
                return false;
        }
        for(Rectangle a: figure.getFigure()){
            a.setX(a.getX()-1);
        }
        return true;
    }

    public static boolean moveDown(int[][] MESH) {
        for (Rectangle a : figure.getFigure()) {
            if (!checkPlace(a, MESH, 0, 1))
                return false;
        }
        for (Rectangle a : figure.getFigure()) {
            a.setY(a.getY() + SIZE);
        }
        return true;
    }


    protected static boolean checkPlace(Rectangle part, int[][] MESH, int x, int y){ // не вылезти за границы и не врезаться в фигуру
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

    public static boolean checkSpawn(int[][] MESH){
        for (Rectangle a : figure.getFigure()) {
            if (!checkPlace(a, MESH, 0, 0))
                return false;
        }
        return true;
    }

    public void makeRect(){
        int block = (int)((Math.random()*100)%7);
        List<Rectangle> new_figure = new ArrayList<>();
        if(block==0){   //j
            new_figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //a
            new_figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //b
            new_figure.add(new Rectangle(XMAX/2,2*SIZE,SIZE-1,SIZE-1)); //d
            new_figure.add(new Rectangle(XMAX/2-SIZE,2*SIZE,SIZE-1,SIZE-1)); //c
            figure =  new FormJ(new_figure);
            //   a
            //   b
            // c d
        }
        if(block==1){   //l
            new_figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //a
            new_figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //b
            new_figure.add(new Rectangle(XMAX/2,2*SIZE,SIZE-1,SIZE-1)); //d
            new_figure.add(new Rectangle(XMAX/2+SIZE,2*SIZE,SIZE-1,SIZE-1)); //c
            figure = new FormL(new_figure);
            //  a
            //   b
            //  d c
        }
        if(block==2){   //o
            new_figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //a
            new_figure.add(new Rectangle(XMAX/2+SIZE,0,SIZE-1,SIZE-1)); //b
            new_figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //d
            new_figure.add(new Rectangle(XMAX/2+SIZE,SIZE,SIZE-1,SIZE-1)); //c
            figure = new FormO(new_figure);
            //  a b
            //  c d
        }
        if(block==3){   //s
            new_figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //a
            new_figure.add(new Rectangle(XMAX/2+SIZE,0,SIZE-1,SIZE-1)); //b
            new_figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //d
            new_figure.add(new Rectangle(XMAX/2-SIZE,SIZE,SIZE-1,SIZE-1)); //c
            figure = new FormS(new_figure);
            //    a b
            //  c d
        }
        if(block==4){   //t
            new_figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //a
            new_figure.add(new Rectangle(XMAX/2-SIZE,SIZE,SIZE-1,SIZE-1)); //b
            new_figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //c
            new_figure.add(new Rectangle(XMAX/2+SIZE,SIZE,SIZE-1,SIZE-1)); //d
            figure = new FormT(new_figure);
            //    a
            //  b c d
        }
        if(block==5){   //z
            new_figure.add(new Rectangle(XMAX/2-SIZE,0,SIZE-1,SIZE-1)); //a
            new_figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //b
            new_figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //c
            new_figure.add(new Rectangle(XMAX/2+SIZE,SIZE,SIZE-1,SIZE-1)); //d
            figure = new FormZ(new_figure);
            //   a b
            //     c d
        }
        if(block==6){   //i
            new_figure.add(new Rectangle(XMAX/2,0,SIZE-1,SIZE-1)); //a
            new_figure.add(new Rectangle(XMAX/2,SIZE,SIZE-1,SIZE-1)); //b
            new_figure.add(new Rectangle(XMAX/2,2*SIZE,SIZE-1,SIZE-1));
            new_figure.add(new Rectangle(XMAX/2,3*SIZE,SIZE-1,SIZE-1));
            figure = new FormI(new_figure);
            //  a
            //  b
            //  d
            //  c
        }
    }

    public void moveTurn(int[][] mesh) {
    }
}
