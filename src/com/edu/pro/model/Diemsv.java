package com.edu.pro.model;

import java.util.Objects;

public class Diemsv {
    private long id_sinhvien;
    private String id_monhon;
    private float score;

    public Diemsv(){}
    public Diemsv(long id_sinhvien, String id_monhon, float score) {
        this.id_sinhvien = id_sinhvien;
        this.id_monhon = id_monhon;
        this.score = score;
    }



    public long getId_sinhvien() {
        return id_sinhvien;
    }

    public void setId_sinhvien(long id_sinhvien) {
        this.id_sinhvien = id_sinhvien;
    }

    public String getId_monhon() {
        return id_monhon;
    }

    public void setId_monhon(String id_monhon) {
        this.id_monhon = id_monhon;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Diemsv{" +
                "id_sinhvien=" + id_sinhvien +
                ", id_monhon='" + id_monhon + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diemsv diemsv = (Diemsv) o;
        return id_sinhvien == diemsv.id_sinhvien && Float.compare(diemsv.score, score) == 0
                && Objects.equals(id_monhon, diemsv.id_monhon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_sinhvien, id_monhon, score);
    }
}
