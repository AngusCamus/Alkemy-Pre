package com.alkemy.disney.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter@Setter
@Table(name= "genres")
public class GenreEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genre_id")
    private Long id;

    private String name;
    private String image;
    @OneToMany(mappedBy = "genre")
    private List<MovieEntity> movies;


    
}


