package org.iesvdm.peliculas_spring_data;

import org.iesvdm.peliculas_spring_data.domain.Categoria;
import org.iesvdm.peliculas_spring_data.domain.Pelicula;
import org.iesvdm.peliculas_spring_data.repository.CategoriaRepository;
import org.iesvdm.peliculas_spring_data.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class PeliculasSpringDataApplicationTests {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;
    @Test
    void contextLoads() {
    }


    @Test
    void guardarManyToMany(){
        Pelicula pelicula1 = new Pelicula(0, "peli1", new HashSet<>());
        peliculaRepository.save(pelicula1);

        Categoria categoria = new Categoria(0, "categoria1", new HashSet<>());
        categoriaRepository.save(categoria);

        Categoria categoria2 = new Categoria(0, "categoria2", new HashSet<>());
        categoriaRepository.save(categoria2);

        pelicula1.getCategorias().add(categoria);
        categoria.getPeliculas().add(pelicula1);
        pelicula1.getCategorias().add(categoria2);
        categoria2.getPeliculas().add(pelicula1);

        categoriaRepository.save(categoria);
        categoriaRepository.save(categoria2);
        peliculaRepository.save(pelicula1);



    }

}
