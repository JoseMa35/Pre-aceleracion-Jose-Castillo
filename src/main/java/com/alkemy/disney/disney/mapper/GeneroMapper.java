package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GeneroBasicDTO;
import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.dto.PeliculaSerieDTO;
import com.alkemy.disney.disney.entity.Genero;
import com.alkemy.disney.disney.entity.PeliculaSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    @Autowired
    private PeliculaSerieMapper peliculaSerieMapper;

    public Genero generoDTO2Entity(GeneroDTO dto){
        Genero generoEntity = new Genero();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(Genero entity,boolean loadPeliculaSeries){
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        if (loadPeliculaSeries){
            List<PeliculaSerieDTO> peliculaSerieDTOS = this.peliculaSerieMapper.peliculaSerieEntityList2DTOList(entity.getPeliculaSeries(),false);
            dto.setPeliculaSeries(peliculaSerieDTOS);
        }
        return dto;
    }
    public List<GeneroDTO> generoEntityList2DTOList(List<Genero> entities, boolean loadPelicuaSeries){
        List<GeneroDTO> dtos = new ArrayList<>();
        for (Genero entity : entities){
                dtos.add(this.generoEntity2DTO(entity,loadPelicuaSeries));
        }
        return dtos;
    }

    public List<GeneroBasicDTO> generoEntitySet2BasicDTOList(List<Genero> entities) {
        List<GeneroBasicDTO> dtos = new ArrayList<>();
        GeneroBasicDTO basicDTO;
        for (Genero entity : entities){
            basicDTO = new GeneroBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setNombre(entity.getNombre());
        }
        return dtos;
    }
}
