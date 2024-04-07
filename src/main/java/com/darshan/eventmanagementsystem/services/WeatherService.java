package com.darshan.eventmanagementsystem.services;


import com.darshan.eventmanagementsystem.dtos.ResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private RestTemplate restTemplate;
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeather() {
        String weather_Url = restTemplate.getForObject(
                "https://gg-backend-assignment.azurewebsites.net/api/Weather?code=KfQnTWHJbg1giyB_Q9Ih3Xu3L9QOBDTuU5zwqVikZepCAzFut3rqsg==&city=Port%20Rebeccaberg&date=2024-03-01",
                String.class
        );
        if(weather_Url == null) {
            return "Weather not found";
        }
        System.out.println("hello there");
        return weather_Url;
    }
}

