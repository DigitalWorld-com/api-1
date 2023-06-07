package com.digitalworlds.weather.service;

import com.digitalworlds.weather.dto.WeatherDTO;
import com.digitalworlds.weather.model.Weather;

import java.util.List;

public interface WeatherService {
    List<Weather> getWeather(WeatherDTO request);
}
