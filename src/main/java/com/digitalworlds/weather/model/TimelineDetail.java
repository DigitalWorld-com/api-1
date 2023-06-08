package com.digitalworlds.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimelineDetail {
    private LocalDateTime startTime;
    private HashMap<String, String> temperature;
}
