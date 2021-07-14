package com.meli.integrationtest.dto;

import com.meli.integrationtest.entity.Empregado;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class EmpregadoDTO {
    private String nome;
    private String RG;
    private BigDecimal salarioAtual;

    public EmpregadoDTO(String nome, String RG, BigDecimal salarioAtual) {
        this.nome = nome;
        this.RG = RG;
        this.salarioAtual = salarioAtual;
    }

    public String getNome() {
        return nome;
    }

    public String getRG() {
        return RG;
    }

    public BigDecimal getSalarioAtual() {
        return salarioAtual;
    }

    public static Empregado convert(EmpregadoDTO dto) {
        return new Empregado(dto.getNome(), dto.getRG(), dto.getSalarioAtual());
    }

    public static EmpregadoDTO convert(Empregado empregado) {
        return new EmpregadoDTO(empregado.getNome(), empregado.getRG(), empregado.getSalarioAtual());
    }

    public static List<EmpregadoDTO> convert(List<Empregado> empregados) {
        return empregados.stream().map(empregado -> new EmpregadoDTO(
                empregado.getNome(), empregado.getRG(), empregado.getSalarioAtual()
        )).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "EmpregadoDTO{" +
                "nome='" + nome + '\'' +
                ", RG='" + RG + '\'' +
                ", salarioAtual=" + salarioAtual +
                '}';
    }

}
