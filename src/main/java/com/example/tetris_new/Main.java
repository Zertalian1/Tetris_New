package com.example.tetris_new;

import com.example.tetris_new.Controller.C;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static int XMAX = 10;
    public static int YMAX = 10;
    public static final int [][] MESH = new int[XMAX][YMAX];

    public static void main(String[] args) {
        launch(args);
       /* List<Rectangle> figure = new ArrayList<>();
        System.out.println(MESH.length);
        Rectangle z;
        for(int i=0;i<5;i++){
            z = new Rectangle(25,25);
            z.setX(i);
            z.setY(i);
            figure.add(z);
        }
        Figure a = new formI(figure);
        try {
             a = C.makeRect();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // Figure a = new formI(figure);
        C.moveFigureDown();
        a.moveDown(MESH);
        for(Rectangle c: a.getFigure() ){
            MESH[(int) c.getX()][(int) c.getY()]=1;
        }
        for(int i=0;i<YMAX;i++){
            for(int j=0;j<XMAX;j++){
                System.out.print(MESH[j][i]);
            }
            System.out.println();
        }*/
    }

    @Override
    public void start(Stage stage) throws Exception {
        C game = new C();
        game.startGame(stage);
    }
}
