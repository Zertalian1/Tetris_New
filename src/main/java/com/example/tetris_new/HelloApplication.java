package com.example.tetris_new;

import com.example.tetris_new.model.Figure;
import com.example.tetris_new.model.FigureI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    static void foo(int[][] a){
        a[0][0]=-100;
    }

    public static void main(String[] args) {
        List<Rectangle> figure = new ArrayList<>();
        int[][] l = {{0,0},{0,0}};//new int[3][3];
        foo(l);
        System.out.println(l.length);
        for(int i=0;i<5;i++){
            figure.add(new Rectangle(i,i));
        }
       // Figure a = new FigureI(figure);
        //a.moveDown(l);
        launch();
    }
}