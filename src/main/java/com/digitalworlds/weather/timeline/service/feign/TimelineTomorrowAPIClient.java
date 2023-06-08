package com.digitalworlds.weather.timeline.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(name = "tomorrow-api-timelines", url = "https://api.tomorrow.io/v4/timelines")
public interface TimelineTomorrowAPIClient {

    @GetMapping()
    HashMap<String, Object> getWeather(@RequestParam String location, @RequestParam String fields, @RequestParam String timesteps, @RequestParam String units, @RequestParam String apikey);

}
