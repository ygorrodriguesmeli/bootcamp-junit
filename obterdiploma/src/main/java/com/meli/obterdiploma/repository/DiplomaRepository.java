package com.meli.obterdiploma.repository;

import com.meli.obterdiploma.dto.StudentDiplomaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiplomaRepository {
    private static List<StudentDiplomaDTO> diplomas = new ArrayList<>();

    public StudentDiplomaDTO addDiploma(StudentDiplomaDTO studentDiplomaDTO) {
        diplomas.add(studentDiplomaDTO);
        return studentDiplomaDTO;
    }

    public List<StudentDiplomaDTO> getDiplomas() {
        return diplomas;
    }
}
