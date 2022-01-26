package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Personaje;
import org.springframework.stereotype.Component;

@Component
public class PersonajeMapper {

    public Personaje personajeDTO2Entity(PersonajeDTO dto){
        Personaje personajeEntity = new Personaje();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());

        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(Personaje entity){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());

        return dto;
    }

}
