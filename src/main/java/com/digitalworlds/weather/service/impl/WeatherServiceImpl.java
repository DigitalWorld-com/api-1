package com.digitalworlds.weather.service.impl;

import com.digitalworlds.weather.dto.WeatherDTO;
import com.digitalworlds.weather.model.Weather;
import com.digitalworlds.weather.service.WeatherService;
import com.digitalworlds.weather.service.feign.TomorrowAPIFeignClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {


    @Value("${tomorrow.api.key}")
    private String apikey;

    @NonNull
    private TomorrowAPIFeignClient tomorrowAPIFeignClient;

    @Override
    public List<Weather> getWeather(WeatherDTO request) {
        HashMap<String, Object> result = tomorrowAPIFeignClient.getWeather(request.getLocation(), request.getFields(), request.getTimesteps(), request.getUnits(), apikey);
        HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
        List<Weather> Weathers = (List<Weather>) data.get("timelines");
        return Weathers;
    }
}
