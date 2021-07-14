package com.meli.integrationtest.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.integrationtest.dto.EmpregadoDTO;
import com.meli.integrationtest.repository.EmpregadoRepository;
import com.meli.integrationtest.service.EmpregadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
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
    public void deveCadastrarUmEmpregado() throws Exception {
        EmpregadoDTO empregadoDTO = new EmpregadoDTO("Rodrigo", "123456", new BigDecimal(1000));
        String payload = mapper.writeValueAsString(empregadoDTO);
        mock.perform(post("/api/empregado").contentType("application/json").content(payload))
                .andExpect(status().isCreated());
    }

    public long efetuaCadastro() {
        EmpregadoDTO empregadoDTO = new EmpregadoDTO("Jose", "23412", new BigDecimal(2500));
        return service.cadastra(EmpregadoDTO.convert(empregadoDTO));
    }

    @Test
    public void deveObterUmEmpregado() throws Exception {
        long id = efetuaCadastro();
        mock.perform(get("/api/empregado/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Jose"));
    }

    @Test
    public void deveListarEmpregados() throws Exception {
        efetuaCadastro();
        efetuaCadastro();
        efetuaCadastro();
        mock.perform(get("/api/empregados"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].nome").value("Jose"));
    }
}
