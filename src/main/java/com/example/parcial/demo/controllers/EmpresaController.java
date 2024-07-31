package com.example.parcial.demo.controllers;

import com.example.parcial.demo.model.Docente;
import com.example.parcial.demo.model.Empresa;
import com.example.parcial.demo.model.Practica;
import com.example.parcial.demo.responses.ResponseHandler;
import com.example.parcial.demo.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping()
    public ResponseEntity findAll(){
        try{
            List<Empresa> response = empresaService.findAll();

            return ResponseHandler.generateResponse("Success Ok", HttpStatus.OK,response);
        }catch( Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping("/{idPractica}")
    public ResponseEntity save(@RequestBody Empresa empresa, @PathVariable Integer idPractica) {
        try {
            Empresa result = empresaService.saveOrUpdateEmpresa(empresa, idPractica);
            if (result != null) {
                return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
            }
            return ResponseHandler.generateResponse("Error Saving Empresa", HttpStatus.BAD_REQUEST, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
