package com.example.parcial.demo.controllers;

import com.example.parcial.demo.model.Empresa;
import com.example.parcial.demo.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/{identificacion}")
    public ResponseEntity<Empresa> getEmpresaByIdentificacion(@PathVariable String identificacion) {
        Optional<Empresa> empresa = empresaService.getEmpresaByIdentificacion(identificacion);
        return empresa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        Empresa savedEmpresa = empresaService.createEmpresa(empresa);
        return ResponseEntity.ok(savedEmpresa);
    }
}
