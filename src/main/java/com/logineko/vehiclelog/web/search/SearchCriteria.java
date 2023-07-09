package com.logineko.vehiclelog.web.search;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SearchCriteria(
        @NotEmpty String field,
        @NotNull SearchOperation operation,
        @NotNull Object value
) {}
