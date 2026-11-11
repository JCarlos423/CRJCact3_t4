package com.act3_t4.act3_t4.services;


import org.springframework.stereotype.Service;

import com.act3_t4.act3_t4.dto.DirectorDTO;
import com.act3_t4.act3_t4.models.Director;
import com.act3_t4.act3_t4.repository.DirectorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<DirectorDTO> listarTodos() {
        return directorRepository.findAll()
                .stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    public DirectorDTO obtenerPorId(Long id) {
        return directorRepository.findById(id)
                .map(this::convertirADto)
                .orElse(null);
    }

    public DirectorDTO guardar(DirectorDTO dto) {
        Director director = convertirAEntidad(dto);
        Director guardado = directorRepository.save(director);
        return convertirADto(guardado);
    }

    private DirectorDTO convertirADto(Director director) {
        return new DirectorDTO(director.getId(), director.getNombre(), director.getNacionalidad());
    }

    private Director convertirAEntidad(DirectorDTO dto) {
        Director director = new Director();
        director.setId(dto.getId());
        director.setNombre(dto.getNombre());
        director.setNacionalidad(dto.getNacionalidad());
        return director;
    }
}