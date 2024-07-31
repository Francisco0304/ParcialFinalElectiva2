package com.example.parcial.demo.services;

import com.example.parcial.demo.model.Docente;
import com.example.parcial.demo.model.Estudiante;
import com.example.parcial.demo.model.Practica;
import com.example.parcial.demo.repositories.DocenteRepository;
import com.example.parcial.demo.repositories.PracticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;
    @Autowired
    private DocenteRepository docenteRepository;

    /**
     * Obtiene todas las prácticas de un docente basado en su número de identificación.
     *
     * @param identificacion El número de identificación del docente.
     * @return Lista de prácticas asociadas con el docente.
     */
    public List<Practica> getPracticasPorDocente(String identificacion) {
        return practicaRepository.findByDocente_Identificacion(identificacion);
    }

    /**
     * Obtiene todas las prácticas que ocurren dentro de un periodo de fechas.
     *
     * @param inicio La fecha de inicio del periodo.
     * @param fin La fecha de fin del periodo.
     * @return Lista de prácticas dentro del periodo especificado.
     */
    public List<Practica> getPracticasPorPeriodo(Date inicio, Date fin) {
        return practicaRepository.findByFechaSalidaBetween(inicio, fin);
    }

    /**
     * Obtiene una práctica basada en su ID.
     *
     * @param id El ID de la práctica.
     * @return La práctica asociada con el ID, o null si no existe.
     */
    public Practica getPracticaPorId(Long id) {
        Optional<Practica> practica = practicaRepository.findById(id);
        return practica.orElse(null);
    }

    /**
     * Guarda o actualiza una práctica en el repositorio.
     *
     * @param practica La práctica a guardar o actualizar.
     * @return La práctica guardada o actualizada.
     */
    public Practica saveOrUpdatePractica(Practica practica, Integer docenteId) {
        Optional<Docente> docenteOpt = docenteRepository.findById(docenteId);
        if (docenteOpt.isPresent()) {
            Docente docente = docenteOpt.get();
            practica.setDocente( docente );
            docente.addPractica( practica );

            return practicaRepository.save(practica);
        } else {
            throw new RuntimeException("Docente not found");
        }
    }

    /**
     * Elimina una práctica basada en su ID.
     *
     * @param id El ID de la práctica a eliminar.
     */
    public void deletePractica(Long id) {
        practicaRepository.deleteById(id);
    }

    /**
     * Obtiene el listado de estudiantes que asisten a una práctica basada en su ID.
     *
     * @param id El ID de la práctica.
     * @return Lista de estudiantes que asisten a la práctica.
     */
    public List<Estudiante> getEstudiantesPorPracticaId(Long id) {
        Optional<Practica> practica = practicaRepository.findById(id);
        return practica.map(Practica::getEstudiantes).orElse(null);
    }
}

