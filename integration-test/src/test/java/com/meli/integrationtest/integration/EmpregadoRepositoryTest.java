package com.meli.integrationtest.integration;

import com.meli.integrationtest.entity.Empregado;
import com.meli.integrationtest.repository.EmpregadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmpregadoRepositoryTest {

    @Autowired
    private EmpregadoRepository repository;

    @BeforeEach
    public void init() {
        repository.deleteAll();
    }

    @Test
    public void carregaEmpregadoComIdFornecido() {
        cadastraEmpregado();
        String nomeEsperado = "Joao";
        Empregado empregado = repository.findById(1);
        assertEquals(nomeEsperado, empregado.getNome());
    }

    private void cadastraEmpregado() {
        repository.save(new Empregado("Joao", "12345", new BigDecimal(5000)));
    }

}
