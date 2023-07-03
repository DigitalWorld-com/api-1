package com.digitalworlds.weather.realtime.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(name = "weather-api-realtime", url = "https://api.weatherapi.com/v1/current.json")
public interface RealTimeWeatherAPICLient {

    @GetMapping()
    public HashMap<String, Object> get(@RequestParam String key, @RequestParam String q, @RequestParam String aqi);
}
