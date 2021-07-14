package com.meli.integrationtest.controller;

import com.meli.integrationtest.dto.EmpregadoDTO;
import com.meli.integrationtest.entity.Empregado;
import com.meli.integrationtest.service.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpregadoController {

    private final EmpregadoService service;

    @Autowired
    public EmpregadoController(EmpregadoService service) {
        this.service = service;
    }

    @PostMapping("/empregado")
    public ResponseEntity<EmpregadoDTO> cadastroTeste(@RequestBody EmpregadoDTO empregadoDTO, UriComponentsBuilder uriBuilder) {
        Empregado empregado = EmpregadoDTO.convert(empregadoDTO);
        service.cadastra(empregado);
        URI uri = uriBuilder.path("/api/funcionario/{id}").buildAndExpand(empregado.getId()).toUri();
        return ResponseEntity.created(uri).body(EmpregadoDTO.convert(empregado));
    }

    @GetMapping("/empregado/{id}")
    public ResponseEntity<EmpregadoDTO> obtemEmpregado(@PathVariable long id) {
        Empregado empregado = service.get(id);
        return new ResponseEntity<>(EmpregadoDTO.convert(empregado), HttpStatus.OK);
    }

    @GetMapping("/empregados")
    public ResponseEntity<List<EmpregadoDTO>> listaEmpregados() {
        List<Empregado> empregados = service.list();
        return ResponseEntity.ok(EmpregadoDTO.convert(empregados));
    }
}
