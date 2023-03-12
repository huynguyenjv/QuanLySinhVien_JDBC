package com.edu.pro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JDBCtil {
    public static Connection getConnection(){
        Connection connection = null ;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            String sql = "jdbc:mysql://localhost:3306/qlsinhvien";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(sql, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printData(Connection connection,String nameTable,int rows){
        try {
            if(connection != null){
                DBTablePrinter.printTable(connection,nameTable,rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
