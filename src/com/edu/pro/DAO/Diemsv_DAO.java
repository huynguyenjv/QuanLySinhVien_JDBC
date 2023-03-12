package com.edu.pro.DAO;

import com.edu.pro.db.JDBCtil;
import com.edu.pro.model.Diemsv;
import com.edu.pro.model.Monhoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Diemsv_DAO implements DAO<Diemsv> {
    public static Diemsv_DAO getInstance() {
        return new Diemsv_DAO();
    }
    @Override
    public boolean insert(Diemsv value) {
        int result = 0;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "INSERT INTO Monhoc (mssv,mamh,diem) " +
                    " VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,  value.getId_sinhvien());
            preparedStatement.setString(2, value.getId_monhon());
            preparedStatement.setFloat(3,value.getScore());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Diemsv value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " DELETE FROM Diemsv " +
                    " WHERE mssv=? and mamh=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,value.getId_sinhvien());
            preparedStatement.setString(2,value.getId_monhon());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Diemsv value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " UPDATE Diemsv " +
                    "  SET" +
                    " diem=?" +
                    "WHERE mssv=? AND mamh=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,value.getId_sinhvien());
            preparedStatement.setString(2,value.getId_monhon());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateByCondition(Diemsv value,String condition) {
        return false;
    }

    @Override
    public Diemsv selectById(Diemsv value) {
        Diemsv result = null;
        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Diemsv" +
                    " WHERE mssv=? and mamh=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,value.getId_sinhvien());
            preparedStatement.setString(2,value.getId_monhon());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                long id_sinhvien = resultSet.getLong("mssv");
                String id_monhoc = resultSet.getString("mamh");
                float score = resultSet.getFloat("diem");

                result = new Diemsv(id_sinhvien,id_monhoc,score);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Diemsv> selectAll() {
        ArrayList<Diemsv> result = new ArrayList<Diemsv>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Diemsv";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                long id_sinhvien = resultSet.getLong("mssv");
                String id_monhoc = resultSet.getString("mamh");
                float score = resultSet.getFloat("diem");

                Diemsv diemsv = new Diemsv(id_sinhvien,id_monhoc,score);

                result.add(diemsv);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Diemsv> selectByCondition(String condition) {
        ArrayList<Diemsv> result = new ArrayList<Diemsv>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Diemsv" +
                    " WHERE "+condition;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                long id_sinhvien = resultSet.getLong("mssv");
                String id_monhoc = resultSet.getString("mamh");
                float score = resultSet.getFloat("diem");

                Diemsv diemsv = new Diemsv(id_sinhvien,id_monhoc,score);

                result.add(diemsv);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
