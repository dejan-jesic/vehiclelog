package com.logineko.vehiclelog.repository.model;

import com.logineko.vehiclelog.repository.converter.BooleanFieldConverter;
import com.logineko.vehiclelog.repository.converter.DoubleFieldConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("COMBINE")
public class CombineLog extends VehicleLog {

    @CsvBindByName(column = "Drum speed [rpm]")
    @Column(columnDefinition = "DECIMAL")
    private Double drumSpeed;

    @CsvBindByName(column = "Fan speed [rpm]")
    @Column(columnDefinition = "DECIMAL")
    private Double fanSpeed;

    @CsvBindByName(column = "Rotor / straw walker speed [rpm]")
    @Column(columnDefinition = "DECIMAL")
    private Double rotorSpeed;

    @CsvCustomBindByName(column = "Separation losses [%]", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double separationLosses;

    @CsvCustomBindByName(column = "Sieve losses [%]", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double sieveLosses;

    @CsvCustomBindByName(column = "Chopper []", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean chopper;

    @CsvBindByName(column = "Diesel tank level [%]")
    @Column(columnDefinition = "DECIMAL")
    private Double dieselTankLevel;

    @CsvBindByName(column = "No. of partial widths []")
    @Column(columnDefinition = "DECIMAL")
    private Double partialWidthsCount;

    @CsvBindByName(column = "max. no. of partial widths []")
    @Column(columnDefinition = "DECIMAL")
    private Double partialWidthsMaxCount;

    @CsvCustomBindByName(column = "Front attachment On/Off []", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean frontAttachment;

    @CsvBindByName(column = "Feed rake speed [rpm]")
    @Column(columnDefinition = "DECIMAL")
    private Double feedRakeSpeed;

    @CsvCustomBindByName(column = "Working position [I/O]", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean workingPosition;

    @CsvCustomBindByName(column = "Grain tank unloading [I/O]", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean grainTankUnloading;

    @CsvCustomBindByName(column = "Main drive status [I/O]", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean mainDriveStatus;

    @CsvBindByName(column = "Concave position [mm]")
    @Column(columnDefinition = "DECIMAL")
    private Double concavePosition;

    @CsvBindByName(column = "Upper sieve position [mm]")
    @Column(columnDefinition = "DECIMAL")
    private Double upperSievePosition;

    @CsvBindByName(column = "Lower sieve position [mm]")
    @Column(columnDefinition = "DECIMAL")
    private Double lowerSievePosition;

    @CsvCustomBindByName(column = "Grain tank 70 [I/O]", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean grainTank70;

    @CsvCustomBindByName(column = "Grain tank 100 [I/O]", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean grainTank100;

    @CsvCustomBindByName(column = "Grain moisture content [%]", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double grainMoistureContent;

    @CsvBindByName(column = "Throughput [t/h]")
    @Column(columnDefinition = "DECIMAL")
    private Double throughput;

    @CsvCustomBindByName(column = "Radial spreader speed [rpm]", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double radialSpreaderSpeed;

    @CsvBindByName(column = "Grain in returns [%]")
    @Column(columnDefinition = "DECIMAL")
    private Double grainInReturnsPercentage;

    @CsvBindByName(column = "Channel position [%]")
    @Column(columnDefinition = "DECIMAL")
    private Double channelPositionPercentage;

    @CsvCustomBindByName(column = "Yield measurement [I/O]", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean yieldMeasurement;

    @CsvBindByName(column = "Returns auger measurement [%]")
    @Column(columnDefinition = "DECIMAL")
    private Double returnsAugerMeasurementPercentage;

    @CsvCustomBindByName(column = "Moisture measurement []", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean moistureMeasurement;

    @CsvBindByName(column = "Type of crop []")
    @Column(columnDefinition = "VARCHAR(128)")
    private String cropType;

    @CsvBindByName(column = "Specific crop weight [g/l]")
    @Column(columnDefinition = "DECIMAL")
    private Double specificCropWeight;

    @CsvCustomBindByName(column = "Auto Pilot status []", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean autoPilotStatus;

    @CsvCustomBindByName(column = "Cruise Pilot status []", converter = BooleanFieldConverter.class)
    @Column(columnDefinition = "BOOLEAN")
    private Boolean cruisePilotStatus;

    @CsvBindByName(column = "Rate of work [ha/h]")
    @Column(columnDefinition = "DECIMAL")
    private Double rateOfWork;

    @CsvCustomBindByName(column = "Yield [t/ha]", converter = DoubleFieldConverter.class)
    @Column(columnDefinition = "DECIMAL")
    private Double yield;

    @CsvBindByName(column = "Quantimeter calibration factor []")
    @Column(columnDefinition = "DECIMAL")
    private Double quantimeterCalibrationFactor;

    @CsvBindByName(column = "Separation sensitivity [%]")
    @Column(columnDefinition = "DECIMAL")
    private Double separationSensitivityPercentage;

    @CsvBindByName(column = "Sieve sensitivity [%]")
    @Column(columnDefinition = "DECIMAL")
    private Double sieveSensitivityPercentage;

}
