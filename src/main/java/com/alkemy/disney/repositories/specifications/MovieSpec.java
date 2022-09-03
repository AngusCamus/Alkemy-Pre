package com.alkemy.disney.repositories.specifications;


import com.alkemy.disney.dto.MovieFilterDTO;
import com.alkemy.disney.entities.MovieEntity;
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
                                criteriaBuilder.lower(root.get("title")),
                                "%" + filtersDTO.getTitle().toLowerCase() + "%")

                );
            }
            if(filtersDTO.getGenreId() != null){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("genreId"),
                                filtersDTO.getGenreId().toString()
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
