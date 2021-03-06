package com.alkemy.disney.disney.controller;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RequestMapping("personajes")
@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

   public ResponseEntity<List<PersonajeDTO>> getDetailsByFilters(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String edad,
            @RequestParam(required = false) Set<Long> peliculas,
            @RequestParam(required = false,defaultValue = "ASC") String order
    ){
        List<PersonajeDTO> personajes = this.personajeService.getByFilters(nombre,edad,peliculas,order);
        return ResponseEntity.ok(personajes);
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        List<PersonajeDTO> personajes = personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajes);
    }

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje){
        PersonajeDTO personajeGuardado = personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaje);
    }
}
