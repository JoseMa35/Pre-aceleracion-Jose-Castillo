package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.entity.Genero;
import com.alkemy.disney.disney.repository.GeneroRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public Genero generoDTO2Entity(GeneroDTO dto){
        Genero generoEntity = new Genero();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(Genero entity){
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());

        return dto;
    }
    public List<GeneroDTO> generoEntityList2DTOList(List<Genero> entities){
        List<GeneroDTO> dtos = new ArrayList<>();
        for (Genero entity : entities){
                dtos.add(this.generoEntity2DTO(entity));
        }
        return dtos;
    }
}
