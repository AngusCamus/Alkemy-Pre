package com.alkemy.Alkemy.Challenge.Disney.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter@Getter
@Table(name="characters")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="char_id")
    private Long id;

    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String history;


    @ManyToMany(mappedBy = "characters")
    private Set<MovieEntity> movies = new HashSet<>();


}
