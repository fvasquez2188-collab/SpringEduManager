package com.example.SpringEduManager.repository;

import com.example.SpringEduManager.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}