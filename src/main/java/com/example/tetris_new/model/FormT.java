package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FormT extends Figure{

    public FormT(List<Rectangle> figure/*,int[][] MESH*/) {
        super(figure, Color.CADETBLUE);
    }

    @Override
    public void moveTurn(int [][] MESH) {

    }
}
