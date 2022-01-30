package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PersonajeFiltersDTO {

    private String nombre;
    private String edad;
    private Set<Long> peliculaSeries;
    private String order;

    public PersonajeFiltersDTO(String nombre, String edad, Set<Long>peliculaSeries, String order){
        this.nombre = nombre;
        this.edad = edad;
        this.peliculaSeries = peliculaSeries;
        this.order = order;

    }
    public boolean isASC(){ return this.order.compareToIgnoreCase("ASC")==0;}
    public boolean isDESC(){return this.order.compareToIgnoreCase("DESD")==0;}

}
