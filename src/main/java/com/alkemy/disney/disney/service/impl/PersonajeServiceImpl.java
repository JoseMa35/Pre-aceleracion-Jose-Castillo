package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.PersonajeDTO;

import com.alkemy.disney.disney.entity.Personaje;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto){
        Personaje entity = personajeMapper.personajeDTO2Entity(dto);
        Personaje entitySaved = personajeRepository.save(entity);
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entitySaved);
        return result;
    }

    public List<PersonajeDTO> getAllPersonajes() {
        List<Personaje> entities = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeEntityList2DTOList(entities);

        return result;
    }
}
