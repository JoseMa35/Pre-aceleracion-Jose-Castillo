package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PeliculaSerieDTO;
import org.springframework.stereotype.Service;

@Service
public class PeliculasSerieService {

    public static PeliculaSerieDTO save(PeliculaSerieDTO dto){
        System.out.println("Guardar PeliculaSerie");
        return dto;
    }
}
