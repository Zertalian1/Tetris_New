package com.example.tetris_new.Controller;
import java.sql.*;

public class DBController {
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/players";

    public void addDataToDB(String Name, int Score) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        String SQL_UPDATE_TASK = "insert into player(name, score) values(?,?) on conflict (name) do update set score = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_TASK);
        preparedStatement.setString(1,Name);
        preparedStatement.setInt(2, Score);
        preparedStatement.setInt(3, Score);
        preparedStatement.executeUpdate();
    }



    public ResultSet getDataFromDB() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASK = "select * from player order by score desc limit 10";
        return statement.executeQuery(SQL_SELECT_TASK);
    }
}
