package com.example.parcial.demo.repositories;

import com.example.parcial.demo.model.Empresa;
import com.example.parcial.demo.model.Practica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    List<Empresa> findByPractica_Destino(String destino);
}