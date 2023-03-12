package com.edu.pro.model;

import java.util.Objects;

public class Monhoc {
    private String id ;
    private String name;

    public Monhoc(){}
    public Monhoc(String id, String name) {
        this.id = id;
        this.name = name;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Monhoc{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monhoc monhoc = (Monhoc) o;
        return  Objects.equals(id, monhoc.id) && Objects.equals(name, monhoc.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
