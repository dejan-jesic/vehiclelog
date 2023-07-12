package com.logineko.vehiclelog.persistance.converter;

import com.logineko.vehiclelog.persistance.model.VehicleLog;
import com.opencsv.bean.AbstractBeanField;

public class DoubleFieldConverter extends AbstractBeanField<VehicleLog, Double> {

    @Override
    protected Object convert(final String value) {
        return value.equals("NA") ? null : Double.parseDouble(value);
    }

}
