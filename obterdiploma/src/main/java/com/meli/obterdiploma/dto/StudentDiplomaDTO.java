package com.meli.obterdiploma.dto;

import java.util.List;

public class StudentDiplomaDTO {
    private String message;
    private double average;
    private List<StudentDTO> student;

    public StudentDiplomaDTO(String message, double average, List<StudentDTO> student) {
        this.message = message;
        this.average = average;
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public double getAverage() {
        return average;
    }

    public List<StudentDTO> getStudent() {
        return student;
    }
}
