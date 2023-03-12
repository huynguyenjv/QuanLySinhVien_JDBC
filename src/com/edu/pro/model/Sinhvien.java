package com.edu.pro.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Sinhvien implements Serializable {
    private long id ;
    private String name ;
    private Date dob ;
    private String isGender;
    private String id_lop;

    public Sinhvien(long id, String name, Date dob, String isGender,String id_lop) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.isGender = isGender;
        this.id_lop = id_lop;
    }
    public Sinhvien(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String isGender() {
        return isGender;
    }

    public void setGender(String gender) {
        isGender = gender;
    }

    public String getId_lop() {
        return id_lop;
    }

    public void setId_lop(String id_lop) {
        this.id_lop = id_lop;
    }

    @Override
    public String toString() {
        return "Sinhvien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", isGender=" + isGender +
                ", id_lop='" + id_lop + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien sinhvien = (Sinhvien) o;
        return id == sinhvien.id && Objects.equals(isGender,sinhvien.isGender)
                && Objects.equals(name, sinhvien.name) && Objects.equals(dob, sinhvien.dob)
                && Objects.equals(id_lop, sinhvien.id_lop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob, isGender, id_lop);
    }
}
