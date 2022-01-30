package com.alkemy.disney.disney.repository.specification;

import com.alkemy.disney.disney.dto.PersonajeFiltersDTO;
import com.alkemy.disney.disney.entity.Personaje;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
//import java.util.function.Predicate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Join;

public class PersonajeSpecification {

    public Specification<Personaje> getByFilters(PersonajeFiltersDTO filtersDTO){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getNombre())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%"
                        )
                );
            }

            if (StringUtils.hasLength(filtersDTO.getEdad())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("edad")),
                                "%" + filtersDTO.getEdad().toString() + "%"
                        )
                );
            }
            return null;
        };
    }
}
