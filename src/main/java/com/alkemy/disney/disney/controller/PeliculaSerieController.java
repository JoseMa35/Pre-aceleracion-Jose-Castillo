package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PeliculaSerieDTO;
import com.alkemy.disney.disney.service.PeliculasSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("peliculaSeries")
public class PeliculaSerieController {

    @Autowired
    private PeliculasSerieService peliculasSerieService;

    @PostMapping
    public ResponseEntity<PeliculaSerieDTO> save(@RequestBody PeliculaSerieDTO peliculaSerie){

        PeliculaSerieDTO peliculaSerieGuardado = PeliculasSerieService.save(peliculaSerie);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSerie);
    }


}
