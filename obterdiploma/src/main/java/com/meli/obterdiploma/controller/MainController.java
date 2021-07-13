package com.meli.obterdiploma.controller;

import com.meli.obterdiploma.dto.StudentDTO;
import com.meli.obterdiploma.dto.StudentDiplomaDTO;
import com.meli.obterdiploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    private final DiplomaService service;

    @Autowired
    public MainController(DiplomaService service) {
        this.service = service;
    }

    @PostMapping("/analyzenotes")
    public ResponseEntity<StudentDiplomaDTO> analyzeNotes(@Valid @RequestBody StudentDTO studentDTO) {
        StudentDiplomaDTO diplomaDTO = service.buildDiploma(studentDTO);
        return new ResponseEntity<>(diplomaDTO, HttpStatus.CREATED);
    }

}
