package com.logineko.vehiclelog.web.search;

import java.util.ArrayList;
import java.util.List;

import com.logineko.vehiclelog.persistance.model.CreeperStatus;
import com.logineko.vehiclelog.persistance.model.VehicleLog;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class VehicleLogSpecification implements Specification<VehicleLog> {
    
    private final List<SearchCriteria> searchCriteria;

    @Override
    public Predicate toPredicate(final Root<VehicleLog> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
        final List<Predicate> predicates = new ArrayList<>();
        for (final SearchCriteria criteria : searchCriteria) {
            switch (criteria.operation()) {
                case GREATER_THAN -> predicates.add(builder.greaterThan(root.get(criteria.field()), criteria.value().toString()));
                case LESS_THAN -> predicates.add(builder.lessThan(root.get(criteria.field()), criteria.value().toString()));
                case EQUALS -> predicates.add(builder.equal(root.get(criteria.field()), castToEnumOrString(criteria.value())));
                case CONTAINS -> predicates.add(builder.like(root.get(criteria.field()), "%" + criteria.value() + "%"));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }

    private Object castToEnumOrString(final Object value) {
        for (final CreeperStatus creeperStatus : CreeperStatus.values()) {
            if (creeperStatus.name().equalsIgnoreCase(value.toString())) {
                return creeperStatus;
            }
        }
        return value;
    }

}
