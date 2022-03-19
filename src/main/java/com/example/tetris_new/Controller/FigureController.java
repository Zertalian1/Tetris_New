package com.example.tetris_new.Controller;

import com.example.tetris_new.model.*;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class FigureController {
    public static int SIZE =25;
    public static int XMAX = SIZE*12;
    public static int YMAX = SIZE*15;
    private static Figure figure;

    public FigureController(int SIZE, int XMAX, int YMAX){
        makeRect();
        FigureController.SIZE = SIZE;
        FigureController.XMAX = XMAX;
        FigureController.YMAX = YMAX;
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
            a.setX(a.getX()+SIZE);
        }
        return true;
    }

    public static boolean moveLeft(int[][] MESH){
        for(Rectangle a: figure.getFigure()){
            if(!checkPlace(a,MESH, -1, 0))
                return false;
        }
        for(Rectangle a: figure.getFigure()){
            a.setX(a.getX()-SIZE);
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
        Figures figures = Figures.randomLetter();
        switch (figures){
            case J -> figure = new FigureJ(XMAX, SIZE);
            case L -> figure = new FigureL(XMAX, SIZE);
            case O -> figure = new FigureO(XMAX, SIZE);
            case S -> figure = new FigureS(XMAX, SIZE);
            case T -> figure = new FigureT(XMAX, SIZE);
            case Z -> figure = new FigureZ(XMAX, SIZE);
            case I -> figure = new FigureI(XMAX, SIZE);
        }
    }
    enum Figures {
        I,
        J,
        L,
        O,
        S,
        T,
        Z;
        private static final List<Figures> VALUES =
                List.of(values());
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static Figures randomLetter()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }

    public void moveTurn(int[][] mesh) {
    }
}
