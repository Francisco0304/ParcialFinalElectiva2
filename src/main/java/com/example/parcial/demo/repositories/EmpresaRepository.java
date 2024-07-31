package com.example.parcial.demo.repositories;

import com.example.parcial.demo.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}