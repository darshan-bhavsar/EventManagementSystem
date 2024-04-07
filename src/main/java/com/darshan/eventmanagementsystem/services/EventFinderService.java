package com.darshan.eventmanagementsystem.services;


import com.darshan.eventmanagementsystem.dtos.EventFinderRequestDto;
import com.darshan.eventmanagementsystem.dtos.ResponseDto;
import com.darshan.eventmanagementsystem.models.Event;
import com.darshan.eventmanagementsystem.repository.EventRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Getter
@Setter

public class EventFinderService {


    private EventRepository eventRepository;
    private ResponseDto responseDto;
    private WeatherService weatherService;


    public EventFinderService(EventRepository eventRepository, WeatherService weatherService) {
        this.eventRepository = eventRepository;
        this.weatherService = weatherService;
    }

    public String getWeatherService() {
        return weatherService.getWeather();
    }

    public List<Event> findEvent(Double latiude , Double longitude , LocalDate date) {
        List<Event> events = eventRepository.findAll();
        System.out.println("Total events in the database: " + events.size());
        LocalDate dateAfter14Days = date.plusDays(14);
        events = events.stream()
                .filter(event -> (event.getDate().isAfter(date) || event.getDate().isEqual(date)) && event.getDate().isBefore(dateAfter14Days))
                .collect(Collectors.toList());
        System.out.println("Events after filtering by date: " + events.size());

        events.sort(Comparator.comparing(Event::getDate));
        return events;
    }
}
