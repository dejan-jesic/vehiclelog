package com.logineko.vehiclelog.web.search;

import java.util.List;

import com.logineko.vehiclelog.web.validation.ValidVehicleLogSearch;
import jakarta.validation.constraints.NotEmpty;

@ValidVehicleLogSearch
public record VehicleLogSearchDTO(
        @NotEmpty List<SearchCriteria> searchCriteria
) {
}
