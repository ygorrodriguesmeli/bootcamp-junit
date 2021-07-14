package com.meli.integrationtest.unit;

import com.meli.integrationtest.dto.EmpregadoDTO;
import com.meli.integrationtest.entity.Empregado;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpregadoDTOTest {

    @Test
    void converteEmpregadoDtoParaEmpregado() {
        Empregado empregado = new Empregado("Jose", "1234", new BigDecimal(1000));
        EmpregadoDTO empregadoDTO = new EmpregadoDTO("Jose", "1234", new BigDecimal(1000));
        assertEquals(empregado.toString(), EmpregadoDTO.convert(empregadoDTO).toString());
    }

    @Test
    void converteEmpregadoParaEmpregadoDto() {
        Empregado empregado = new Empregado("Jose", "1234", new BigDecimal(1000));
        EmpregadoDTO empregadoDTO = new EmpregadoDTO("Jose", "1234", new BigDecimal(1000));
        assertEquals(empregadoDTO.toString(), EmpregadoDTO.convert(empregado).toString());
    }

}
