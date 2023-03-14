package com.edu.pro.DAO;

import com.edu.pro.db.JDBCtil;
import com.edu.pro.model.Lop;
import com.edu.pro.model.Monhoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Monhoc_DAO implements DAO<Monhoc>{
    public static Monhoc_DAO getInstance(){
        return new Monhoc_DAO();
    }
    @Override
    public boolean insert(Monhoc value) {
        int result = 0;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "INSERT INTO monhoc (mamh,tenmh) " +
                    " VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,  value.getId());
            preparedStatement.setString(2, value.getName());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Monhoc value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " DELETE FROM Monhoc " +
                    " WHERE mamh=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value.getId());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Monhoc value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " UPDATE monhoc " +
                    "  SET" +
                    " tenmh=?" +
                    "WHERE mamh=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value.getName());
            preparedStatement.setString(2,value.getId());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateByCondition(Monhoc value,String condition) {
        return false;
    }

    @Override
    public Monhoc selectById(Monhoc value) {
        Monhoc result = null;
        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Monhoc" +
                    " WHERE mamh=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("mamh");
                String name = resultSet.getString("tenmh");


                result = new Monhoc(id,name);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Monhoc> selectAll() {
        ArrayList<Monhoc> result = new ArrayList<Monhoc>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Monhoc";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("mamh");
                String name = resultSet.getString("tenmh");

                Monhoc monhoc = new Monhoc(id,name);

                result.add(monhoc);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Monhoc> selectByCondition(String condition) {
        ArrayList<Monhoc> result = new ArrayList<Monhoc>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Monhoc" +
                    " WHERE "+condition;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("mamh");
                String name = resultSet.getString("tenmh");

                Monhoc monhoc = new Monhoc(id,name);

                result.add(monhoc);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void printData(){
        try {
            Connection connection = JDBCtil.getConnection();

            JDBCtil.printData(connection,"Lop",10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
