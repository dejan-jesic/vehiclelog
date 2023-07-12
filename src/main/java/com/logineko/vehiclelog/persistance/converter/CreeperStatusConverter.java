package com.logineko.vehiclelog.persistance.converter;

import com.logineko.vehiclelog.persistance.model.CreeperStatus;
import com.logineko.vehiclelog.persistance.model.VehicleLog;
import com.opencsv.bean.AbstractBeanField;

public class CreeperStatusConverter extends AbstractBeanField<VehicleLog, CreeperStatus> {

    @Override
    protected Object convert(final String value) {
        return CreeperStatus.valueOf(value.toUpperCase());
    }

}
