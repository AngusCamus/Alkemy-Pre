package com.alkemy.disney.entities;


import com.alkemy.disney.exception.EnumErrors;
import com.alkemy.disney.exception.ParamNotFound;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SQLDelete(sql= "UPDATE movies SET deleted = true WHERE movie_id=?")
@Where(clause= "deleted=false")
@Table(name="movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "movie_id")
    private Long id;
    @Length(max = 30)
    private String title;
    private String image;
    @DateTimeFormat
    @Column(name="fecha_creacion")
    private LocalDate creationDate;

    @Range(min=1, max=5)
    private Integer rating;
    private boolean deleted = Boolean.FALSE;


    @ManyToMany
    @JoinTable(name= "movies_chars",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "char_id")
    )
    private Set<CharacterEntity> characters = new HashSet<>();



    @ManyToOne
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private GenreEntity genre;

    @Column(name = "genre_id")
    private Long genreId;


    public void addCharacter (CharacterEntity entity) {
        if (characters.contains(entity)) {
            throw new ParamNotFound(EnumErrors.CHARACTER_IN_MOVIE.getErrorMessage());
        } else {
            characters.add(entity);
        }

    }

    public void addCharacters(Set<CharacterEntity> charactersSet) {
        characters.addAll(charactersSet);
    }
}
