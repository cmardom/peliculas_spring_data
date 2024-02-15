package org.iesvdm.peliculas_spring_data.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String titulo;

    @ManyToMany
    @JoinTable(
            name = "pelicula_categoria",
            joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "id_categoria", referencedColumnName = "id")
    )
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToOne
    private Idioma idioma;

    @ManyToMany
    @JoinTable(
            name ="pelicula_actor",
            joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "id_actor", referencedColumnName = "id")
    )
    private Set<Actor> actores = new HashSet<>();
}
