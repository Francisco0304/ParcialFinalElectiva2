package com.example.parcial.demo.services;

import com.example.parcial.demo.dtos.EstudianteDTO;
import com.example.parcial.demo.model.Estudiante;
import com.example.parcial.demo.model.Practica;
import com.example.parcial.demo.repositories.EstudianteRepository;
import com.example.parcial.demo.repositories.PracticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PracticaRepository practicaRepository; // Suponiendo que necesitas acceder a la tabla de prácticas

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public Estudiante findById(Integer id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public Estudiante save(Estudiante estudiante, Integer id) {
        return null;
    }

    public void deleteById(Integer id) {
        estudianteRepository.deleteById(id);
    }

    public List<EstudianteDTO> getAllEstudiantes() {
        return estudianteRepository.getAllStudents();
    }

    public List<Estudiante> findByName(String name) {
        return estudianteRepository.findByName( name );
    }
}
