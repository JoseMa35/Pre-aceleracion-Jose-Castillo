package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PeliculaSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    private String titulo;

    private Boolean delete = Boolean.FALSE;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long clasificacion;//del 1 al 5

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(insertable = false, updatable = false )
    private Genero genero;


    @Column(name = "genero_id", nullable = false)
    private Long generoId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private Set<Genero> generos =new HashSet<>();

    @ManyToMany(mappedBy = "peliculaSeries", cascade = CascadeType.ALL)
    public List<Genero> generoList= new ArrayList<>();

}
