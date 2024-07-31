package com.example.parcial.demo.services;

import com.example.parcial.demo.model.Docente;
import com.example.parcial.demo.model.Empresa;
import com.example.parcial.demo.model.Practica;
import com.example.parcial.demo.repositories.EmpresaRepository;
import com.example.parcial.demo.repositories.PracticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PracticaRepository practicaRepository;

    public List<Empresa> findAll(){

        return empresaRepository.findAll();
    }

    public Optional<Empresa> getEmpresaByIdentificacion(String identificacion) {
        return empresaRepository.findByIdentificacion(identificacion);
    }

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa saveOrUpdateEmpresa(Empresa empresa, Integer practicaId) {
        Optional<Practica> practicaOpt = practicaRepository.findById(practicaId);

        if (practicaOpt.isPresent()) {
            Practica practica = practicaOpt.get();

            empresa.setPractica(practica); // Asocia la practica a la empresa
            practica.addEmpresa(empresa); // Asocia la empresa a la practica

            // Guarda la empresa (la practica también puede necesitar guardarse si ha cambiado)
            Empresa savedEmpresa = empresaRepository.save(empresa);
            practicaRepository.save(practica); // Asegúrate de guardar la practica si ha cambiado

            return savedEmpresa;
        } else {
            throw new RuntimeException("Practica not found");
        }
    }

}
