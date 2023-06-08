package com.digitalworlds.weather.timeline.service;

import com.digitalworlds.weather.model.Timeline;
import com.digitalworlds.weather.timeline.dto.TimelineDTO;

import java.util.List;

public interface TimelineService {
    List<Timeline> getWeather(TimelineDTO request);
}
