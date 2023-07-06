package com.digitalworlds.weather.realtime.domain.repository;

import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Realtime;

import java.util.List;

public interface GetRealTimeRepository {
    Realtime get(String location, String units);

    List<HistoryRealTime> getHistory();
}
