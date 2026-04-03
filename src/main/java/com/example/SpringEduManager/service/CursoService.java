package com.example.SpringEduManager.service;

import com.example.SpringEduManager.model.Curso;
import com.example.SpringEduManager.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Curso obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}