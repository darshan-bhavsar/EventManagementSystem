package com.darshan.eventmanagementsystem.services;


import com.darshan.eventmanagementsystem.models.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceCalculation
{
    private RestTemplate restTemplate;
    private Event event;
    public Double getDistance(Double latitude1,Double longitude1,Double latitude2,Double longitude2){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gg-backend-assignment.azurewebsites.net/api/Distance?code=IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==&latitude1=" + latitude1 + "&longitude1=" + longitude1 + "&latitude2=" + latitude2 + "&longitude2=" + longitude2;

        Double response= restTemplate.getForObject(url, Double.class);
        if(response == null){
            System.out.println("Distance not found");
            return 0.0;
        }

        return response;
//"https://gg-backend-assignment.azurewebsites.net/api/Distance?code=IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==&latitude1=40.7128&longitude1=-74.0060&latitude2=25.5169968004073&longitude2=-173.22570039222800"
    }
}
