package com.alkemy.disney.dto;

import com.alkemy.disney.entities.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext;

import javax.persistence.*;
import java.util.List;

@Getter@Setter
public class GenreCreateDTO {

    private String name;
    private String image;

}
