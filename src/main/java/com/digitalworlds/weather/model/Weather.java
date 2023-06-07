package com.digitalworlds.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Weather {

    private String timestep;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
    private List<WeatherDetail> intervals;

}
