package org.iesvdm.peliculas_spring_data.repository;

import org.iesvdm.peliculas_spring_data.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
