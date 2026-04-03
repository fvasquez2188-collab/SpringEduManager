package com.example.SpringEduManager.controller;

import com.example.SpringEduManager.model.Curso;
import com.example.SpringEduManager.service.CursoService;
import com.example.SpringEduManager.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudianteService estudianteService;

    // 📋 LISTAR CURSOS
    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.listarTodos();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }

    // ➕ FORMULARIO NUEVO CURSO
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("curso", new Curso());
        return "form-curso";
    }

    // 💾 GUARDAR CURSO
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Curso curso) {
        cursoService.guardar(curso);
        return "redirect:/cursos";
    }

    // 👁 VER DETALLE DEL CURSO + ESTUDIANTES
    @GetMapping("/{id}")
    public String verCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoService.obtenerPorId(id);

        if (curso == null) {
            return "redirect:/cursos"; // evita error si no existe
        }

        model.addAttribute("curso", curso);
        model.addAttribute("estudiantes", estudianteService.listarPorCurso(id));

        return "curso-detalle";
    }

    // 🗑 ELIMINAR CURSO
    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Long id) {
        cursoService.eliminar(id);
        return "redirect:/cursos?eliminado";
    }
}