package com.alkemy.Alkemy.Challenge.Disney.repositories;

import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterFilterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.entities.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> , JpaSpecificationExecutor<CharacterFilterDTO> {

    List<CharacterEntity> findAllBySpec(Specification<CharacterEntity> spec);
}
