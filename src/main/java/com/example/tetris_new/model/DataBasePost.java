package com.example.tetris_new.model;

import java.sql.*;

public class DataBasePost implements DataBase{

    Connection connection;

    @Override
    public void addRecord(String Name, int Score) throws SQLException {
        String SQL_UPDATE_TASK = "insert into player(name, score) values(?,?) on conflict (name) do update set score = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_TASK);
        preparedStatement.setString(1, Name);
        preparedStatement.setInt(2, Score);
        preparedStatement.setInt(3, Score);
        preparedStatement.executeUpdate();
    }

    @Override
    public ResultSet getRecord() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASK = "select * from player order by score desc limit 10";
        return statement.executeQuery(SQL_SELECT_TASK);
    }

    @Override
    public ResultSet gerRecordByName(String Name) throws SQLException {
        String SQL_SELECT_TASK = "select * from player where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_TASK);
        preparedStatement.setString(1,Name);
        return preparedStatement.executeQuery();
    }

    @Override
    public void addConnection(String DB_URL, String DB_USERNAME,String DB_PASSWORD) throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public void destroyConnection() throws SQLException {
        connection.close();
    }
}
