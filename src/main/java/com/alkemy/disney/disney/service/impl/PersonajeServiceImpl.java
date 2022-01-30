package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.PersonajeDTO;

import com.alkemy.disney.disney.dto.PersonajeFiltersDTO;
import com.alkemy.disney.disney.entity.Personaje;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.repository.specification.PersonajeSpecification;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    private PersonajeSpecification personajeSpecification;

    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto){
        Personaje entity = personajeMapper.personajeDTO2Entity(dto);
        Personaje entitySaved = personajeRepository.save(entity);
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entitySaved,false);
        return result;
    }

    public PersonajeDTO getDetailsById(Long id){
        Optional<Personaje> entity = this.personajeRepository.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound("Id Personaje no valido");
        }
        PersonajeDTO personajeDTO = this.personajeMapper.personajeEntity2DTO(entity.get(), true);
        return personajeDTO;
    }

    public List<PersonajeDTO> getAllPersonajes() {
        List<Personaje> entities = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeEntityList2DTOList(entities,false);

        return result;
    }

    public List<PersonajeDTO> getByFilters(String nombre, String edad, Set<Long> peliculas, String order){
        PersonajeFiltersDTO filtersDTO = new PersonajeFiltersDTO(nombre,edad,peliculas,order);
        List<Personaje> entities = this.personajeRepository.findAll(this.personajeSpecification.getByFilters(filtersDTO));
        List<PersonajeDTO>dtos = this.personajeMapper.personajeEntityList2DTOList(entities,true);
        return dtos;
    }

    public void delete(Long id){
        this.personajeRepository.deleteById(id);
    }


}
