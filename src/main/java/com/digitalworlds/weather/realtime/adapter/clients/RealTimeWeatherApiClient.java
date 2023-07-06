package com.digitalworlds.weather.realtime.adapter.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(name = "weather-api-realtime", url = "${weather-api.url}")
public interface RealTimeWeatherApiClient {

    @GetMapping()
    public HashMap<String, Object> get(@RequestParam String key, @RequestParam String q, @RequestParam String aqi);
}
