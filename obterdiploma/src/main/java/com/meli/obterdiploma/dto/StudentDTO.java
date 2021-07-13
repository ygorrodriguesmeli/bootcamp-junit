package com.meli.obterdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {
    @Size(min = 8, max = 50, message = "Nome deve possuir no mínimo 8 caracteres alfabéticos")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Somente letras permitidas")
    private String name;

    private List<@Valid SubjectDTO> subjects;

    public StudentDTO(String name, List<SubjectDTO> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
