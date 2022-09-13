package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CharacterUpdateDTO {

    private String image;
    private String name;
    @Positive
    private Integer age;
    @Positive
    private Integer weight;
    @Length(max = 200)
    private String history;

}