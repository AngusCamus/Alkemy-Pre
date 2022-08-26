package com.alkemy.Alkemy.Challenge.Disney.services;


import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterUpdateDTO;

import java.util.List;

public interface CharacterService {

    //obterner 1
    CharacterDTO getById(Long id);
    //obtener lista
    List<CharacterDTO> getAllCharacters();
    //crear
    CharacterDTO createCharacter(CharacterDTO dto);
    //eliminar
    CharacterDTO deleteCharacterById(Long id);
    //update
    CharacterDTO updateCharacter(CharacterUpdateDTO dto, Long id);


}
