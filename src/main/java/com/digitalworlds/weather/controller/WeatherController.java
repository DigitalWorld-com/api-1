package com.digitalworlds.weather.controller;

import com.digitalworlds.weather.dto.WeatherDTO;
import com.digitalworlds.weather.model.Weather;
import com.digitalworlds.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping(value = "weather")
public class WeatherController {

    private WeatherService weatherService;

    @GetMapping()
    public List<Weather> get(WeatherDTO request) {
        return weatherService.getWeather(request);
    }
}
