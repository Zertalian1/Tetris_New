package com.example.tetris_new.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class FormJ extends Figure{

    public FormJ(List<Rectangle> figure) {
        super(figure, Color.SLATEGREY);
    }

    @Override
    public void moveTurn(int [][] MESH) {

    }
}
