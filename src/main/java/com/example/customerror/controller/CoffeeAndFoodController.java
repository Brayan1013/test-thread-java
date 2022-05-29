package com.example.customerror.controller;

import com.example.customerror.domain.Coffee;
import com.example.customerror.domain.CoffeeAndFood;
import com.example.customerror.domain.Food;
import com.example.customerror.service.CoffeeService;
import com.example.customerror.service.FoodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class CoffeeAndFoodController {

    private final FoodService foodService;
    private final CoffeeService coffeeService;

    @GetMapping("/food")
    public Food getFood(){
        log.info("GETTING INTO THE CONTROLLER");
        return foodService.getFood();
    }

    @GetMapping("/coffee")
    public Coffee getCoffee(){
        log.info("GETTING INTO THE CONTROLLER FOR COFFEE");
        return coffeeService.getCoffee();
    }

    @GetMapping("/coffee/food")
    public CoffeeAndFood getCoffeeAndFood(){
        log.info("GETTING INTO THE CONTROLLER FOR COFFEESANDFOOD");
        log.info("THIS IS A SIMPLE CHANGE");
        Food food = foodService.getFood();
        Coffee coffee = coffeeService.getCoffee();
        try {
            return CoffeeAndFood.builder()
                    .food(food)
                    .coffee(coffee)
                    .build();
        }catch (Exception e){
            throw new IllegalArgumentException("YOU DONT HAVE INTERNET");
        }
    }
}
