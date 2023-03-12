package com.edu.pro.model;

import java.util.Objects;

public class Lop {
    private String id;
    private String name;
    private int numbers;

    public Lop(){}
    public Lop(String id, String name, int numbers) {
        this.id = id;
        this.name = name;
        this.numbers = numbers;
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

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Lop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lop lop = (Lop) o;
        return numbers == lop.numbers && Objects.equals(id, lop.id) && Objects.equals(name, lop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numbers);
    }
}
