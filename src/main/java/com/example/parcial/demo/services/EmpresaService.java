package com.example.parcial.demo.services;

import com.example.parcial.demo.model.Empresa;
import com.example.parcial.demo.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Optional<Empresa> getEmpresaByIdentificacion(String identificacion) {
        return empresaRepository.findByIdentificacion(identificacion);
    }

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
