package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.PeliculaSerieDTO;

import com.alkemy.disney.disney.entity.PeliculaSerie;
import com.alkemy.disney.disney.mapper.PeliculaSerieMapper;
import com.alkemy.disney.disney.repository.PeliculaSerieRepository;
import com.alkemy.disney.disney.service.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaSerieServiceImpl implements PeliculaSerieService {

    @Autowired
    private PeliculaSerieMapper peliculaSerieMapper;

    @Autowired
    private PeliculaSerieRepository peliculaSerieRepository;

    public PeliculaSerieDTO save(PeliculaSerieDTO dto){

        PeliculaSerie entity = peliculaSerieMapper.peliculaSerieDTO2Entity(dto);
        PeliculaSerie entitySaved = peliculaSerieRepository.save(entity);
        PeliculaSerieDTO result = peliculaSerieMapper.peliculaSerieEntity2DTO(entitySaved);
        System.out.println("Guardar PeliculaSerie");
        return result;
    }
}
