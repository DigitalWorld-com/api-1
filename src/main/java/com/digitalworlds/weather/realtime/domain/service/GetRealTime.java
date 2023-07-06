package com.digitalworlds.weather.realtime.domain.service;

import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Realtime;

import java.util.List;

public interface GetRealTime {
    Realtime get(String location, String units);
    Realtime getAndRegister(String location, String units);

    List<HistoryRealTime> getHistory();
}
