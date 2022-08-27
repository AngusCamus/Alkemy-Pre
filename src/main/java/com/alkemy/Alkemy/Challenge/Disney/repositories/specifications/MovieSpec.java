package com.alkemy.Alkemy.Challenge.Disney.repositories.specifications;


import com.alkemy.Alkemy.Challenge.Disney.dto.MovieFilterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.entities.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class MovieSpec {

    public Specification<MovieEntity> getByFilters(MovieFilterDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getTitle())){}
                predicates.add(
                        criteriaBuilder.like(
                                root.get("title"),
                                filtersDTO.getTitle()
                        )
                );

            if(StringUtils.hasLength(filtersDTO.getGenre().toString())){
                predicates.add(
                        criteriaBuilder.like(
                                root.get("genreId"),
                                filtersDTO.getGenre().getId().toString()
                        )
                );
            }

            query.distinct(true);

            String orderByField = "title";

            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
