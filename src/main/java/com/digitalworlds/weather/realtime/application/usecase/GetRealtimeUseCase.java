package com.digitalworlds.weather.realtime.application.usecase;

import com.digitalworlds.weather.realtime.application.dto.RequestRealtimeDTO;
import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Realtime;

import java.util.List;

public interface GetRealtimeUseCase {
    Realtime getAndRegister(RequestRealtimeDTO dto);

    List<HistoryRealTime> getHistory();
}
