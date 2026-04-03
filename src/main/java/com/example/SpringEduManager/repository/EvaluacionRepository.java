package com.example.SpringEduManager.repository;

import com.example.SpringEduManager.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
}