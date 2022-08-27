package com.alkemy.Alkemy.Challenge.Disney.repositories.specifications;

import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterFilterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.entities.CharacterEntity;
import com.alkemy.Alkemy.Challenge.Disney.dto.entities.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CharacterSpec {

    public Specification<CharacterEntity> getByFilters(CharacterFilterDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                        "%" + filtersDTO.getName().toLowerCase() + "%")
                );

            };
            if (StringUtils.hasLength(filtersDTO.getAge().toString())){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("age"),
                                filtersDTO.getAge()
                        )
                );
            };
            if (CollectionUtils.isEmpty(filtersDTO.getMovies())){
                Join<CharacterEntity, MovieEntity> join = root.join("movies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            };

            query.distinct(true);

            String orderByField = "name";
            query.orderBy(criteriaBuilder.asc(root.get(orderByField)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
