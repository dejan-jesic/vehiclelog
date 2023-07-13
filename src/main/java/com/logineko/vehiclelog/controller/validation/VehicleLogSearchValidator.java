package com.logineko.vehiclelog.controller.validation;

import static com.logineko.vehiclelog.controller.search.SearchOperation.CONTAINS;
import static com.logineko.vehiclelog.controller.search.SearchOperation.EQUALS;
import static com.logineko.vehiclelog.controller.search.SearchOperation.GREATER_THAN;
import static com.logineko.vehiclelog.controller.search.SearchOperation.LESS_THAN;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logineko.vehiclelog.controller.search.SearchCriteria;
import com.logineko.vehiclelog.controller.search.SearchOperation;
import com.logineko.vehiclelog.controller.search.VehicleLogSearchDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VehicleLogSearchValidator implements ConstraintValidator<ValidVehicleLogSearch, VehicleLogSearchDTO> {

    private static final Map<String, List<SearchOperation>> SUPPORTED_SEARCH = new HashMap<>();

    static {
        SUPPORTED_SEARCH.put("id", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("dateTime", List.of(LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("serialNumber", List.of(EQUALS, CONTAINS));
        SUPPORTED_SEARCH.put("longitude", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("latitude", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("totalWorkingHours", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("engineSpeed", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("engineLoad", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("creeperStatus", List.of(EQUALS));
        SUPPORTED_SEARCH.put("ambientTemperature", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("channelPositionPercentage", List.of(EQUALS, LESS_THAN, GREATER_THAN));
        SUPPORTED_SEARCH.put("cropType", List.of(EQUALS, CONTAINS));
    }

    @Override
    public boolean isValid(final VehicleLogSearchDTO searchDTO, final ConstraintValidatorContext context) {
        for (final SearchCriteria criteria : searchDTO.searchCriteria()) {
            final List<SearchOperation> supportedFields = SUPPORTED_SEARCH.get(criteria.field());
            if (supportedFields == null || !supportedFields.contains(criteria.operation())) {
                return false;
            }
        }
        return true;
    }

}
