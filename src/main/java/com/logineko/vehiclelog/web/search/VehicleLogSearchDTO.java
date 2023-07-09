package com.logineko.vehiclelog.web.search;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public record VehicleLogSearchDTO(
        @NotEmpty List<SearchCriteria> searchCriteria
) {
}
