package com.example.parcial.demo.controllers;

import com.example.parcial.demo.model.Estudiante;
import com.example.parcial.demo.model.Practica;
import com.example.parcial.demo.responses.ResponseHandler;
import com.example.parcial.demo.services.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/practicas")
@CrossOrigin(origins = "http://localhost:4200")
public class PracticaController {

    @Autowired
    private PracticaService practicaService;

    @GetMapping
    public ResponseEntity findAll() {
        try {
            List<Practica> response = practicaService.findAll(); // Aquí podrías ajustar para obtener todas si es necesario
            return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Practica practica = practicaService.getPracticaPorId(id);
            if (practica != null) {
                return ResponseEntity.ok(practica); // Devuelve 200 OK con la práctica encontrada
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Practica not found"); // Devuelve 404 NOT FOUND con mensaje
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error"); // Devuelve 500 INTERNAL SERVER ERROR con mensaje
        }
    }

    @PostMapping("/{idDocente}")
    public ResponseEntity<Object> save(@RequestBody Practica practica, @PathVariable Integer idDocente) {
        try {
            Practica result = practicaService.saveOrUpdatePractica(practica, idDocente);
            if (result != null) {
                return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
            }
            return ResponseHandler.generateResponse("Error Saving Practica", HttpStatus.BAD_REQUEST, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        try {
            practicaService.deletePractica(id);
            return ResponseHandler.generateResponse("Success Deleted", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Object> findEstudiantesByPracticaId(@PathVariable Integer id) {
        try {
            List<Estudiante> estudiantes = practicaService.getEstudiantesPorPracticaId(id);
            if (estudiantes != null) {
                return ResponseEntity.ok(estudiantes); // Devuelve 200 OK con la lista de estudiantes
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Estudiantes not found"); // Devuelve 404 NOT FOUND con mensaje
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error"); // Devuelve 500 INTERNAL SERVER ERROR con mensaje
        }
    }

    @GetMapping("/periodo")
    public ResponseEntity<Object> findByPeriodo(@RequestParam Date inicio, @RequestParam Date fin) {
        try {
            List<Practica> response = practicaService.getPracticasPorPeriodo(inicio, fin);
            return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
