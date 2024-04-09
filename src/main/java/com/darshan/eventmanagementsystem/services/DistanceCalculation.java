package com.darshan.eventmanagementsystem.services;


import com.darshan.eventmanagementsystem.models.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceCalculation
{
    private RestTemplate restTemplate;

    public Double getDistance(Double latitude1,Double longitude1,Double latitude2,Double longitude2){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gg-backend-assignment.azurewebsites.net/api/Distance?code=IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==&latitude1=" + latitude1 + "&longitude1=" + longitude1 + "&latitude2=" + latitude2 + "&longitude2=" + longitude2;

        DistanceResponse response = restTemplate.getForObject(url, DistanceResponse.class);

        if(response.getDistance() == null){
            System.out.println("Distance not found");
            return 0.0;
        }
        return Double.parseDouble(response.getDistance());
    }
}
