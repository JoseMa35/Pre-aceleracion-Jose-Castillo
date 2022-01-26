package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PeliculaSerieDTO;

import java.util.List;

public interface PeliculaSerieService {

    PeliculaSerieDTO save (PeliculaSerieDTO dto);
    List<PeliculaSerieDTO> getAllPeliculaSeries();
}
