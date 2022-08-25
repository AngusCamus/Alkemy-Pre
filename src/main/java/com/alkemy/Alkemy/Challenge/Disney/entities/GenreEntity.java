package com.alkemy.Alkemy.Challenge.Disney.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter@Setter
@Table(name= "genres")
public class GenreEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="genre_id")
    private Long id;

    private String name;
    private String image;

    private List<MovieEntity> movies;


    public void addMovie (MovieEntity entity){
        movies.add(entity);
    }

    public void delMovie (MovieEntity entity){
        movies.remove(entity);
    }
}


