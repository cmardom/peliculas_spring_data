package org.iesvdm.peliculas_spring_data.repository;

import org.iesvdm.peliculas_spring_data.domain.Actor;
import org.iesvdm.peliculas_spring_data.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}