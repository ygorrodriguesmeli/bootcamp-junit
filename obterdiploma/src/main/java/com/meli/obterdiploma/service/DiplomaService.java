package com.meli.obterdiploma.service;

import com.meli.obterdiploma.dto.StudentDTO;
import com.meli.obterdiploma.dto.StudentDiplomaDTO;
import com.meli.obterdiploma.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DiplomaService {
    public StudentDiplomaDTO buildDiploma(StudentDTO studentDTO) {
        double average = calculateAverage(studentDTO.getSubjects());
        return new StudentDiplomaDTO("Sua média foi de " + average,
                average, Collections.singletonList(studentDTO));
    }

    public double calculateAverage(List<SubjectDTO> subjects) {
        double sum = 0;
        for(SubjectDTO subject : subjects) {
            sum += subject.getNote();
        }
        return sum / subjects.size();
    }
}
