package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String imagen;

    private Boolean delete = Boolean.FALSE;

    @ManyToMany(mappedBy = "generos", cascade = CascadeType.ALL)
    public List<PeliculaSerie> peliculaSeries= new ArrayList<>();

}
