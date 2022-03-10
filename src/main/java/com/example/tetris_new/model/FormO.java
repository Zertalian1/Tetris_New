package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FormO extends Figure{

    public FormO(List<Rectangle> figure/*,int[][] MESH*/) {
        super(figure, Color.INDIANRED);
    }

    @Override
    public void moveTurn(int [][] MESH) {

    }
}
