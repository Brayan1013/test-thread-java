package com.example.customerror.service;

import com.example.customerror.domain.Food;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class FoodService {

    private final RestTemplate restTemplate;

    public Food getFood(){
        String foodUrl = "https://random-data-api.com/api/food/random_food";
        return restTemplate.getForObject(foodUrl, Food.class);
    }

}
