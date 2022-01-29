package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.PeliculaSerieDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonajeMapper {

    @Autowired
    private PeliculaSerieMapper peliculaSerieMapper;

    public Personaje personajeDTO2Entity(PersonajeDTO dto){
        Personaje personajeEntity = new Personaje();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());

        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(Personaje entity, boolean loadPeliculaSeries){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        if(loadPeliculaSeries){
            List<PeliculaSerieDTO> peliculaSerieDTOS = this.peliculaSerieMapper.peliculaSerieEntityList2DTOList(entity.getPeliculaSeries().stream().collect(Collectors.toList()), false);
            dto.setPeliculaSeries(peliculaSerieDTOS);
        }

        return dto;
    }
    public List<PersonajeDTO> personajeEntityList2DTOList(List<Personaje> entities){
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (Personaje entity : entities){
            dtos.add(this.personajeEntity2DTO(entity,false));
        }
        return dtos;
    }

}
