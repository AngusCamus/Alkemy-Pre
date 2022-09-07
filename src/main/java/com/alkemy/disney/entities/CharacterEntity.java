package com.alkemy.disney.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
@SQLDelete(sql= "UPDATE characters SET deleted = true WHERE char_id=?")
@Where(clause= "deleted=false")
@Table(name="characters")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="char_id")
    private Long id;
    private String image;
    private String name;
    @Positive
    private Integer age;
    @Positive
    private Integer weight;
    @Length(max = 200)
    private String history;
    private boolean deleted = Boolean.FALSE;


    @ManyToMany(mappedBy = "characters")
    private Set<MovieEntity> movies = new HashSet<>();


}
