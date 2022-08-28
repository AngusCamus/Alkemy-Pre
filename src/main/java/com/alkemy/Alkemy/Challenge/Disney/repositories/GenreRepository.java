package com.alkemy.Alkemy.Challenge.Disney.repositories;

import com.alkemy.Alkemy.Challenge.Disney.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}
