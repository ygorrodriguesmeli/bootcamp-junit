package com.meli.obterdiploma.entity;

import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjectList;

    public Student(String name, List<Subject> subjectList) {
        this.name = name;
        this.subjectList = subjectList;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}
