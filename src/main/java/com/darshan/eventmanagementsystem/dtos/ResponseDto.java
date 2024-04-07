package com.darshan.eventmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
public class ResponseDto {
    private String eventName;
    private String city_name;
    private LocalDate date;
    private String weather;
    private double distance_km;
}
