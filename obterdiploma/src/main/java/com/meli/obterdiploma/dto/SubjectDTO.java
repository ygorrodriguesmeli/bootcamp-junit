package com.meli.obterdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {
    @Size(min = 3, max = 50, message = "Nome deve possuir no mínimo 8 caracteres alfabéticos sem acentos")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Somente letras permitidas")
    private final String name;

    @DecimalMin(value = "0.0", message = "Nota mínima é 0")
    @DecimalMax(value = "10", message = "Nota máxima é 10")
    @Digits(integer = 2, fraction = 2, message = "Máximo de 2 digitos")
    private final Double note;

    public SubjectDTO(String name, Double note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public Double getNote() {
        return note;
    }
}
