package com.digitalworlds.weather.timeline.service.impl;

import com.digitalworlds.weather.model.Timeline;
import com.digitalworlds.weather.timeline.dto.TimelineDTO;
import com.digitalworlds.weather.timeline.service.TimelineService;
import com.digitalworlds.weather.timeline.service.feign.TimelineTomorrowAPIClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TimelineServiceImpl implements TimelineService {


    @Value("${tomorrow.api.key}")
    private String apikey;

    @NonNull
    private TimelineTomorrowAPIClient timelineClient;

    @Override
    public List<Timeline> getWeather(TimelineDTO request) {
        HashMap<String, Object> result = timelineClient.getWeather(request.getLocation(), request.getFields(), request.getTimesteps(), request.getUnits(), apikey);
        HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
        List<Timeline> timelines = (List<Timeline>) data.get("timelines");
        return timelines;
    }
}
