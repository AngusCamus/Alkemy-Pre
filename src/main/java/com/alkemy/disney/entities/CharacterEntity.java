<<<<<<< HEAD
package com.alkemy.Disney.entities;
=======
package com.alkemy.disney.entities;
>>>>>>> test


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
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
    private Integer age;
    private Integer weight;
    private String history;
    private boolean deleted = Boolean.FALSE;


    @ManyToMany(mappedBy = "characters")
    private Set<MovieEntity> movies = new HashSet<>();


}
