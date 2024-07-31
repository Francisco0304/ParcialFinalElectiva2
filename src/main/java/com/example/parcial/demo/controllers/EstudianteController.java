package com.example.parcial.demo.controllers;

import com.example.parcial.demo.dtos.EstudianteDTO;
import com.example.parcial.demo.model.Estudiante;
import com.example.parcial.demo.responses.ResponseHandler;
import com.example.parcial.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        try {
            List<Estudiante> response = estudianteService.findAll();
            return ResponseHandler.generateResponse("Success Ok", HttpStatus.FOUND, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Estudiante estudiante = estudianteService.findById(id);
            if (estudiante != null) {
                return ResponseHandler.generateResponse("Success OK", HttpStatus.FOUND, estudiante);
            } else {
                return ResponseHandler.generateResponse("Not Found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
        try {
            Estudiante result = estudianteService.save(estudiante, id);
            if (result != null) {
                return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
            }
            return ResponseHandler.generateResponse("NOT EXISTS Practice", HttpStatus.NOT_FOUND, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            estudianteService.deleteById(id);
            return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllEstudiantes() {
        try {
            List<EstudianteDTO> result = estudianteService.getAllEstudiantes();
            return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name) {
        try {
            List<Estudiante> result = estudianteService.findByName(name);
            return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}