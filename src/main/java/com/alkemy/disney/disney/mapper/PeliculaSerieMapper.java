package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.dto.PeliculaSerieDTO;
import com.alkemy.disney.disney.entity.Genero;
import com.alkemy.disney.disney.entity.PeliculaSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PeliculaSerieMapper {


    @Autowired
    private GeneroMapper generoMapper;

    public PeliculaSerie peliculaSerieDTO2Entity(PeliculaSerieDTO dto){

        PeliculaSerie peliculaSerieEntity = new PeliculaSerie();
        peliculaSerieEntity.setImagen(dto.getImagen());
        peliculaSerieEntity.setTitulo(dto.getTitulo());
        peliculaSerieEntity.setFechaCreacion(dto.getFechaCreacion());
        peliculaSerieEntity.setClasificacion(dto.getClasificacion());
        return peliculaSerieEntity;
    }
    public PeliculaSerieDTO peliculaSerieEntity2DTO(PeliculaSerie entity, boolean loadGeneros){
        PeliculaSerieDTO dto = new PeliculaSerieDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setClasificacion(entity.getClasificacion());

        if(loadGeneros){

            List<GeneroDTO> generoDTOS = this.generoMapper.generoEntityList2DTOList(entity.getGeneros().stream().collect(Collectors.toList()),false);
            dto.setGeneros(generoDTOS);
        }
        return dto;
    }

    public List<PeliculaSerieDTO> peliculaSerieEntityList2DTOList(List<PeliculaSerie> entities,boolean loadGeneros){
        List<PeliculaSerieDTO> dtos = new ArrayList<>();
        for (PeliculaSerie entity : entities){
            dtos.add(this.peliculaSerieEntity2DTO(entity,false));
        }
        return dtos;
    }
}
