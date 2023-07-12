package com.logineko.vehiclelog.repository.converter;

import com.logineko.vehiclelog.repository.model.CreeperStatus;
import com.logineko.vehiclelog.repository.model.VehicleLog;
import com.opencsv.bean.AbstractBeanField;

public class CreeperStatusConverter extends AbstractBeanField<VehicleLog, CreeperStatus> {

    @Override
    protected Object convert(final String value) {
        return CreeperStatus.valueOf(value.toUpperCase());
    }

}
