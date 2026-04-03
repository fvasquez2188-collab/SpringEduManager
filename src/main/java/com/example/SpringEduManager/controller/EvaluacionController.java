package com.example.SpringEduManager.controller;

import com.example.SpringEduManager.model.Evaluacion;
import com.example.SpringEduManager.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService service;

    @GetMapping
    public String listar(Model model) {
        List<Evaluacion> evaluaciones = service.listar();
        model.addAttribute("evaluaciones", evaluaciones);
        return "evaluaciones";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("evaluacion", new Evaluacion());
        return "form-evaluacion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Evaluacion evaluacion) {
        service.guardar(evaluacion);
        return "redirect:/evaluaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/evaluaciones";
    }
}