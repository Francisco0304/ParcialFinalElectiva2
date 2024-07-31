package com.example.parcial.demo.repositories;

import com.example.parcial.demo.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
    Optional<Docente> findByIdentificacion(String identificacion);


}
