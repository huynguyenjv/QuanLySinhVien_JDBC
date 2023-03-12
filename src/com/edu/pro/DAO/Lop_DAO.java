package com.edu.pro.DAO;

import com.edu.pro.db.JDBCtil;
import com.edu.pro.model.Lop;
import com.edu.pro.model.Sinhvien;

import java.sql.*;
import java.util.ArrayList;

public class Lop_DAO implements DAO<Lop> {
    public static Lop_DAO getInstance() {
        return new Lop_DAO();
    }
    @Override
    public boolean insert(Lop value) {
        int result = 0;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "INSERT INTO lop (malop,tenlop,siso) " +
                    " VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,  value.getId());
            preparedStatement.setString(2, value.getName());
            preparedStatement.setInt(3, value.getNumbers());


            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Lop value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " DELETE FROM Lop " +
                    " WHERE malop=?";

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
    public boolean update(Lop value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " UPDATE Lop " +
                    "  SET" +
                    " tenlop=?" +
                    ", siso=?" +
                    "WHERE malop=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value.getName());
            preparedStatement.setInt(2,value.getNumbers());
            preparedStatement.setString(3,value.getId());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateByCondition(Lop value, String condition) {
        int result = 0 ;
        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " UPDATE lop " +
                    "  SET " +condition+
                    " WHERE mssv=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2,value.getId());
            if(condition.equals("tenlop=?")){
                preparedStatement.setString(1,value.getName());
            }else if(condition.equals("siso=?")) {
                preparedStatement.setInt(1, value.getNumbers());
            }
            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Lop selectById(Lop value) {
        Lop result = null;
        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Lop" +
                    " WHERE malop=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("malop");
                String name = resultSet.getString("tenlop");
                int numbers = resultSet.getInt("siso");

                result = new Lop(id,name,numbers);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Lop> selectAll() {
        ArrayList<Lop> result = new ArrayList<Lop>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Lop";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("malop");
                String name = resultSet.getString("tenlop");
                int numbers = resultSet.getInt("siso");

                Lop lop =new Lop(id,name,numbers);

                result.add(lop);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Lop> selectByCondition(String condition) {
        ArrayList<Lop> result = new ArrayList<Lop>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Lop" +
                    " WHERE "+condition;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("malop");
                String name = resultSet.getString("tenlop");
                int numbers = resultSet.getInt("siso");

                Lop lop =new Lop(id,name,numbers);

                result.add(lop);
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
