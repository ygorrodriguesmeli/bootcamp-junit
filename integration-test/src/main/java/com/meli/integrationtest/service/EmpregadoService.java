package com.meli.integrationtest.service;

import com.meli.integrationtest.entity.Empregado;
import com.meli.integrationtest.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregadoService {

    private EmpregadoRepository repository;

    @Autowired
    public EmpregadoService(EmpregadoRepository repository) {
        this.repository = repository;
    }

    public void cadastra(Empregado empregado) {
        repository.save(empregado);
    }

    public Empregado get(long id) {
        return repository.findById(id);
    }

    public List<Empregado> list() {
        return repository.findAll();
    }
}
