package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.GeneroDTO;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    public GeneroDTO save(GeneroDTO dto){
        //TODO guardar
        System.out.println("guardar genero");
        return dto;
    }

}
