package com.meli.obterdiploma.unit;

import com.meli.obterdiploma.dto.StudentDTO;
import com.meli.obterdiploma.dto.StudentDiplomaDTO;
import com.meli.obterdiploma.dto.SubjectDTO;
import com.meli.obterdiploma.service.DiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CertificateServiceImplTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void buildDiplomaForStudentWithNameAndThreeSubjects() {
        StudentDTO studentDTO = new StudentDTO("Kamila Costa", Arrays.asList(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Historia", 4.5)
        ));
        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void buildDiplomaForStudentWithoutNameAndThreeSubjects() {
        StudentDTO studentDTO = new StudentDTO("", Arrays.asList(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Historia", 4.5)
        ));
        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void buildDiplomaForStudentWithNameWithoutSubjects() {
        StudentDTO studentDTO = new StudentDTO("Kamila Costa", Collections.emptyList());
        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void buildDiploma() {
        StudentDTO studentDTO = new StudentDTO("Kamila Costa", Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 9.0)
        ));
        StudentDiplomaDTO expectedDiploma = new StudentDiplomaDTO("Sua média foi de 9.5",
                9.5, Collections.singletonList(studentDTO));

        DiplomaService service = Mockito.mock(DiplomaService.class);
        when(service.buildDiploma(any())).thenReturn(expectedDiploma);

        StudentDiplomaDTO diplomaDTO = service.buildDiploma(studentDTO);

        assertEquals(expectedDiploma, diplomaDTO);
    }

    @Test
    public void calculateAverage() {
        DiplomaService service = new DiplomaService();
        double expected = 9.5;

        double average = service.calculateAverage(Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 9.0)
        ));

        assertEquals(expected, average);
    }

}
