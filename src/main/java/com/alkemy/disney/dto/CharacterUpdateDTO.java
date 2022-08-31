package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CharacterUpdateDTO {

    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String history;

}