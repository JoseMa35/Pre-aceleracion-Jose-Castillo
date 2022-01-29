package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    PersonajeDTO save(PersonajeDTO dto);
    List<PersonajeDTO> getAllPersonajes();
    void delete(Long id);

    //List<PersonajeDTO> getByFilters(String nombre, String edad, Set<Long> peliculas, String order);
}
