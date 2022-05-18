package com.example.tetris_new.Controller;
import com.example.tetris_new.model.DataBase;
import com.example.tetris_new.model.DataBasePost;

import java.sql.*;

public class DBController {
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "123";
    private final String DB_URL = "jdbc:postgresql://localhost:5432/players";
    DataBase dataBase = new DataBasePost();

    public void addDataToDB(String Name, int Score) throws SQLException {
        dataBase.addConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        if(isNewScoreBigger(Name, Score)) {
            dataBase.addRecord(Name, Score);
        }
        dataBase.destroyConnection();
    }

    private boolean isNewScoreBigger(String Name, int Score) throws SQLException {
        ResultSet resultSet = dataBase.gerRecordByName(Name);
        boolean chek=true;
        while (resultSet.next()){
            chek= Score > resultSet.getInt("Score");
        }
        return chek;
    }


    public void getDataFromDB() throws SQLException {
        dataBase.addConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        ResultSet resultSet = dataBase.getRecord();
        dataBase.destroyConnection();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Name") + " " +
                    resultSet.getInt("Score"));
        }
    }
}
