package com.example.SpringEduManager.rest;

import com.example.SpringEduManager.model.Evaluacion;
import com.example.SpringEduManager.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionRestController {

    @Autowired
    private EvaluacionService service;

    @GetMapping
    public List<Evaluacion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Evaluacion obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Evaluacion crear(@RequestBody Evaluacion evaluacion) {
        return service.guardar(evaluacion);
    }

    @PutMapping("/{id}")
    public Evaluacion actualizar(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        evaluacion.setId(id);
        return service.guardar(evaluacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}