package com.meli.obterdiploma.entity;

public class Subject {
    private String name;
    private Double note;

    public Subject(String name, Double note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public Double getNote() {
        return note;
    }
}
