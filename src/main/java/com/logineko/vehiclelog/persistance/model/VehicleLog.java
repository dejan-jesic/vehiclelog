package com.logineko.vehiclelog.persistance.model;

import java.time.LocalDateTime;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "vehicle_log")
@DiscriminatorColumn(name = "vehicle_type", discriminatorType = DiscriminatorType.STRING, columnDefinition = "VARCHAR(32)")
public class VehicleLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(column = "Date/Time")
    @CsvDate(value = "MMM d, yyyy, h:MM:ss a")
    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateTime;

    @CsvBindByName(column = "Serial number")
    @Column(columnDefinition = "VARCHAR(128)")
    private String serialNumber;

    @CsvBindByName(column = "GPS longitude [°]")
    @Column(columnDefinition = "DECIMAL")
    private Double longitude;

    @CsvBindByName(column = "GPS latitude [°]")
    @Column(columnDefinition = "DECIMAL")
    private Double latitude;

    @CsvBindByName(column = "Total working hours counter [h]")
    @Column(columnDefinition = "DECIMAL")
    private Double totalWorkingHours;

    @CsvBindByName(column = "Engine speed [rpm]")
    @Column(columnDefinition = "DECIMAL")
    private Double engineSpeed;

    @CsvBindByName(column = "Engine load [%]")
    @Column(columnDefinition = "DECIMAL")
    private Double engineLoad;

}
