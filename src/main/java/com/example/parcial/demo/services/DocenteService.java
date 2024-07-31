package com.example.parcial.demo.services;

import com.example.parcial.demo.model.Docente;
import com.example.parcial.demo.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {
    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> findAll(){

        return docenteRepository.findAll();
    }

    public Optional<Docente> getDocenteByIdentificacion(String identificacion) {
        return docenteRepository.findByIdentificacion(identificacion);
    }

    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    public Docente createDocente(Docente docente) {
        return docenteRepository.save(docente);
    }
}