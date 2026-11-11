package com.act3_t4.act3_t4.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.act3_t4.act3_t4.dto.DirectorDTO;
import com.act3_t4.act3_t4.services.DirectorService;

@Controller
@RequestMapping("/directores")
public class DirectorViewController {

    private final DirectorService directorService;

    public DirectorViewController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("directores", directorService.listarTodos());
        return "directores";
    }

    @GetMapping("/formdir")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("directorDTO", new DirectorDTO());
        return "directoresform";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<DirectorDTO> directorOpt = directorService.obtenerPorId(id);
        if (directorOpt.isPresent()) {
            model.addAttribute("directorDTO", directorOpt.get());
            return "directoresform";
        }
        return "redirect:/directores";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("directorDTO") DirectorDTO dto) {
        directorService.guardar(dto);
        return "redirect:/directores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        directorService.eliminar(id);
        return "redirect:/directores";
    }
}