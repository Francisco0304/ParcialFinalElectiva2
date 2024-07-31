package com.example.parcial.demo.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String numeroIdentificacion;

    @JoinTable(
            name = "Inscription", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "ref_student"), // Columna de la tabla intermedia que hace referencia a Student
            inverseJoinColumns = @JoinColumn(name = "ref_practica") // Columna de la tabla intermedia que hace referencia a Practica
    )
    @ManyToMany//(mappedBy = "Estudiante")
    private List<Practica> practicas;

    public Estudiante(Integer id, String nombre, String numeroIdentificacion) {
        this.id = id;
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Estudiante() {

    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
}