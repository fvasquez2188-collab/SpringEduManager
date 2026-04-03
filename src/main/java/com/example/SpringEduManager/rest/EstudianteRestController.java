package com.example.SpringEduManager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SpringEduManager.model.Estudiante;
import com.example.SpringEduManager.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    public List<Estudiante> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public void guardar(@RequestBody Estudiante e) {
        service.guardar(e);
    }
}