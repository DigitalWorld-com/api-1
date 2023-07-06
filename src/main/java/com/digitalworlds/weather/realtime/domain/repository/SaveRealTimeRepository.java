package com.digitalworlds.weather.realtime.domain.repository;

import com.digitalworlds.weather.realtime.domain.model.Realtime;

public interface SaveRealTimeRepository {
    Realtime save(Realtime realtime);
}
