package com.logineko.vehiclelog.web.search;

import static com.logineko.vehiclelog.web.search.SearchOperation.EQUALS;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SearchCriteria(
        @NotEmpty String field,
        SearchOperation operation,
        @NotNull Object value
) {
    public SearchCriteria {
        if (operation == null) {
            operation = EQUALS;
        }
    }
}
