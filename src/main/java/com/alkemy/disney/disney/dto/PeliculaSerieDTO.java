package com.alkemy.disney.disney.dto;

import com.alkemy.disney.disney.entity.Genero;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class PeliculaSerieDTO {

    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
    private Long clasificacion;
    private Genero genero;
    private Long generoId;
    private List<GeneroDTO> generos;
}
