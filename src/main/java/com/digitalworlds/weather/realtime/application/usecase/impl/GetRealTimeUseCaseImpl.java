package com.digitalworlds.weather.realtime.application.usecase.impl;

import com.digitalworlds.annotations.UseCase;
import com.digitalworlds.weather.realtime.application.dto.RequestRealtimeDTO;
import com.digitalworlds.weather.realtime.application.usecase.GetRealtimeUseCase;
import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Realtime;
import com.digitalworlds.weather.realtime.domain.service.GetRealTime;
import com.digitalworlds.weather.realtime.domain.service.impl.GetRealtimeService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class GetRealTimeUseCaseImpl implements GetRealtimeUseCase {
    private final GetRealTime getService;

    @Override
    public Realtime getAndRegister(RequestRealtimeDTO dto) {
        return getService.getAndRegister(dto.getLocation(), dto.getUnits());
    }

    @Override
    public List<HistoryRealTime> getHistory() {
        return getService.getHistory();
    }
}
