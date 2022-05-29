package com.example.customerror.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {

    private Long id;
    private String uid;
    private String dish;
    private String description;
    private String ingredient;
    private String measurement;
}
