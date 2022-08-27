package com.alkemy.Alkemy.Challenge.Disney.services;


import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterUpdateDTO;

import java.util.List;
import java.util.Set;

public interface CharacterService {

    //obterner 1
    CharacterDTO getById(Long id);
    //obtener lista
    List<CharacterDTO> getAllCharacters();
    //crear
    CharacterDTO createCharacter(CharacterDTO dto);
    //eliminar
    void deleteCharacterById(Long id);
    //update
    CharacterDTO updateCharacter(CharacterUpdateDTO dto, Long id);


    List<CharacterBasicDTO> getByFilters(String name, Integer age, Set<Long> movies);
}
