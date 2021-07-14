package com.meli.integrationtest.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String RG;
    private BigDecimal salarioAtual;

    public Empregado() {
    }

    public Empregado(String nome, String RG, BigDecimal salarioAtual) {
        this.nome = nome;
        this.RG = RG;
        this.salarioAtual = salarioAtual;
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", RG='" + RG + '\'' +
                ", salarioAtual=" + salarioAtual +
                '}';
    }
}
