package com.alkemy.disney.disney.repository.specification;

import com.alkemy.disney.disney.dto.PersonajeFiltersDTO;
import com.alkemy.disney.disney.entity.PeliculaSerie;
import com.alkemy.disney.disney.entity.Personaje;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
//import java.util.function.Predicate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
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

            if (!CollectionUtils.isEmpty(filtersDTO.getPeliculaSeries())){
                Join<PeliculaSerie, Personaje> join = root.join("peliculaSeries", JoinType.INNER);
                Expression<String> generosId = join.get("id");
                predicates.add(generosId.in(filtersDTO.getPeliculaSeries()));
            }
            // Remove duplicates
            query.distinct(true);

            //Order resolver
            String orderByFilter = "nombre";
            query.orderBy(
                    filtersDTO.isASC()?
                            criteriaBuilder.asc(root.get(orderByFilter)):
                            criteriaBuilder.desc(root.get(orderByFilter))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
