package com.example.customerror.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee {

    private Long id;
    private String uid;
    @JsonProperty("blend_name")
    private String blendName;
    private String origin;
    private String variety;
    private String notes;
    private String intensifier;

}
