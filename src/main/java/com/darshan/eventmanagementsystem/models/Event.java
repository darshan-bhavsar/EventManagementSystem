package com.darshan.eventmanagementsystem.models;



import com.darshan.eventmanagementsystem.config.LocalTimeConverter;
import com.darshan.eventmanagementsystem.config.LocalDateConverter;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CsvBindByName(column = "event_name")
    private String eventName;

    @CsvBindByName(column = "city_name  ")
    private String cityName;

    @CsvCustomBindByName(column = "date", converter = LocalDateConverter.class)
    private LocalDate date;

    @CsvCustomBindByName(column = "time", converter = LocalTimeConverter.class)
    private LocalTime time;

    @CsvBindByName(column = "latitude")
    private Double latitude;

    @CsvBindByName(column = "longitude")
    private Double longitude;

    // getters and setters
}
