package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.PersonajeDTO;

import com.alkemy.disney.disney.entity.Personaje;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    public PersonajeDTO save(PersonajeDTO dto){
        Personaje entity = personajeMapper.personajeDTO2Entity(dto);
        return dto;
    }
}
