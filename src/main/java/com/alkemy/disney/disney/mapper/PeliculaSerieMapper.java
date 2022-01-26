package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.PeliculaSerieDTO;
import com.alkemy.disney.disney.entity.PeliculaSerie;
import org.springframework.stereotype.Component;

@Component
public class PeliculaSerieMapper {

    public PeliculaSerie peliculaSerieDTO2Entity(PeliculaSerieDTO dto){

        PeliculaSerie peliculaSerieEntity = new PeliculaSerie();
        peliculaSerieEntity.setImagen(dto.getImagen());
        peliculaSerieEntity.setTitulo(dto.getTitulo());
        peliculaSerieEntity.setFechaCreacion(dto.getFechaCreacion());
        peliculaSerieEntity.setClasificacion(dto.getClasificacion());
        return peliculaSerieEntity;
    }
}
