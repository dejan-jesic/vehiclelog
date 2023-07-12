package com.logineko.vehiclelog.repository.model;

import com.logineko.vehiclelog.repository.converter.CreeperStatusConverter;
import com.logineko.vehiclelog.repository.converter.DoubleFieldConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("TRACTOR")
public class TractorLog extends VehicleLog {

    @CsvCustomBindByName(column = "Fuel consumption [l/h]", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double fuelConsumption;

    @CsvBindByName(column = "Ground speed gearbox [km/h]")
    @Column(columnDefinition = "DECIMAL")
    private Double groundSpeedGearbox;

    @CsvCustomBindByName(column = "Ground speed radar [km/h]", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double groundSpeedRadar;

    @CsvBindByName(column = "Coolant temperature [°C]")
    @Column(columnDefinition = "DECIMAL")
    private Double coolantTemperature;

    @CsvBindByName(column = "Speed front PTO [rpm]")
    @Column(columnDefinition = "DECIMAL")
    private Double speedFrontPTO;

    @CsvBindByName(column = "Speed rear PTO [rpm]")
    @Column(columnDefinition = "DECIMAL")
    private Double speedRearPTO;

    @CsvCustomBindByName(column = "current gear shift []", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double currentGearShift;

    @CsvBindByName(column = "Ambient temperature [°C]")
    @Column(columnDefinition = "DECIMAL")
    private Double ambientTemperature;

    @CsvBindByName(column = "Parking brake status []")
    @Column(columnDefinition = "DECIMAL")
    private Double parkingBreakStatus;

    @CsvBindByName(column = "Transverse differential lock status []")
    @Column(columnDefinition = "DECIMAL")
    private Double transverseDiffLockStatus;

    @CsvBindByName(column = "All-wheel drive status []")
    @Column(columnDefinition = "varchar(128)")
    private String allWheelDriveStatus;

    @CsvCustomBindByName(column = "Actual status of creeper []", converter = CreeperStatusConverter.class)
    @Column(columnDefinition = "varchar(128)")
    @Enumerated(EnumType.STRING)
    private CreeperStatus creeperStatus;

}
