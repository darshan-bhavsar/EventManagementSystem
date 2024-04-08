package com.darshan.eventmanagementsystem.controllers;


import com.darshan.eventmanagementsystem.dtos.EventFinderRequestDto;
import com.darshan.eventmanagementsystem.dtos.ResponseDto;
import com.darshan.eventmanagementsystem.models.Event;
import com.darshan.eventmanagementsystem.services.EventFinderService;
import com.darshan.eventmanagementsystem.services.EventReaderService;
import com.darshan.eventmanagementsystem.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.json.JSONException;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class Hello {

    private EventReaderService eventReaderService;
    private EventFinderService eventFinderService;

    private ResponseDto responseDto;
    private WeatherService weatherService;


    public Hello(EventReaderService eventReaderService, EventFinderService eventFinderService,WeatherService weatherService){
        this.eventReaderService = eventReaderService;
        this.eventFinderService = eventFinderService;
        this.weatherService = weatherService;
    }

    @GetMapping("/find") // GET /events/find
    public List<ResponseDto> eventFinder(@RequestParam Double latitude, @RequestParam Double longitude, @RequestParam LocalDate date){
        List<Event> event = eventFinderService.findEvent(latitude,longitude,date);
        if(event.size() == 0){
            System.out.println("Event is not found");
        }else {
            System.out.println("Event is found successfully");
        }
         List<ResponseDto> list = new ArrayList<>();
        for(Event e : event){
            ResponseDto responseDto = new ResponseDto();
            String jsonStr = e.getWeather();
            //Double distancedouble = e.getDistance_km();
            JSONObject jsonObj = new JSONObject(jsonStr);
            //JSONObject jsonObj1 = new JSONObject(distancedouble);
            //System.out.println("weather is " + jsonObj.get("weather"));
            responseDto.setEventName(e.getEventName());
            responseDto.setCity_name(e.getCityName());
            responseDto.setDate(e.getDate());
            responseDto.setWeather((String)jsonObj.get("weather"));
            //System.out.println("weathers is + " + e.getWeather());
            responseDto.setDistance_km(e.getDistance_km());
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
