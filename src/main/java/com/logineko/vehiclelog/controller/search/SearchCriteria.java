package com.logineko.vehiclelog.controller.search;

import static com.logineko.vehiclelog.controller.search.SearchOperation.EQUALS;

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
