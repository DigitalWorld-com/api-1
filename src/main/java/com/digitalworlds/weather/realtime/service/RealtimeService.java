package com.digitalworlds.weather.realtime.service;

import com.digitalworlds.weather.model.Realtime;
import com.digitalworlds.weather.realtime.dto.RealtimeDTO;

public interface RealtimeService {
    public Realtime getRealTime(RealtimeDTO request);
}
