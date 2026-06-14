package com.JDBC_Integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {


    private static final String URL = "jdbc:mysql://localhost:3306/inventry_db";

    private static final String USER = "root";

    private static final String PASSWORD = "admin";


    public static Connection createConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }



}
