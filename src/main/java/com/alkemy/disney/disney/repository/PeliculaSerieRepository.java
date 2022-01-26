package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.entity.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie,Long> {
}
