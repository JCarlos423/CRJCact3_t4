package com.act3_t4.act3_t4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.act3_t4.act3_t4.dto.PeliculaDTO;
import com.act3_t4.act3_t4.services.DirectorService;
import com.act3_t4.act3_t4.services.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaViewController {

    private final PeliculaService peliculaService;
    private final DirectorService directorService;

    public PeliculaViewController(PeliculaService peliculaService, DirectorService directorService) {
        this.peliculaService = peliculaService;
        this.directorService = directorService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("peliculas", peliculaService.listarTodas());
        model.addAttribute("directores", directorService.listarTodos());
        model.addAttribute("peliculaDTO", new PeliculaDTO());
        return "peliculas";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("peliculaDTO") PeliculaDTO dto) {
        peliculaService.guardar(dto);
        return "redirect:/peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return "redirect:/peliculas";
    }
}