package com.act3_t4.act3_t4.dto;

public class PeliculaDTO {

    private Long id;
    private String titulo;
    private String genero;
    private Integer anioEstreno;
    private Long directorId;
    private String nombreDirector;

    public PeliculaDTO() {}

    public PeliculaDTO(Long id, String titulo, String genero, Integer anioEstreno, Long directorId, String nombreDirector) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anioEstreno = anioEstreno;
        this.directorId = directorId;
        this.nombreDirector = nombreDirector;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getAnioEstreno() { return anioEstreno; }
    public void setAnioEstreno(Integer anioEstreno) { this.anioEstreno = anioEstreno; }

    public Long getDirectorId() { return directorId; }
    public void setDirectorId(Long directorId) { this.directorId = directorId; }

    public String getNombreDirector() { return nombreDirector; }
    public void setNombreDirector(String nombreDirector) { this.nombreDirector = nombreDirector; }
}