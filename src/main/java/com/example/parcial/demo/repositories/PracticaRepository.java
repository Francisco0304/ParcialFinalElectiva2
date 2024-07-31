package com.example.parcial.demo.repositories;

import com.example.parcial.demo.model.Practica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PracticaRepository extends JpaRepository<Practica, Integer> {
    List<Practica> findByDocente_Identificacion(String identificacion);
    List<Practica> findByFechaSalidaBetween(Date inicio, Date fin);
}