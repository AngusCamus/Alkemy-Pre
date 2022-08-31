package com.alkemy.disney.services;


import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterUpdateDTO;

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


    List<CharacterBasicDTO> getAllCharacters(String name, Integer age, Set<Long> movies);
}
