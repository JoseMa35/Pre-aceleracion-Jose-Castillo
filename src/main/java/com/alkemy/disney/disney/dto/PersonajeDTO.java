package com.alkemy.disney.disney.dto;
import com.alkemy.disney.disney.entity.PeliculaSerie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonajeDTO {
    private Long id;
    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;
    private List<PeliculaSerieDTO> peliculaSeries;
}
