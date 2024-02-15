package org.iesvdm.peliculas_spring_data;

import org.iesvdm.peliculas_spring_data.domain.Actor;
import org.iesvdm.peliculas_spring_data.domain.Categoria;
import org.iesvdm.peliculas_spring_data.domain.Idioma;
import org.iesvdm.peliculas_spring_data.domain.Pelicula;
import org.iesvdm.peliculas_spring_data.repository.ActorRepository;
import org.iesvdm.peliculas_spring_data.repository.CategoriaRepository;
import org.iesvdm.peliculas_spring_data.repository.IdiomaRepository;
import org.iesvdm.peliculas_spring_data.repository.PeliculaRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.HashSet;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PeliculasSpringDataApplicationTests {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    IdiomaRepository idiomaRepository;

    @Autowired
    ActorRepository actorRepository;

    @Test
    void contextLoads() {
    }


    @Order(1)
    @Test
    void guardarManyToMany(){
        Pelicula pelicula1 = new Pelicula(0, "peli2", new HashSet<>(), null, new HashSet<>());
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


    @Order(2)
    @Test
    void guardarManyToManyPeliculaIdioma(){
        Pelicula pelicula2 = new Pelicula(0, "peli2", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula2);

        Idioma idioma = new Idioma(0, "inglés", new HashSet<>());
        idioma.getPeliculas().add(pelicula2);
        idiomaRepository.save(idioma);

        pelicula2.setIdioma(idioma);
        peliculaRepository.save(pelicula2);

    }

    @Order(3)
    @Test
    void guardarManyToManyPeliculaActor(){
        Pelicula pelicula3 = new Pelicula(0, "peli1", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula3);

        Actor actor = new Actor(0, null, new HashSet<>());
        actor.getPeliculas().add(pelicula3);
        actorRepository.save(actor);

        pelicula3.getActores().add(actor);
        peliculaRepository.save(pelicula3);

    }



}
