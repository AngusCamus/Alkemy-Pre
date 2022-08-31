package com.alkemy.Alkemy.Challenge.Disney.repositories.specifications;


import com.alkemy.Alkemy.Challenge.Disney.dto.MovieFilterDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Component
public class MovieSpec {

    public Specification<MovieEntity> getByFilters(MovieFilterDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getTitle())) {
                predicates.add(
                        criteriaBuilder.like(
                                root.get("title"),
                                filtersDTO.getTitle()
                        )
                );
            }
            if(StringUtils.hasLength(filtersDTO.getGenreId())){
                predicates.add(
                        criteriaBuilder.like(
                                root.get("genreId"),
                                filtersDTO.getGenreId()
                        )
                );
            }

            query.distinct(true);

            String orderByField = "title";

            query.orderBy(
                    filtersDTO.isDESC() ?
                            criteriaBuilder.desc(root.get(orderByField)) :
                            criteriaBuilder.asc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
