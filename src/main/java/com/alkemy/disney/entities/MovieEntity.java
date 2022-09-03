<<<<<<< HEAD
package com.alkemy.Disney.entities;
=======
package com.alkemy.disney.entities;
>>>>>>> test


import com.alkemy.disney.dto.CharacterCreateDTO;
import com.alkemy.disney.exception.MovieContainsCharacter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
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
            throw new MovieContainsCharacter("The movie contain this character");
        } else {
            characters.add(entity);
        }

    }

    public void delCharacter (Long idCharacter) {
        if(characters.removeIf(e -> e.getId() == idCharacter)){}
        else{ throw new MovieContainsCharacter("Character not found on this movie");}
    }

    public void addCharacters(Set<CharacterEntity> charactersSet) {
        characters.addAll(charactersSet);
    }
}
