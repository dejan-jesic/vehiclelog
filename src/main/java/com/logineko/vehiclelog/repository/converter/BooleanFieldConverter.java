package com.logineko.vehiclelog.repository.converter;

import com.logineko.vehiclelog.repository.model.VehicleLog;
import com.opencsv.bean.AbstractBeanField;

public class BooleanFieldConverter extends AbstractBeanField<VehicleLog, Boolean> {

    @Override
    protected Object convert(final String value) {
        return value.equalsIgnoreCase("on") ? Boolean.TRUE : Boolean.FALSE;
    }

}
