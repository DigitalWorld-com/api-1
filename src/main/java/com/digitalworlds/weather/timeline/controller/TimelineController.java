package com.digitalworlds.weather.timeline.controller;

import com.digitalworlds.weather.model.Timeline;
import com.digitalworlds.weather.timeline.dto.TimelineDTO;
import com.digitalworlds.weather.timeline.service.TimelineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping(value = "timeline")
public class TimelineController {

    private TimelineService timelineService;

    @GetMapping()
    public List<Timeline> get(TimelineDTO request) {
        return timelineService.getWeather(request);
    }
}
