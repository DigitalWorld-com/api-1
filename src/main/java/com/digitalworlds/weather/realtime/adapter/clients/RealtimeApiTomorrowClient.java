package com.digitalworlds.weather.realtime.adapter.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(name = "tomorrow-api-realtime", url = "${api-tomorrow.url}/realtime")
public interface RealtimeApiTomorrowClient {

    @GetMapping()
    HashMap<String, Object> get(@RequestParam String location, @RequestParam String units, @RequestParam String apikey);

}
