package com.edu.pro.DAO;

import java.util.ArrayList;

public interface DAO<T> {
    public boolean insert(T value);
    public boolean remove(T value);
    public boolean update(T value);
    public boolean updateByCondition(T value,String condition);
    public T selectById(T value);
    public ArrayList<T> selectAll();
    public ArrayList<T> selectByCondition(String condition);

}
