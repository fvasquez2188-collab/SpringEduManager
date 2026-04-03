package com.example.SpringEduManager.service;

import com.example.SpringEduManager.model.Evaluacion;
import com.example.SpringEduManager.repository.EvaluacionRepository;
import com.example.SpringEduManager.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository repository;

    public List<Evaluacion> listar() {
        return repository.findAll();
    }

    public Evaluacion guardar(Evaluacion evaluacion) {
        return repository.save(evaluacion);
    }

    public Evaluacion obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}