package com.alkemy.Alkemy.Challenge.Disney.services.impl;

import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.CharacterEntity;
import com.alkemy.Alkemy.Challenge.Disney.mappers.CharacterMapper;
import com.alkemy.Alkemy.Challenge.Disney.repositories.CharacterRepository;
import com.alkemy.Alkemy.Challenge.Disney.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {


    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    CharacterMapper characterMapper;


    @Override
    public CharacterDTO getById(Long id) {

        Optional<CharacterEntity> optChar = characterRepository.findById(id);
        CharacterEntity character = optChar.get();

        CharacterDTO charDTO = characterMapper.characterEntity2DTO(character);

        return charDTO;
    }

    @Override
    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entities);
        return result;
    }

    @Override
    public CharacterDTO createCharacter(CharacterDTO dto) {

        CharacterEntity entityNew = characterMapper.characterDTO2Entity(dto);
        characterRepository.save(entityNew);
        CharacterDTO charSaved = characterMapper.characterEntity2DTO(entityNew);

        return charSaved;
    }

    @Override
    public CharacterDTO deleteCharacterById(Long id) {


        return null;
    }

    @Override
    public CharacterDTO updateCharacter(CharacterUpdateDTO dto, Long id) {
        Optional<CharacterEntity> optCharacter = characterRepository.findById(id);
        CharacterEntity character = optCharacter.get();
        CharacterEntity charUpdated = characterMapper.characterUpdateDTO2EntityUpdated(dto, character);
        CharacterDTO dtoUpdated = characterMapper.characterEntity2DTO(charUpdated);
        return dtoUpdated;
    }

}
