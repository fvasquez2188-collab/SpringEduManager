package com.example.SpringEduManager.controller;

import com.example.SpringEduManager.model.Curso;
import com.example.SpringEduManager.model.Estudiante;
import com.example.SpringEduManager.service.CursoService;
import com.example.SpringEduManager.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService cursoService;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        return "estudiantes";
    }

    // NUEVO
    @GetMapping("/nuevo")
    public String nuevo(@RequestParam(required = false) Long cursoId, Model model) {
        Estudiante estudiante = new Estudiante();

        if (cursoId != null) {
            Curso curso = cursoService.obtenerPorId(cursoId);
            estudiante.setCurso(curso);
        }

        model.addAttribute("estudiante", estudiante);
        model.addAttribute("cursos", cursoService.listarTodos());
        return "form-estudiante";
    }
    // EDITAR 
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteService.buscarPorId(id);
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("cursos", cursoService.listarTodos());
        return "form-estudiante";
    }
    

    // GUARDAR (sirve para crear y editar)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Estudiante estudiante) {
        estudianteService.guardar(estudiante);
        return "redirect:/estudiantes";
    }
    //ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return "redirect:/estudiantes";
    }
}
    