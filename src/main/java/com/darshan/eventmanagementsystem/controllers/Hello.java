package com.darshan.eventmanagementsystem.controllers;


import com.darshan.eventmanagementsystem.dtos.EventFinderRequestDto;
import com.darshan.eventmanagementsystem.dtos.ResponseDto;
import com.darshan.eventmanagementsystem.models.Event;
import com.darshan.eventmanagementsystem.services.EventFinderService;
import com.darshan.eventmanagementsystem.services.EventReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class Hello {

    private EventReaderService eventReaderService;
    private EventFinderService eventFinderService;

    private ResponseDto responseDto;
    //private Event event;


    public Hello(EventReaderService eventReaderService, EventFinderService eventFinderService){
        this.eventReaderService = eventReaderService;
        this.eventFinderService = eventFinderService;

    }
    @GetMapping("/find") // GET /events/find
    public List<ResponseDto> eventFinder(@RequestParam Double latitude, @RequestParam Double longitude, @RequestParam LocalDate date){
        List<Event> event = eventFinderService.findEvent(latitude,longitude,date);
        if(event.size() == 0){
            System.out.println("Event is not found");
        }else {
            System.out.println("Event is found successfully");
        }
         ResponseDto responseDto = new ResponseDto();
         List<ResponseDto> list = new ArrayList<>();
        for(Event e : event){
            responseDto.setEventName(e.getEventName());
            responseDto.setCity_name(e.getCityName());
            responseDto.setDate(e.getDate());
            responseDto.setWeather(eventFinderService.getWeatherService());
            responseDto.setDistance_km(2.5);
            list.add(responseDto);
        }
       return list;
    }

    @GetMapping("/create")
    public void createEvent() {
        // create event
        System.out.println("data is processing in  DB");
        System.out.println("processed");
         eventReaderService.readCsvAndSaveInDb("https://drive.google.com/file/d/1sZXyOT_V1NcZj3dDQIKY9Ea_W7XdGum_/view?usp=drive_link");
    }
}
