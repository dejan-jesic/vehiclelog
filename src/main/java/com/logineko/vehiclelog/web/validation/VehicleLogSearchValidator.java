package com.logineko.vehiclelog.web.validation;

import static com.logineko.vehiclelog.web.search.SearchOperation.CONTAINS;
import static com.logineko.vehiclelog.web.search.SearchOperation.EQUALS;
import static com.logineko.vehiclelog.web.search.SearchOperation.GREATER_THAN;
import static com.logineko.vehiclelog.web.search.SearchOperation.LESS_THAN;

import java.util.List;
import java.util.Map;

import com.logineko.vehiclelog.web.search.SearchCriteria;
import com.logineko.vehiclelog.web.search.SearchOperation;
import com.logineko.vehiclelog.web.search.VehicleLogSearchDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VehicleLogSearchValidator implements ConstraintValidator<ValidVehicleLogSearch, VehicleLogSearchDTO> {

    private static final Map<String, List<SearchOperation>> SUPPORTED_SEARCH = Map.of(
            "id", List.of(EQUALS, LESS_THAN, GREATER_THAN),
            "dateTime", List.of(LESS_THAN, GREATER_THAN),
            "serialNumber", List.of(EQUALS, CONTAINS),
            "longitude", List.of(EQUALS, LESS_THAN, GREATER_THAN),
            "latitude", List.of(EQUALS, LESS_THAN, GREATER_THAN),
            "totalWorkingHours", List.of(EQUALS, LESS_THAN, GREATER_THAN),
            "engineSpeed", List.of(EQUALS, LESS_THAN, GREATER_THAN),
            "engineLoad", List.of(EQUALS, LESS_THAN, GREATER_THAN),
            "creeperStatus", List.of(EQUALS),
            "ambientTemperature", List.of(EQUALS, LESS_THAN, GREATER_THAN)
    );

    @Override
    public boolean isValid(final VehicleLogSearchDTO searchDTO, final ConstraintValidatorContext context) {
        for (final SearchCriteria criteria : searchDTO.searchCriteria()) {
            final List<SearchOperation> supportedFields = SUPPORTED_SEARCH.get(criteria.field());
            if (!supportedFields.contains(criteria.operation())) {
                return false;
            }
        }
        return true;
    }

}
