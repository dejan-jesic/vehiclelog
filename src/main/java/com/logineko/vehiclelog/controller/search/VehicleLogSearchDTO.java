package com.logineko.vehiclelog.controller.search;

import java.util.List;

import com.logineko.vehiclelog.controller.validation.ValidVehicleLogSearch;
import jakarta.validation.constraints.NotEmpty;

@ValidVehicleLogSearch
public record VehicleLogSearchDTO(
        @NotEmpty List<SearchCriteria> searchCriteria
) {
}
