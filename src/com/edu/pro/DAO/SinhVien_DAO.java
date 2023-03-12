package com.edu.pro.DAO;

import com.edu.pro.db.JDBCtil;
import com.edu.pro.model.Sinhvien;

import java.sql.*;
import java.util.ArrayList;

public class SinhVien_DAO implements DAO<Sinhvien>{
    public static SinhVien_DAO getInstance(){
        return new SinhVien_DAO();
    }
    @Override
    public boolean insert(Sinhvien value) {
        int result = 0;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "INSERT INTO sinhvien (mssv,ten,ngaysinh,phai,malop) " +
                    " VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,  value.getId());
            preparedStatement.setString(2, value.getName());
            preparedStatement.setDate(3,value.getDob());
            preparedStatement.setString(4,value.isGender());
            preparedStatement.setString(5, value.getId_lop());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean remove(Sinhvien value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " DELETE FROM Sinhvien " +
                    " WHERE mssv=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,value.getId());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Sinhvien value) {
        int result = 0 ;

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " UPDATE Sinhvien " +
                    "  SET" +
                    " ten=?" +
                    ", ngaysinh=?" +
                    ", phai=? " +
                    ", malop=?" +
                    "WHERE mssv=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value.getName());
            preparedStatement.setDate(2,value.getDob());
            preparedStatement.setString(3,value.isGender());
            preparedStatement.setString(4,value.getId_lop());
            preparedStatement.setLong(5,value.getId());

            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateByCondition(Sinhvien value,String condition) {
       int result = 0;
        try {
            Connection connection = JDBCtil.getConnection();

            String sql = " UPDATE Sinhvien " +
                    "  SET " +condition+
                    " WHERE mssv=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(2,value.getId());
            if(condition.equals("ten=?")){
                preparedStatement.setString(1,value.getName());
            }else if(condition.equals("ngaysinh=?")){
                preparedStatement.setDate(1,value.getDob());
            }else if(condition.equals("phai=?")){
                preparedStatement.setString(1,value.isGender());
            } else if (condition.equals("malop=?")) {
                preparedStatement.setString(1,value.getId_lop());

            }
            result = preparedStatement.executeUpdate();

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Sinhvien selectById(Sinhvien value) {
        Sinhvien result = null;
        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Sinhvien" +
                    " WHERE mssv=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,value.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                long id = resultSet.getLong("mssv");
                String name = resultSet.getString("ten");
                Date date = resultSet.getDate("ngaysinh");
                String gender = resultSet.getString("phai");

                result = new Sinhvien(id,name,date,gender,"111");
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ArrayList<Sinhvien> selectAll() {
        ArrayList<Sinhvien> result = new ArrayList<Sinhvien>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Sinhvien";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                long id = resultSet.getLong("mssv");
                String name = resultSet.getString("ten");
                Date date = resultSet.getDate("ngaysinh");
                String gender = resultSet.getString("phai");
                String id_lop = resultSet.getString("malop");

                Sinhvien sinhvien= new Sinhvien(id,name,date,gender,id_lop);

                result.add(sinhvien);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Sinhvien> selectByCondition(String condition) {
        ArrayList<Sinhvien> result = new ArrayList<Sinhvien>();

        try {
            Connection connection = JDBCtil.getConnection();

            String sql = "SELECT * FROM Sinhvien" +
                    " WHERE "+condition;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                long id = resultSet.getLong("mssv");
                String name = resultSet.getString("ten");
                Date date = resultSet.getDate("ngaysinh");
                String gender = resultSet.getString("phai");
                String id_lop = resultSet.getString("malop");

                Sinhvien sinhvien= new Sinhvien(id,name,date,gender,id_lop);

                result.add(sinhvien);
            }

            JDBCtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void printData(){
        try {
            Connection connection = JDBCtil.getConnection();

            JDBCtil.printData(connection,"Sinhvien",50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
