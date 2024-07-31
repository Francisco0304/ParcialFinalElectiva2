package com.example.parcial.demo.repositories;

import com.example.parcial.demo.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}