package com.meli.integrationtest.repository;

import com.meli.integrationtest.entity.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
    Empregado findById(long id);
}
