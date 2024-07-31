package com.example.parcial.demo.controllers;

import com.example.parcial.demo.model.Docente;
import com.example.parcial.demo.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/{identificacion}")
    public ResponseEntity<Docente> getDocenteByIdentificacion(@PathVariable String identificacion) {
        return docenteService.getDocenteByIdentificacion(identificacion)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Docente> createDocente(@RequestBody Docente docente) {
        Docente savedDocente = docenteService.createDocente(docente);
        return ResponseEntity.ok(savedDocente);
    }
}
