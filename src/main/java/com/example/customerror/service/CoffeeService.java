package com.example.customerror.service;

import com.example.customerror.domain.Coffee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CoffeeService {

    private final RestTemplate restTemplate;

    public Coffee getCoffee(){
        String coffeeUrl = "https://random-data-api.com/api/coffee/random_coffee";
        try {
            return restTemplate.getForObject(coffeeUrl, Coffee.class);
        }catch (Exception e){
            throw new IllegalArgumentException("SOMETHING WENT WRONG");
        }

    }
}
