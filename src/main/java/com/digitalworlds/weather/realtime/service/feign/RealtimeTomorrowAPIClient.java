package com.digitalworlds.weather.realtime.service.feign;

import com.digitalworlds.weather.model.Realtime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(name = "tomorrow-api-realtime", url = "https://api.tomorrow.io/v4/weather/realtime")
public interface RealtimeTomorrowAPIClient {

    @GetMapping()
    HashMap<String, Object> get(@RequestParam String location, @RequestParam String units, @RequestParam String apikey);

}
