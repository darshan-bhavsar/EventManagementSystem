package com.darshan.eventmanagementsystem.controllers;


import com.darshan.eventmanagementsystem.services.EventReaderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class Hello {

    EventReaderService eventReaderService;
    public Hello(EventReaderService eventReaderService) {
        this.eventReaderService = eventReaderService;
    }

    @GetMapping("/create")
    public void createEvent() {
        // create event
        System.out.println("data is processing in  DB");
         eventReaderService.readCsvAndSaveInDb("https://drive.google.com/file/d/1sZXyOT_V1NcZj3dDQIKY9Ea_W7XdGum_/view?usp=drive_link");
    }
}
