package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PeliculaSerieDTO;
import com.alkemy.disney.disney.service.PeliculaSerieService;
import com.alkemy.disney.disney.service.impl.PeliculaSerieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peliculaSeries")
public class PeliculaSerieController {

    @Autowired
    private PeliculaSerieService peliculaSerieService;

    @GetMapping
    public ResponseEntity<List<PeliculaSerieDTO>> getAll(){
        List<PeliculaSerieDTO> peliculaSeries = peliculaSerieService.getAllPeliculaSeries();
        return ResponseEntity.ok().body(peliculaSeries);
    }

    @PostMapping
    public ResponseEntity<PeliculaSerieDTO> save(@RequestBody PeliculaSerieDTO peliculaSerie){

        PeliculaSerieDTO peliculaSerieGuardado = peliculaSerieService.save(peliculaSerie);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSerie);
    }


}
