package org.iesvdm.peliculas_spring_data.repository;

import org.iesvdm.peliculas_spring_data.domain.Categoria;
import org.iesvdm.peliculas_spring_data.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

//extiende tipo de la clase y tipo del id
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
