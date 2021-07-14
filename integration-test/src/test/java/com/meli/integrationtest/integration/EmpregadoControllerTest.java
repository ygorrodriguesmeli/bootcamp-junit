package com.meli.integrationtest.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.integrationtest.dto.EmpregadoDTO;
import com.meli.integrationtest.repository.EmpregadoRepository;
import com.meli.integrationtest.service.EmpregadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class EmpregadoControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private EmpregadoService service;

    @Autowired
    private EmpregadoRepository repository;

    @BeforeEach
    private void init() {
        repository.deleteAll();
    }

    @Test
    public void cadastraUmEmpregado() throws Exception {
        EmpregadoDTO empregadoDTO = new EmpregadoDTO("Rodrigo", "123456", new BigDecimal(1000));
        String payload = mapper.writeValueAsString(empregadoDTO);
        mock.perform(post("/api/empregado").contentType("application/json").content(payload))
                .andExpect(status().isCreated());
    }

    @Test
    public void obtemUmEmpregado() throws Exception {
        cadastraEmpregado();
        mock.perform(get("/api/empregado/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Jose"));
    }

    private void cadastraEmpregado() {
        EmpregadoDTO empregadoDTO = new EmpregadoDTO("Jose", "23412", new BigDecimal(2500));
        service.cadastra(EmpregadoDTO.convert(empregadoDTO));
    }

}
