package com.darshan.eventmanagementsystem.services;


import com.darshan.eventmanagementsystem.dtos.ResponseDto;
import com.darshan.eventmanagementsystem.models.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class WeatherService {
    private RestTemplate restTemplate;
    private Event event;

    public String getWeather(String city, LocalDate date) {
        Event e = new Event();
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gg-backend-assignment.azurewebsites.net/api/Weather?code=KfQnTWHJbg1giyB_Q9Ih3Xu3L9QOBDTuU5zwqVikZepCAzFut3rqsg==&city=" + city + "&date=" + date;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCodeValue() == 200) {
            return response.getBody();
        } else {
            // handle error
            return "weather not found";
        }
    }
}

