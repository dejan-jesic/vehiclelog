package com.logineko.vehiclelog.config;

import com.logineko.vehiclelog.persistance.model.VehicleLog;
import com.opencsv.bean.AbstractBeanField;

public class BooleanFieldConverter extends AbstractBeanField<VehicleLog, Boolean> {

    @Override
    protected Object convert(final String value) {
        return value.equalsIgnoreCase("on") ? Boolean.TRUE : Boolean.FALSE;
    }

}
