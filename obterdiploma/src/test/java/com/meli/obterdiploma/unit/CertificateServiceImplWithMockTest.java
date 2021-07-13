package com.meli.obterdiploma.unit;

import com.meli.obterdiploma.dto.StudentDTO;
import com.meli.obterdiploma.dto.StudentDiplomaDTO;
import com.meli.obterdiploma.dto.SubjectDTO;
import com.meli.obterdiploma.service.DiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CertificateServiceImplWithMockTest {
    @Test
    public void saveABuiltDiploma() {
        DiplomaService service = Mockito.mock(DiplomaService.class);
        StudentDTO studentDTO = new StudentDTO("Kamila Costa", Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 9.0)
        ));
        StudentDiplomaDTO expectedDiploma = new StudentDiplomaDTO("Sua média foi de 9.5",
                9.5, Collections.singletonList(studentDTO));

        when(service.saveDiploma(any())).thenReturn(expectedDiploma);
        when(service.listDiplomas()).thenReturn(Collections.singletonList(expectedDiploma));

        assertEquals(expectedDiploma, service.listDiplomas().get(0));
    }
}
