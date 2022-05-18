package com.example.tetris_new.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {
    public void addRecord(String Name, int Score) throws SQLException;
    public ResultSet getRecord() throws SQLException;
    public ResultSet gerRecordByName(String Name) throws SQLException;
    public void addConnection(String DB_URL, String DB_USERNAME,String DB_PASSWORD) throws SQLException;
    public void destroyConnection() throws SQLException;
}
