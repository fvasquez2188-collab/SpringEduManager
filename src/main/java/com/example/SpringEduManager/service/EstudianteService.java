package com.example.SpringEduManager.service;

import com.example.SpringEduManager.model.Estudiante;
import com.example.SpringEduManager.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // 📋 LISTAR TODOS
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    // 🔍 OBTENER POR ID
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Estudiante obtenerPorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    // 💾 GUARDAR
    @PreAuthorize("hasRole('ADMIN')")
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // ❌ ELIMINAR
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }

    // 📚 LISTAR POR CURSO
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Estudiante> listarPorCurso(Long cursoId) {
        return estudianteRepository.findByCursoId(cursoId);
    }

	public Estudiante buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return estudianteRepository.findById(id).orElse(null);
	}
}