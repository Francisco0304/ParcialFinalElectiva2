package com.example.parcial.demo.controllers;

import com.example.parcial.demo.model.Docente;
import com.example.parcial.demo.model.Practica;
import com.example.parcial.demo.responses.ResponseHandler;
import com.example.parcial.demo.services.DocenteService;
import com.example.parcial.demo.services.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private PracticaService practicaService;

    @GetMapping()
    public ResponseEntity findAll(){
        try{
            List<Docente> response = docenteService.findAll();

            return ResponseHandler.generateResponse("Success Ok", HttpStatus.OK,response);
        }catch( Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<Docente> getDocenteByIdentificacion(@PathVariable String identificacion) {
        return docenteService.getDocenteByIdentificacion(identificacion)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Docente docente) {
        try{
            Docente result = docenteService.save( docente );

            return ResponseHandler.generateResponse("Success OK", HttpStatus.ACCEPTED,result);
        }catch( Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/{idDocente}/practicas")
    public ResponseEntity<Object> findPracticasByDocenteId(@PathVariable Integer idDocente) {
        try {
            List<Practica> practicas = docenteService.getPracticasPorDocenteId(idDocente);
            if (practicas != null && !practicas.isEmpty()) {
                return ResponseEntity.ok(practicas);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron prácticas para el docente con ID " + idDocente);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor");
        }
    }
}
