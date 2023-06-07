package com.digitalworlds.weather.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherDTO {

    private String location;
    private String fields;
    private String timesteps;
    private String units;

}
