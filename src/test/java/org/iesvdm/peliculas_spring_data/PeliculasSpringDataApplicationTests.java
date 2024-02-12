package org.iesvdm.peliculas_spring_data;

import org.iesvdm.peliculas_spring_data.domain.Categoria;
import org.iesvdm.peliculas_spring_data.domain.Idioma;
import org.iesvdm.peliculas_spring_data.domain.Pelicula;
import org.iesvdm.peliculas_spring_data.repository.CategoriaRepository;
import org.iesvdm.peliculas_spring_data.repository.IdiomaRepository;
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

    @Autowired
    IdiomaRepository idiomaRepository;
    @Test
    void contextLoads() {
    }


    @Test
    void guardarManyToMany(){
        Pelicula pelicula1 = new Pelicula(0, "peli1", new HashSet<>(), null);
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


    @Test
    void guardarManyToOne(){
        Pelicula pelicula1 = new Pelicula(0, "peli1", new HashSet<>(), null);
        peliculaRepository.save(pelicula1);


        Idioma idioma = new Idioma(0, "inglés", new HashSet<>());
        idioma.getPeliculas().add(pelicula1);
        idiomaRepository.save(idioma);


        pelicula1.setIdioma(idioma);
        peliculaRepository.save(pelicula1);




    }


}
