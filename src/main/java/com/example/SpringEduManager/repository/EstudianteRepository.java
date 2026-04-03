package com.example.SpringEduManager.repository;

import com.example.SpringEduManager.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Buscar estudiantes por curso
    List<Estudiante> findByCursoId(Long cursoId);
}