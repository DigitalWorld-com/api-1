package com.digitalworlds.weather.realtime.controller;

import com.digitalworlds.weather.realtime.model.Realtime;
import com.digitalworlds.weather.realtime.dto.RealtimeDTO;
import com.digitalworlds.weather.realtime.service.RealtimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "realtime")
public class RealtimeController {

    private final RealtimeService realtimeService;

    @GetMapping()
    private Realtime get(RealtimeDTO request) {
        return realtimeService.getRealTime(request);
    }
}
