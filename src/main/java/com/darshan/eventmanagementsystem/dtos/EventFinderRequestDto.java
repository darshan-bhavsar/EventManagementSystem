package com.darshan.eventmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class EventFinderRequestDto {
    private double latitude;
    private double longitude;
    private LocalDate date;
}
