package com.example.parcial.demo.repositories;

import com.example.parcial.demo.dtos.EstudianteDTO;
import com.example.parcial.demo.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    @Query("SELECT new com.example.parcial.demo.dtos.EstudianteDTO(nombre, numeroIdentificacion) FROM Estudiante ")
    public List<EstudianteDTO> getAllStudents();

    @Query("SELECT s FROM Estudiante s WHERE s.nombre LIKE CONCAT('%',:name, '%') ")
    public List<Estudiante> findByName( String name );
}